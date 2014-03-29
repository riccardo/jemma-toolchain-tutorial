package org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.impl;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.api.DemoService;


public class DemoServiceImpl implements DemoService{
	
	protected void activate() {
		System.out.println("Activating DemoService");
	}
	
	protected void deactivate() {
		System.out.println("Deactivating DemoService");
	}

	@Override
	public double getEnergyConsumption() {
		double ret = 3.14;
		System.out.println("getEnergyConsumption called, returning: " + ret);
		return ret;
	}

}
