package test.org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.impl;

import static org.junit.Assert.*;

import org.energy_home.jemma.jemma_toolchain_tutorial.demoservice.activator.Activator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestActivator {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Activator activator;

	@Before
	public void setUp() throws Exception {
		this.activator = new Activator();
	}

	@After
	public void tearDown() throws Exception {
		this.activator = null;
	}

	@Test
	public void test() {
		assertEquals(10.0,10.01,0.1);
	}
	
	@Test
	public void test2() {
		assertNotNull(this.activator);
	}

}
