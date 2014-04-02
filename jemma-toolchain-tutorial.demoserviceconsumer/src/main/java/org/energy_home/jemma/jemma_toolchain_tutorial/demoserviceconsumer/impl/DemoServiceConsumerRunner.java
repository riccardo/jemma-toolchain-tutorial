package org.energy_home.jemma.jemma_toolchain_tutorial.demoserviceconsumer.impl;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.api.DemoService;

public class DemoServiceConsumerRunner implements Runnable{

	private long periodicity_ms;
	private boolean active;
	private DemoService demoservice;

	public DemoServiceConsumerRunner(long periodicity_ms,
			DemoService demoservice) {
		System.out.println("DemoServiceConsumerRunner constructor");
		this.periodicity_ms=periodicity_ms;
		this.active=true;
		this.demoservice=demoservice;
	}

	@Override
	public void run() {
		System.out.println("DemoServiceConsumerRunner constructor [periodicity_ms="+this.periodicity_ms+"]");
		
		while(this.active) {
			
			this.action();
			
			System.out.println("DemoServiceConsumerRunner going to sleep for [periodicity_ms="+this.periodicity_ms+"]");
			
			try {
				Thread.sleep(this.periodicity_ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("DemoServiceConsumerRunner greceful ending");
		
	}

	private void action() {
		System.out.println("*** DemoServiceConsumerRunner action! *** ");
		if(this.demoservice!=null) {
			double ret = this.demoservice.getEnergyConsumption();
			System.out.println("DemoServiceConsumerRunner getEnergyConsumption = " + ret);
		} else {
			System.out.println("DemoServiceConsumerRunner null! ");
			
		}
		
	}

	public void stop() {
		System.out.println("DemoServiceConsumerRunner greceful stop");
		this.active=false;
		
	}

	public void setPeriodicity(long periodicity_ms) {
		this.periodicity_ms=periodicity_ms;
		
	}

}
