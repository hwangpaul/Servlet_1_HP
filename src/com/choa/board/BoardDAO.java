package com.choa.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.websocket.PongMessage;

import com.choa.util.DBConnector;

public class BoardDAO {
	
	private DBConnector dbConnector;
	
	public BoardDAO() {
		dbConnector = new DBConnector();
	}
	//board 테이블 정보 입력
	public int insertBoard(BoardDTO boardDTO) throws Exception{
		Connection con = dbConnector.getConnect();
		
		String sql = "insert into board values(?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, boardDTO.getNum());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getWriter());
		st.setLong(4, boardDTO.getHit());
		st.setString(5, boardDTO.getContentes());
		
		int num = st.executeUpdate();
		
		st.close();
		con.close();
		
		return num;
		
	}
	
	//board 테이블 정보 출력
	public ArrayList<BoardDTO> selectBoard() throws Exception{
		Connection con = dbConnector.getConnect();
		ArrayList<BoardDTO> ar = new ArrayList<>();
		
		String sql = "select * from board order by num desc";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContentes(rs.getString("contents"));
			boardDTO.setReg_date(rs.getDate("reg_date"));
			boardDTO.setHit(rs.getLong("hit"));
			ar.add(boardDTO);
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}

}
