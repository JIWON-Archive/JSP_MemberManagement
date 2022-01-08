package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	String id = "HUEKA";
	String pw = "0814";
	String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	String driver = "oracle.jdbc.driver.OracleDriver";

	// ������ ���̽��� ������ �� �ֵ��� ����
	Connection con;
	// ������ ���̽����� ������ ��������ִ� ��ü(SQL�� �����ϱ� ���� ���)
	PreparedStatement pstmt;
	// ������ ���̽��� ���̺��� ����� ���Ϲ޾� �ڹٿ� �������ִ� ��ü(SQL�� ����� ������ ���� ���)
	ResultSet rs;

	// ������ ���̽��� ������ �� �ֵ��� �����ִ� �޼���
	public void getCon() {
		try {
			// ����̹� �ε�
			Class.forName(driver);
			// DBMS�� Connection ����
			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ȸ�� �� ����� ���� ������ �����ϴ� �޼ҵ�
	public void insertMember(MemberBean bean) {
		getCon();

		try {
			// ���� �غ�
			String sql = "INSERT INTO MEMBERSHIP VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getTel());
			pstmt.setString(5, bean.getHobby());
			pstmt.setString(6, bean.getJob());
			pstmt.setString(7, bean.getInfo());

			// ���� ����
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ��� ȸ���� ������ �����ϴ� �޼ҵ� �ۼ�
	public ArrayList<MemberBean> getAllMember() {
		// ���� Ÿ�� ����
		ArrayList<MemberBean> list = new ArrayList<MemberBean>();

		getCon();

		try {
			// ���� �غ�
			String sql = "SELECT * FROM MEMBERSHIP";
			// ���� ��ü �غ�
			pstmt = con.prepareStatement(sql);
			// ���� ���� �� ��� ����
			rs = pstmt.executeQuery();
			// �ݺ����� ���鼭 ȸ�� ������ ����
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setId(rs.getString(1));
				bean.setPw(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setInfo(rs.getString(7));
				// ����Ʈ�� �� Ŭ���� ����
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// �� ����� ������ �����ϴ� �޼���
	public MemberBean oneSelectMember(String id) {
		MemberBean bean = new MemberBean();

		try {
			getCon();
			String sql = "SELECT * FROM MEMBERSHIP WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setId(rs.getString(1));
				bean.setPw(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setInfo(rs.getString(7));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	// �� ȸ���� �н����� ���� �����ϴ� �޼��� �ۼ�
	public String getPassword(String id) {
		String password= "";
		try {
			getCon();
			String sql = "SELECT PW FROM MEMBERSHIP WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				password = rs.getString(1);
			}
			// �ڿ� �ݳ�
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	// �� ȸ���� ������ �����ϴ� �޼���
	public void updateMember(MemberBean bean) {
		getCon();
		try {
			String sql = "UPDATE MEMBERSHIP SET EMAIL = ?, TEL = ? WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getTel());
			pstmt.setString(3, bean.getId());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �� ȸ���� �����ϴ� �޼��� �ۼ�
	public void deleteMember(String id) {
		getCon();

		try {
			String sql = "DELETE FROM MEMBERSHIP WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
