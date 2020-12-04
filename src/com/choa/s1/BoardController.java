package com.choa.s1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        boardService = new BoardService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURL().toString();
		path = path.substring(path.lastIndexOf("/"));
		String info = "";
		
		if(path.equals("/boardList.board")) {
			System.out.println("Board List");
			info = "./boardList.jsp";
			
			ArrayList<BoardDTO> ar = null;
			
			try {
				ar = boardService.boardSelect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("board", ar);
			
			}else if(path.equals("/boardWrite.board")) {
				System.out.println("Board Write");
				info = "boardWrite.jsp";
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setNum(Long.parseLong(request.getParameter("num").trim()));
				boardDTO.setTitle(request.getParameter("title"));
				boardDTO.setWriter(request.getParameter("writer"));
				boardDTO.setHit(Long.parseLong(request.getParameter("hit").trim()));
				boardDTO.setContentes(request.getParameter("contents"));
				
				try {
					boardService.boardInsert(boardDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
			System.out.println("board");
			}
		
		RequestDispatcher view = request.getRequestDispatcher(info);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
