package com.mis.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.BoardDAO;
import com.mis.dto.BoardVO;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = null;
		// 게시글 번호와 입력받은 비밀번호 가져오기
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		// 게시글 정보를 BoardVO로 받아옴
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		
		if(bVo.getPass().equals(pass)){ // 성공시
			url = "/board/checkSuccess.jsp";
		} else { //실패
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
		}
		// 게시글 수정을 위해 비밀번호 체크시에 
		// 비밀번호가 일치하지 않을때 밑에 messge만 뜨지 않음. 
		// 그외에는 전부 정상 작동함.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
