package com.mis.controller;

import com.mis.controller.action.Action;
import com.mis.controller.action.BoardListAction;
import com.mis.controller.action.BoardViewAction;
import com.mis.controller.action.BoardWriteAction;
import com.mis.controller.action.BoardWriteFormAction;

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
		
		// Action 객체 추가되는 부분
		if(command.equals("board_list")){ // 게시글 리스트
			action = new BoardListAction();
		} else if (command.equals("board_write_form")){ // 글쓰기
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")){ 
			action = new BoardWriteAction();
		} else if (command.equals("board_view")){ // 상세보기
			action = new BoardViewAction();
		}
		
		
		return action;
	}

}
