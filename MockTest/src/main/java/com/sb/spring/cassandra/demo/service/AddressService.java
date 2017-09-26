package com.sb.spring.cassandra.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.spring.cassandra.demo.model.AddressDao;

@Service
public class AddressService {
	private AddressDao addressDao;

	@Autowired
	public AddressService(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public String getAddressForUser(String userName) {
		return addressDao.readAddress(userName);
	}
}