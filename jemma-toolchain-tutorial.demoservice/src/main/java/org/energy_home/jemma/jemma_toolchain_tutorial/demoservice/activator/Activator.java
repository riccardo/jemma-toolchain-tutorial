package org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{

	@Override
	public void start(BundleContext arg0) throws Exception {
		System.out.println("starting " + arg0);
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		System.out.println("stopping " + arg0);
		
	}

}
