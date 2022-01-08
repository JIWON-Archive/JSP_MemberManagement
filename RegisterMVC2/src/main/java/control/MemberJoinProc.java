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
		// �ѱ� ó��
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
			data += string  + " "; // �ϳ��� ��Ʈ������ ����
		}
		bean.setHobby(data);
		
		bean.setJob(request.getParameter("job"));
		bean.setInfo(request.getParameter("info"));
		
		// �н����尡 ���� ��쿡�� ���̹� ���̽� ����
		if(pw.equals(pwCheck)) {
			// ������ ���̽� ��ü ����
			MemberDAO mdao = new MemberDAO();
			mdao.insertMember(bean);
			RequestDispatcher dis = request.getRequestDispatcher("MemberInfoCon.do");
			dis.forward(request, response);
		} else {
			request.setAttribute("msg", "�н����尡 ��ġ���� �ʽ��ϴ�.");
			RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
			dis.forward(request, response);
		}
	}
}
