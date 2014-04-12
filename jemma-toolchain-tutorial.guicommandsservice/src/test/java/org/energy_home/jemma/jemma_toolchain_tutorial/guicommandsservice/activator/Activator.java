package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.activator;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator{
	
	private static final Logger LOG = LoggerFactory.getLogger( Activator.class );
	private BundleContext _context;
	private ServiceTracker _tracker;
	private final String _path = "/";

	@Override
	public void start(BundleContext context) throws Exception {
		LOG.debug("starting " + context.getBundle().getSymbolicName());
		
		 _context = context;
		 _tracker = new ServiceTracker(_context,HttpService.class.getName(), new MyServiceTrackerCustomizer());
		 _tracker.open();
		 LOG.debug("tracker registered in " + context.getBundle().getSymbolicName());
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		LOG.debug("stopping " + arg0.getBundle().getSymbolicName());
		
	}
	
	public class MyServiceTrackerCustomizer implements ServiceTrackerCustomizer {

		@Override
		public Object addingService(ServiceReference serviceReference) {
			LOG.debug("Adding service " + serviceReference);
			try {
                HttpService service = (HttpService)_context.getService(serviceReference);
                Dictionary<String, String> initParams = new Hashtable<String, String>();
                initParams.put("javax.ws.rs.Application", SampleApplication.class.getName());
                service.registerServlet(_path, new SampleServlet(), initParams, null);
                LOG.debug("returning service " + service);
                return service;
            } catch (Exception ex) {
                LOG.error("Exception",ex);
                throw new RuntimeException(ex);
            }
		}

		@Override
		public void modifiedService(ServiceReference serviceReference, Object arg1) {
			LOG.debug("Service modified ? " + serviceReference);
			LOG.debug("Service modified obj? " + arg1);
			
		}

		@Override
		public void removedService(ServiceReference serviceReference, Object arg1) {
            HttpService service = (HttpService)_context.getService(serviceReference);
            LOG.debug("Removing serviceReference " + serviceReference);
            if (service != null) {
                service.unregister(_path);
            }

			
		}
		
	}

}
