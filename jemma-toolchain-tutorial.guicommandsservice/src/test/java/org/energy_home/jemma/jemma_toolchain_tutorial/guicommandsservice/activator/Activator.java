package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.activator;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.ServletException;

import org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.impl.JerseyApplication;
import org.glassfish.jersey.servlet.ServletContainer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

    private BundleContext bc;
    private ServiceTracker tracker;
    private HttpService httpService = null;
    private static final Logger LOG = LoggerFactory.getLogger( Activator.class );

    @Override
    public synchronized void start(BundleContext bundleContext) throws Exception {
        this.bc = bundleContext;

        LOG.info("STARTING HTTP SERVICE BUNDLE");

        this.tracker = new ServiceTracker(this.bc, HttpService.class.getName(), null) {

          @Override
          public Object addingService(ServiceReference serviceRef) {
             httpService = (HttpService)super.addingService(serviceRef);
             registerServlets();
             return httpService;
          }

          @Override
            public void removedService(ServiceReference ref, Object service) {
                if (httpService == service) {
                    unregisterServlets();
                    httpService = null;
                }
                super.removedService(ref, service);
            }
        };

        this.tracker.open();

        LOG.info("HTTP SERVICE BUNDLE STARTED");
    }


    @Override
    public synchronized void stop(BundleContext bundleContext) throws Exception {
        this.tracker.close();
    }

    private void registerServlets() {
        try {
            rawRegisterServlets();
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        } catch (ServletException se) {
            throw new RuntimeException(se);
        } catch (NamespaceException se) {
            throw new RuntimeException(se);
        }
    }

    private void rawRegisterServlets() throws ServletException, NamespaceException, InterruptedException {
        LOG.info("JERSEY BUNDLE: REGISTERING SERVLETS");
        LOG.info("JERSEY BUNDLE: HTTP SERVICE = " + httpService.toString());

        // TODO - temporary workaround
        // This is a workaround related to issue JERSEY-2093; grizzly (1.9.5) needs to have the correct context
        // classloader set
        ClassLoader myClassLoader = getClass().getClassLoader();
        ClassLoader originalContextClassLoader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(myClassLoader);
           httpService.registerServlet("/jersey-http-service", new ServletContainer(), getJerseyServletParams(), null);
        } finally {
            Thread.currentThread().setContextClassLoader(originalContextClassLoader);
        }
        // END of workaround - after grizzly updated to the recent version, only the inner call from try block will remain:
        // httpService.registerServlet("/jersey-http-service", new ServletContainer(), getJerseyServletParams(), null);

        sendAdminEvent();
        LOG.info("JERSEY BUNDLE: SERVLETS REGISTERED");
    }

    private void sendAdminEvent() {
        ServiceReference eaRef = bc.getServiceReference(EventAdmin.class.getName());
        if (eaRef != null) {
            EventAdmin ea = (EventAdmin) bc.getService(eaRef);
            ea.sendEvent(new Event("jersey/test/DEPLOYED", new HashMap<String, String>() {
                {
                    put("context-path", "/");
                }
            }));
            bc.ungetService(eaRef);
        }
    }

    private void unregisterServlets() {
        if (this.httpService != null) {
            LOG.info("JERSEY BUNDLE: UNREGISTERING SERVLETS");
            httpService.unregister("/jersey-http-service");
            LOG.info("JERSEY BUNDLE: SERVLETS UNREGISTERED");
        }
    }

    @SuppressWarnings("UseOfObsoleteCollectionType")
    private Dictionary<String, String> getJerseyServletParams() {
        Dictionary<String, String> jerseyServletParams = new Hashtable<String, String>();
        jerseyServletParams.put("javax.ws.rs.Application", JerseyApplication.class.getName());
        return jerseyServletParams;
    }
}

