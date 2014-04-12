package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.impl.publicimpl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationPath("/app")
public class SampleApplication extends Application {
	
	private static final Logger LOG = LoggerFactory.getLogger( SampleApplication.class );
	
    @Override
    public Set<Class<?>> getClasses() {
    	LOG.debug("SampleApplication called");
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(SampleResource.class);
        LOG.debug("SampleApplication returning ",s);
        return s;
    }
}