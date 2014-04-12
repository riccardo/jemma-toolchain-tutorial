package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.activator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleResource {

	private static final Logger LOG = LoggerFactory.getLogger( SampleResource.class );

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public String getSampleText() {
    	LOG.info("getSampleText called");
        return "My Sample Text";
    }

}
