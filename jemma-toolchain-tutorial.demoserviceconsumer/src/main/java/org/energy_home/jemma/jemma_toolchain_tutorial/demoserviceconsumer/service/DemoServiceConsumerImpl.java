package org.energy_home.jemma.jemma_toolchain_tutorial.demoserviceconsumer.service;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.api.DemoService;
import org.energy_home.jemma.jemma_toolchain_tutorial.demoserviceconsumer.impl.DemoServiceConsumerRunner;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class DemoServiceConsumerImpl implements ManagedService{
	protected long periodicity_ms=1000;
	private DemoService demoservice;
	private DemoServiceConsumerRunner runner;
	
	protected void activate() {
		System.out.println("Activating DemoConsumerService");
		
		//configure(context.getProperties());
		//System.out.println("Config on load: [periodicity_ms="+periodicity_ms+"]");
		
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

	@Override
	public void updated(Dictionary<String, ?> props)
			throws ConfigurationException {
		
		//inspired from http://felix.apache.org/documentation/subprojects/apache-felix-config-admin.html
		
        if (props == null) {
            // no configuration from configuration admin
            // or old configuration has been deleted
        	System.out.println("no conf TBD");
        	this.createDefaultConfiguration();
        	//System.exit(0);
        } else {
            // apply configuration from config admin
        	System.out.println("conf available in DemoServiceConsumer");
        	String tmp_periodicity_ms = (String) props.get("periodicity_ms");
        	this.periodicity_ms=Long.parseLong(tmp_periodicity_ms);
        	System.out.println("periodicity_ms updated to " + this.periodicity_ms);
        	this.runner.setPeriodicity(this.periodicity_ms);
        }
        
        
        
		
	}
	
	private void createDefaultConfiguration() {
		//from http://felix.apache.org/documentation/subprojects/apache-felix-config-admin.html
		//thanks http://stackoverflow.com/questions/6527306/best-technique-for-getting-the-osgi-bundle-context
		BundleContext mycontext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceReference configurationAdminReference = mycontext.getServiceReference(ConfigurationAdmin.class.getName());
		
        if (configurationAdminReference != null) 
        {  
            ConfigurationAdmin confAdmin = (ConfigurationAdmin) mycontext.getService(configurationAdminReference);
            //FIXME maybe the PID can be taken from the DS properties ?
            Configuration config = null;
			try {
				config = confAdmin.getConfiguration("org.energy-home.jemma.jemma-toolchain-tutorial.demoserviceconsumer");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            	Dictionary props = config.getProperties();

            	// if null, the configuration is new
            	if (props == null) {
            	    props = new Hashtable();
            	}

            	// set some properties
            	props.put("periodicity_ms", "1024");

            	// update the configuration
            	try {
					config.update(props);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }  
		
	}



	
	
	
	
	
}
