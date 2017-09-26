package com.sb.spring.cassandra.demo;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.sb.spring.cassandra.demo.model.AddressDao;

@Profile("AddressService-test")
@Configuration
public class AddressDaoTestConfiguration {
	
	@Bean
	@Primary
	public AddressDao addressDaoMock() {
		return Mockito.mock(AddressDao.class);
	}
}