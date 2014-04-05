package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.api;

public interface GUICommandsService {
	
	public void Button1Pressed(int button_id);
	public void gaugechanged(double value);
	public double getCurrentGaugeLevel();

}
