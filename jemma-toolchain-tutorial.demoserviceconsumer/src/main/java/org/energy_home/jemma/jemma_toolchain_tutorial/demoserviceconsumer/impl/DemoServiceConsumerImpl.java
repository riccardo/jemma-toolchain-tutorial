package org.energy_home.jemma.jemma_toolchain_tutorial.demoserviceconsumer.impl;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.api.DemoService;

public class DemoServiceConsumerImpl {
	protected long periodicity_ms=1000;
	private DemoService demoservice;
	private DemoServiceConsumerRunner runner;
	
	protected void activate() {
		System.out.println("Activating DemoConsumerService");
		this.runner = new DemoServiceConsumerRunner(this.periodicity_ms,this.demoservice);
		Thread r = new Thread(this.runner);
		r.start();
	}
	
	protected void deactivate() {
		System.out.println("Deactivating DemoConsumerService");
		this.runner.stop();
	}
	
	public void bindDemoService(DemoService d) {
		System.out.println("Binding DemoService " + d);
		this.demoservice=d;
	}
	
	public void unbindDemoService(DemoService d) {
		System.out.println("Unbinding DemoService " + d);
		this.demoservice=null;
	}
	

}
