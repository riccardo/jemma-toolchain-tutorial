package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.activator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnotherSampleResource {
	private static final Logger LOG = LoggerFactory.getLogger( AnotherSampleResource.class );

    @GET
    @Path("/anotherrespath")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSampleText() {
    	LOG.info("getSampleText called");
        return "My Sample Text";
    }

}
