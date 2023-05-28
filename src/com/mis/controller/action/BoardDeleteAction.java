package com.mis.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.BoardDAO;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 유저가 선택한 게시글 번호 가져오기
		String num = request.getParameter("num");
		
		// DB에서 삭제
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.deleteBoard(num);
		
		new BoardListAction().execute(request, response);
	}

}
