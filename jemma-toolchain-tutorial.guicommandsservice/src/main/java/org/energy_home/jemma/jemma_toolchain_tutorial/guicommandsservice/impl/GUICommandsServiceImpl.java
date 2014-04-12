package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.impl;

import org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.api.GUICommandsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GUICommandsServiceImpl implements GUICommandsService{
	
	private static final Logger LOG = LoggerFactory.getLogger( GUICommandsServiceImpl.class );
	private double gaugelevel=0;

	@Override
	public void gaugechanged(double value) {
		LOG.debug("Gauge changed - value=",value);
	}

	@Override
	public double getCurrentGaugeLevel() {
		LOG.debug("getting gauge level, retuning ",this.gaugelevel);
		return this.gaugelevel;
	}

	@Override
	public void Button1Pressed(int button_id) {
		LOG.debug("Button changed - value=",button_id);
		
	}
	
	protected void activate() {
		LOG.debug("Activating DemoService");
	}
	
	protected void deactivate() {
		LOG.debug("Deactivating DemoService");
	}
	

	

}
