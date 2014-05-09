package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("status")
public class StatusResource {

    @GET @Produces("text/plain")
    public String getStatus() {
        //return new MyComplexResource();
    	return "active";
    }

}
