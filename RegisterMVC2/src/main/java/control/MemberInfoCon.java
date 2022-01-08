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
			0. memberList���� �ѱ� id�� �޾��� 
			1. ������ ���̽����� �� ȸ���� ������ ������
			2. table �±׸� �̿��Ͽ� ȭ�鿡 ȸ���� ������ ���
		*/
		
		// MemberList�� id�� �޾���
		String id = request.getParameter("id");
		
		MemberDAO mdao = new MemberDAO();
		
		MemberBean mbean = mdao.oneSelectMember(id); 
		
		request.setAttribute("mbean", mbean);

		RequestDispatcher dis = request.getRequestDispatcher("memberInfo.jsp");
		dis.forward(request, response);
	
	}
}

