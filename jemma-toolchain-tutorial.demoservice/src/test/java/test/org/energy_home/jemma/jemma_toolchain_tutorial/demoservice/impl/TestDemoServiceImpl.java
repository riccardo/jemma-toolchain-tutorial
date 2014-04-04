package test.org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.impl;

import static org.junit.Assert.*;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.impl.DemoServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDemoServiceImpl {
	
	private static final Logger LOG = LoggerFactory.getLogger( TestDemoServiceImpl.class );

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LOG.trace("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LOG.trace("tearDownAfterClass");
	}

	private DemoServiceImpl demoserviceimpl;

	@Before
	public void setUp() throws Exception {
		LOG.trace("setUp");
		this.demoserviceimpl = new DemoServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		LOG.trace("tearDown");
		this.demoserviceimpl=null;
	}

	@Test
	public void testGetEnergyConsumption() {
		assertEquals(10.0,this.demoserviceimpl.getEnergyConsumption(),0.1);
	}
	
	@Test
	public void test2() {
		assertNotNull(this.demoserviceimpl);
	}

}
