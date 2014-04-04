package org.energy_home.jemma.jemma_toolchain_tutorial.demoserviceconsumer.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator{
	
	private static final Logger LOG = LoggerFactory.getLogger( Activator.class );
	
	@Override
	public void start(BundleContext arg0) throws Exception {
		LOG.debug("starting " + arg0.getBundle().getSymbolicName());
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		LOG.debug("stopping " + arg0.getBundle().getSymbolicName());
		
	}

}
