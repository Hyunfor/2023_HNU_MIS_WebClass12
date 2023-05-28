package com.mis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mis.dto.BoardVO;
import com.mis.dto.ProductVO;

import util.DBManager;

public class BoardDAO {
	
	private BoardDAO(){	
	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance(){
		return instance;
	}
	
	// 게시글 목록 가져오기
	public List<BoardVO> selectAllBoards(){
		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 결과 값으로 리스트에 담기
			while (rs.next()) {
				
				BoardVO bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));

				// 리스트에 담기
				list.add(bVo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;

	}
	
	// 게시글 작성
	public void insertBoard(BoardVO bVo){
		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 결과 값으로 리스트에 담기
			while (rs.next()) {
				
			

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn, pstmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;

	}
	
}
