package org.energy_home.jemma.jemma_toolchain_tutorial.demoserviceconsumer.impl;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.api.DemoService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

public class DemoServiceConsumerImpl implements ManagedService{
	protected long periodicity_ms=1000;
	private DemoService demoservice;
	private DemoServiceConsumerRunner runner;
	
	@Activate 
	public void activate() {
		System.out.println("Activating DemoConsumerService");
		
		//configure(context.getProperties());
		//System.out.println("Config on load: [periodicity_ms="+periodicity_ms+"]");
		
		this.runner = new DemoServiceConsumerRunner(this.periodicity_ms,this.demoservice);
		Thread r = new Thread(this.runner);
		r.start();
		
	}

	@Deactivate
	public void deactivate() {
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



	 public void updated(Dictionary config) throws ConfigurationException {
	  if (!configure(config))
	   return;

	  for (Enumeration<Object> en = config.keys(); en.hasMoreElements();) {
	   Object key = en.nextElement();
	   Object value = config.get(key);
	  }

	 }


	 public void modified(Map<String, Object> config)
	     throws ConfigurationException {

	  try {
		  this.periodicity_ms = (Long) config.get("periodicity_ms");
	  } catch (Exception ex) {
	   ex.printStackTrace();
	  	}
	  }

	 private boolean configure(Dictionary config){
	  if(config == null)
	   return false;
	  
	  Object periodicity_ms = config.get("periodicity_ms");

	  if (periodicity_ms != null) {
	   if (periodicity_ms.getClass().isArray()) {
		   this.periodicity_ms = ((long[]) periodicity_ms)[0];
	   } else {
		   this.periodicity_ms = (Long) periodicity_ms;
	   }
	  }

	  return true;
	 }
	
	
	
	
	
	
}
