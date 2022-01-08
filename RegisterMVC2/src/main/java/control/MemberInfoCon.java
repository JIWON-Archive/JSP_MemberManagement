package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDAO;

@WebServlet("/MemberInfoCon.do")
public class MemberInfoCon extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*
			0. memberList에서 넘긴 id를 받아줌 
			1. 데이터 베이스에서 한 회원의 정보를 가져옴
			2. table 태그를 이용하여 화면에 회원의 정보를 출력
		*/
		
		// MemberList의 id를 받아줌
		String id = request.getParameter("id");
		
		MemberDAO mdao = new MemberDAO();
		
		MemberBean mbean = mdao.oneSelectMember(id); 
		
		request.setAttribute("mbean", mbean);

		RequestDispatcher dis = request.getRequestDispatcher("memberInfo.jsp");
		dis.forward(request, response);
	
	}
}

