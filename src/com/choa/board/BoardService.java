package com.choa.board;

import java.util.ArrayList;

public class BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public void boardInsert(BoardDTO boardDTO) throws Exception{
		
		int result = boardDAO.insertBoard(boardDTO);
		System.out.println(result+ "1이면 성공 아니면 실패");
	}

	public ArrayList<BoardDTO> boardSelect() throws Exception{
		ArrayList<BoardDTO> ar = boardDAO.selectBoard();
		
		return ar;
		
		
	}
}
