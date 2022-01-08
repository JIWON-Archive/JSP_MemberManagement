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

@WebServlet("/MemberJoinProc.do")
public class MemberJoinProc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		MemberBean bean = new MemberBean();
		bean.setId(request.getParameter("id"));
	
		String pw = request.getParameter("pw");
		String pwCheck = request.getParameter("pwCheck");
		
		bean.setPw(pw);
		bean.setPwCheck(pwCheck);
		
		bean.setEmail(request.getParameter("email"));
		bean.setTel(request.getParameter("tel"));
		
		String[] arr = request.getParameterValues("hobby");
		String data = "";
		for(String string: arr) {
			data += string  + " "; // 하나의 스트링으로 연결
		}
		bean.setHobby(data);
		
		bean.setJob(request.getParameter("job"));
		bean.setInfo(request.getParameter("info"));
		
		// 패스워드가 같을 경우에만 데이버 베이스 저장
		if(pw.equals(pwCheck)) {
			// 데이터 베이스 객체 생성
			MemberDAO mdao = new MemberDAO();
			mdao.insertMember(bean);
			RequestDispatcher dis = request.getRequestDispatcher("MemberInfoCon.do");
			dis.forward(request, response);
		} else {
			request.setAttribute("msg", "패스워드가 일치하지 않습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
			dis.forward(request, response);
		}
	}
}
