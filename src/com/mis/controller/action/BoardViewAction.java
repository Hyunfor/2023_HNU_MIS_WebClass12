package com.mis.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.BoardDAO;
import com.mis.dto.BoardVO;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/board/boardView.jsp";
		// request객체의 getParameter를 통해 유저가 선택한 게시글 번호 가져오기
		String num = request.getParameter("num"); 
		
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReadCount(num); // 게시글 조회수 수정
		BoardVO bVo = bDao.selectOneBoardByNum(num); // 게시글 정보를 BoardVO로 받아옴

		request.setAttribute("board", bVo); // request객체에 board로 VO객체를 담아 jsp로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	

}
