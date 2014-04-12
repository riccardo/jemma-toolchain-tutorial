package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.activator;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@ApplicationPath("/myapp")
public class SampleApplication extends Application {

	private static final Logger LOG = LoggerFactory.getLogger( SampleApplication.class );

    @Override
    public Set<Class<?>> getClasses() {
    	LOG.debug("SampleApplication called");
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(SampleResource.class);
        s.add(AnotherSampleResource.class);
        LOG.debug("SampleApplication returning ",s);
        return s;
    }
}