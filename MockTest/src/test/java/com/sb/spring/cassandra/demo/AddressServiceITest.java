package com.sb.spring.cassandra.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sb.spring.cassandra.demo.model.AddressDao;
import com.sb.spring.cassandra.demo.service.AddressService;

@ActiveProfiles("AddressService-test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SimpleApplication.class)
public class AddressServiceITest {
	
	@Autowired
	private AddressService addressService;

	@Autowired
	private AddressDao addressDao;

	@Test
	public void testGetAddressForUser() {
		// GIVEN
		Mockito.when(addressDao.readAddress("john")).thenReturn("5 Bright Corner");

		// WHEN
		String actualAddress = addressService.getAddressForUser("john");

		// THEN
		Assert.assertEquals("5 Bright Corner", actualAddress);
	}
}