package com.rmi;

import org.springframework.stereotype.Service;

@Service("userRemoteService")
public class UserRemoteService implements IUserRemoteService {

	public String hello(String name) {
		return "hello" + name;
	}

}