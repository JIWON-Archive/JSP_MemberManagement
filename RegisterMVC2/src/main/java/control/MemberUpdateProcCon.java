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

@WebServlet("/MemberUpdateProcCon.do")
public class MemberUpdateProcCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		MemberDAO mdao = new MemberDAO();
		String password = mdao.getPassword(id); // DB 비밀번호

		MemberBean mbean = new MemberBean();
//		request.setAttribute("mbean", mbean);
		
		mbean.setEmail(request.getParameter("email"));
		mbean.setTel(request.getParameter("tel"));
		// set안하면 null
		mbean.setPw(request.getParameter("pw"));
		mbean.setId(request.getParameter("id"));
		
		if(mbean.getPw().equals(password)) { // 파라미터 비밀번호 == DB 비밀번호
			mdao.updateMember(mbean); 
			request.setAttribute("msg","수정이 완료 되었습니다");
			/* RequestDispatcher dis = request.getRequestDispatcher("MemberListCon.do"); */
			RequestDispatcher dis = request.getRequestDispatcher("MemberInfoCon.do");
			dis.forward(request, response);
		} else {
				request.setAttribute("msg", "패스워드가 일치하지 않습니다.");
				RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
				dis.forward(request, response);
		}
	}
}