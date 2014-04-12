package org.energy_home.jemma.jemma_toolchain_tutorial.guicommandsservice.impl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.ws.rs.core.Application;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleServlet extends CXFNonSpringJaxrsServlet {

    private static final long serialVersionUID = -1531317723099896635L;
    
    private static final Logger LOG = LoggerFactory.getLogger( SampleServlet.class );

    @Override
    protected Application createApplicationInstance(String appClassName, ServletConfig servletConfig) 
        throws ServletException {
    	LOG.debug("SampleServlet createApplicationInstance called");
        return new SampleApplication();
    }

}