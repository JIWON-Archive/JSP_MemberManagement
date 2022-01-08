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
		// 데이터 베이스에 연결하여 회원의 모든 정보를 리턴
		MemberDAO mdao = new MemberDAO();
		// MemberBean은 가방 -> ArrayList 박스에 담아라
		ArrayList<MemberBean> list = mdao.getAllMember();
		
		request.setAttribute("list", list); // ArrayList를 jsp 쪽으로 넘겨줌
		RequestDispatcher dis = request.getRequestDispatcher("memberList.jsp");
		dis.forward(request, response);
	}
}
