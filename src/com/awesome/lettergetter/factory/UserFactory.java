package com.awesome.lettergetter.factory;

import com.awesome.lettergetter.dto.User;

public class UserFactory {
	private static UserFactory userFactory;
	private User activeUser;
	
	public static UserFactory getInstance(){
		if(userFactory == null){
			userFactory = new UserFactory();
		}
		return userFactory;
	}
	
	private UserFactory(){
		activeUser = new User("poop");
	}
	
	public void setActiveUser(String username){
		//TODO
	}
	
	public void saveActiveUser(){
		//TODO
	}
	
	public User getActiveUser(){
		return activeUser;
	}
}
