package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("status")
public class StatusResource {

    @GET @Produces(MediaType.APPLICATION_JSON)
    public MyComplexResource getStatus() {
        return new MyComplexResource();
    	//return "active";
    }

}
