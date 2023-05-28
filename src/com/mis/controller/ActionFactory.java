package com.mis.controller;

import com.mis.controller.action.Action;

public class ActionFactory {
	
	// 싱글톤 패턴으로 생성
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){
		super();
	}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	// 각 command에 따라 객체 생성하여 리턴 해준다.
	public Action getAction(String command){
		
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		return action;
	}

}
