package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.api;


public interface GUICommandsService {

	//FIXME maybe I can try out a PUT here
	public void Button1Pressed(int button_id);

	//FIXME maybe I can try out a PUT here	
	public void gaugechanged(double value);

	public double getCurrentGaugeLevel();

}
