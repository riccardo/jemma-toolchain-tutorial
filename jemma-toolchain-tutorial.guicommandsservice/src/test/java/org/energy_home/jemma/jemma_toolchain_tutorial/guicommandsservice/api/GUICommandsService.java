package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public interface GUICommandsService {

	//FIXME maybe I can try out a PUT here
	public void Button1Pressed(int button_id);

	//FIXME maybe I can try out a PUT here	
	public void gaugechanged(double value);

	@GET
	@Path("/gaugelevel")
	@Produces("application/json")
	public double getCurrentGaugeLevel();

}
