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

@WebServlet("/MemberDeleteProcCon.do")
public class MemberDeleteProcCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		MemberDAO mdao = new MemberDAO();
		MemberBean mbean = new MemberBean();
//		request.setAttribute("mbean", mbean);

		mbean.setId(request.getParameter("id"));
		mbean.setPw(request.getParameter("pw"));
		System.out.println(mbean.getId());
		System.out.println(mbean.getPw());
		String password = mdao.getPassword(mbean.getId());
		
		if(mbean.getPw().equals(password)) { 
			mdao.deleteMember(mbean.getId());
			/* response.sendRedirect("memberList.jsp"); */
			/* RequestDispatcher dis = request.getRequestDispatcher("MemberListCon.do"); */
			RequestDispatcher dis = request.getRequestDispatcher("Result.jsp");
			dis.forward(request, response);
		} else { 
			request.setAttribute("msg", "패스워드가 일치하지 않습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
			dis.forward(request, response);
		}
		
	}
}
