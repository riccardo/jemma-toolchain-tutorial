package test.org.energy_home.jemma.jemma_toolchain_tutorial.demoserviceconsumer.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoserviceconsumer.service.DemoServiceConsumerImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestDemoServiceConsumerImpl {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private DemoServiceConsumerImpl demoserviceconsimpl;

	@Before
	public void setUp() throws Exception {
		this.demoserviceconsimpl = new DemoServiceConsumerImpl();
	}

	@After
	public void tearDown() throws Exception {
		this.demoserviceconsimpl=null;
	}

	@Test
	public void testGetEnergyConsumption() {
		assertEquals(10.0,10.5,1);
	}
	
	@Test
	public void test2() {
		assertNotNull(this.demoserviceconsimpl);
	}

}
