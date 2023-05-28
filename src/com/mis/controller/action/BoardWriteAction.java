package com.mis.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.BoardDAO;
import com.mis.dto.BoardVO;

public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 유저가 입력한 게시글 정보 가져오기
		BoardVO bVo = new BoardVO();
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		// DB에 게시글 정보 등록
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);
		
		new BoardListAction().execute(request, response);
		
	}

}
