package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.activator;

import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.impl.publicimpl.SampleApplication;
import org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.impl.publicimpl.SampleServlet;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator{
	
    private final String _path = "/";
    private BundleContext _context;
    private ServiceTracker _tracker;
	
	private static final Logger LOG = LoggerFactory.getLogger( Activator.class );

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
	
	
	
	
	
	

/*
    public void start(BundleContext context) throws Exception {

       

        // Use _tracker to capture when a HttpService comes and goes.
        //
        // When this bundle is started, a HttpService may not be alive. Thus, we use
        // ServiceTracker to automatically monitor when a HttpService comes alive and
        // then register this our CXF-based JAX-RS service with it.
        //
        _tracker = new ServiceTracker(
            _context,
            HttpService.class.getName(),
            new ServiceTrackerCustomizer() {
                public Object addingService(ServiceReference serviceReference) {
                    try {
                        HttpService service = (HttpService)_context.getService(serviceReference);
                        Dictionary<String, String> initParams = new Hashtable<String, String>();
                        initParams.put("javax.ws.rs.Application", SampleApplication.class.getName());
                        service.registerServlet(_path, new SampleServlet(), initParams, null);
                        return service;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new RuntimeException(ex);
                    }
                }

                public void modifiedService(ServiceReference serviceReference, Object o) {
                    // do nothing
                }

                public void removedService(ServiceReference serviceReference, Object o) {
                    HttpService service = (HttpService)_context.getService(serviceReference);
                    if (service != null) {
                        service.unregister(_path);
                    }
                }
            }
        );
        _tracker.open();

    }

    public void stop(BundleContext bundleContext) throws Exception {
        _tracker.remove(_tracker.getServiceReference());
    }	*/
	
	

}
