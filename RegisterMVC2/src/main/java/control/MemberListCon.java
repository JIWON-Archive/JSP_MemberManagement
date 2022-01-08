package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDAO;

@WebServlet("/MemberListCon.do")
public class MemberListCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//for (int i = 0; i < list.size(); i++) {
			//MemberBean bean = list.get(i);
		// ������ ���̽��� �����Ͽ� ȸ���� ��� ������ ����
		MemberDAO mdao = new MemberDAO();
		// MemberBean�� ���� -> ArrayList �ڽ��� ��ƶ�
		ArrayList<MemberBean> list = mdao.getAllMember();
		
		request.setAttribute("list", list); // ArrayList�� jsp ������ �Ѱ���
		RequestDispatcher dis = request.getRequestDispatcher("memberList.jsp");
		dis.forward(request, response);
	}
}
