package org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.impl;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.api.DemoService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.component.ComponentContext;


public class DemoServiceImpl implements DemoService, ManagedService{
	
	private double energy_consumption=0;

	protected void activate() {
		System.out.println("Activating DemoService");
	}
	
	protected void deactivate() {
		System.out.println("Deactivating DemoService");
	}

	@Override
	public double getEnergyConsumption() {
		System.out.println("getEnergyConsumption called, returning: " + this.energy_consumption);
		return this.energy_consumption;
	}

	@Override
	public void updated(Dictionary<String, ?> props)
			throws ConfigurationException {
	
        if (props == null) {
            // no configuration from configuration admin
            // or old configuration has been deleted
        	System.out.println("creating configuration");
        	this.createDefaultConfiguration();

        } else {
            // apply configuration from config admin
        	System.out.println("conf available in DemoService");
        	String tmp_energy_consumption = (String) props.get("energy_consumption");
        	this.energy_consumption=Double.parseDouble(tmp_energy_consumption);
        	System.out.println("energy_consumption updated to " + this.energy_consumption);
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
				config = confAdmin.getConfiguration("org.energy_home.jemma.jemma_toolchain_tutorial.demoservice");
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
            	props.put("energy_consumption", "10");

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
