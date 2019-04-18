package member;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	public static final int ID_PASSWORD_MATCH = 1;
	public static final int ID_DOES_NOT_EXIST = 2;
	public static final int PASSWORD_IS_WRONG = 3;
	public static final int DATABASE_ERROR = -1;
	
	private Connection conn;
	private static final String USERNAME = "javauser";
	private static final String PASSWORD = "javapass";
	private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";

	public MemberDAO() { // MySQL Connect
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int verifyIDPassword(int id, String password) {
		System.out.println("verifyIdPassword(): " + id + ", " + password);
		String query = "select hashed from member where id=?;";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String hashedPassword = "";
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, id);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				hashedPassword = rs.getString(1);
				if(BCrypt.checkpw(password, hashedPassword))
					return ID_PASSWORD_MATCH;
				else
					return PASSWORD_IS_WRONG;
			}
			return ID_DOES_NOT_EXIST;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return DATABASE_ERROR;
	}

	public List<MemberDTO> selectCondition(String query) { // condition
		PreparedStatement pStmt = null;
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				MemberDTO member = new MemberDTO();

				member.setId(rs.getInt("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setBirthday(rs.getString("birthday"));
				member.setAddress(rs.getString("address"));

				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}

	public List<MemberDTO> selectMemberAll() { // select All
		String sql = "select * from member order by id";
		List<MemberDTO> memberList = selectCondition(sql);
		return memberList;
	}

	public MemberDTO selectMemberName(String name) { // select name
		String query = "select * from Member where name like '" + name + "';";
		PreparedStatement pStmt = null;
		MemberDTO member = new MemberDTO();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				member.setId(rs.getInt("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setBirthday(rs.getString("birthday"));
				member.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return member;
	}

	public MemberDTO selectMemberOne(int id) { // select One
		String query = "select * from Member where id=?;";
		PreparedStatement pStmt = null;
		MemberDTO member = new MemberDTO();
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				member.setId(rs.getInt("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setBirthday(rs.getString("birthday"));
				member.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return member;
	}

	public void insertMember(MemberDTO member) { // insert
		String query = "insert into member (password, name, birthday, address, hashed) value(?, ?, ?, ?, ?);";
		PreparedStatement pStmt = null;
		try {
			String hp = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt());
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, "*");
			pStmt.setString(2, member.getName());
			pStmt.setString(3, member.getBirthday());
			pStmt.setString(4, member.getAddress());
			pStmt.setString(5, hp);

			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public void initPassword() {
		List<MemberDTO> mList = selectMemberAll();
		for (MemberDTO member : mList) {
			int id = member.getId();
			String plainPassword = member.getPassword();
			String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
			updatePassword(id, hashedPassword);
					
		}
	}

	public void updatePassword(int id, String hashed) { // update
		String query = "update member set hashed=? where id=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, hashed);
			pStmt.setInt(2, id);
			
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public void updateMember(MemberDTO member) { // update
		String query = "update member set password=?, name=?, birthday=?, address=? where id=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, member.getPassword());
			pStmt.setString(2, member.getName());
			pStmt.setString(3, member.getBirthday());
			pStmt.setString(4, member.getAddress());
			pStmt.setInt(5, member.getId());

			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void deleteMember(int id) { // delete
		String query = "delete from member where id=?;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, id);

			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void close() { // close
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void check(int id, String password) {
		boolean c = false;
		String query = "select * from Member;";
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				if (id == rs.getInt("id")) {
					if (password.equals(rs.getString("password"))) {
						c = true;
						break;
					} 
				} 
			}
			if (c)
				System.out.println("로그인되었습니다.");
			else
				System.out.println("로그인 실패");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null && !pStmt.isClosed())
					pStmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
