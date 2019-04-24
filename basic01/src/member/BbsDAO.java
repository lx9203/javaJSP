package member;

import java.sql.*;
import java.util.*;

public class BbsDAO {
	private static final String USERNAME = "javauser";
    private static final String PASSWORD = "javapass";
    private static final String URL = "jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false";
    private Connection conn;
	
    public BbsDAO() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");	
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
	
    public void createBbsTable() {
    	String query = "create table if not exists bbs (" + 
    			"  id int unsigned not null auto_increment," + 
    			"  memberId int unsigned not null," + 
    			"  title varchar(50) not null," + 
    			"  date datetime not null default current_timestamp," + 
    			"  content varchar(400)," + 
    			"  primary key(id)," + 
    			"  foreign key(memberId) references member(id)" + 
    			") default charset=utf8;";
    	PreparedStatement pStmt = null;
    	try {
			pStmt = conn.prepareStatement(query);
			
			pStmt.execute();
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
    
	public BbsDTO selectOne(int id) {
		String query ="select bbs.id, bbs.memberId, bbs.title, member.name, bbs.date, bbs.content from bbs " + 
				"inner join member on bbs.memberId=member.id where bbs.id=?;";
		PreparedStatement pStmt = null;
		BbsDTO bDto = new BbsDTO();
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {				
				bDto.setId(rs.getInt(1));
				bDto.setMemberId(rs.getInt(2));
				bDto.setTitle(rs.getString(3));
				bDto.setName(rs.getString(4));
				bDto.setDate(rs.getString(5));
				bDto.setContent(rs.getString(6));
			}
			rs.close();
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
		return bDto;
	}
	
	public void updateBbs(BbsDTO bDto) {
		PreparedStatement pStmt = null;
		//String date = getCurrentDBTime();
		String query = "update bbs set title=?, date=now(), content=? where id=?;";
		pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, bDto.getTitle());
			pStmt.setString(2, bDto.getContent());
			pStmt.setInt(3, bDto.getId());
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
	
	public void insertBbs(BbsDTO bDto) {
		PreparedStatement pStmt = null;
		String query = "insert into bbs (memberId, title, content) values(?, ?, ?);";
		pStmt = null;
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, bDto.getMemberId());
			pStmt.setString(2, bDto.getTitle());
			pStmt.setString(3, bDto.getContent());		
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
	
	public void deleteBbs(int id) {
		String query = "delete from bbs where id=?;";
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
	
	public List<BbsDTO> ViewData() {
		String query = "select bbs.id, bbs.title, member.name, bbs.date, bbs.content from bbs " + 
				"inner join member on bbs.memberId=member.id;";
		PreparedStatement pStmt = null;
		List<BbsDTO> list = new ArrayList<BbsDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {				
				BbsDTO bmDto = new BbsDTO();
				bmDto.setId(rs.getInt(1));
				bmDto.setTitle(rs.getString(2));
				bmDto.setName(rs.getString(3));
				bmDto.setDate(rs.getString(4));
				bmDto.setContent(rs.getString(5));
				list.add(bmDto);
			}
			rs.close();
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
	
	public List<BbsDTO> selectJoinAll(int number) {
		String query = "select bbs.id, bbs.title, member.name, bbs.date from bbs " + 
				"inner join member on bbs.memberId=member.id order by bbs.id desc;";
		PreparedStatement pStmt = null;
		List<BbsDTO> bmList = new ArrayList<BbsDTO>();
		try {
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, number);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {	
				BbsDTO bmDto = new BbsDTO();
				bmDto.setId(rs.getInt(1));
				bmDto.setTitle(rs.getString(2));
				bmDto.setName(rs.getString(3));
				bmDto.setDate(rs.getString(4));
				bmList.add(bmDto);
			}
			rs.close();
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
		return bmList;
	}
	
	public String getCurrentDBTime() {
		String query = "select now();";
		PreparedStatement pStmt = null;
		String ts = null;
		try {
			pStmt = conn.prepareStatement(query);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				ts = rs.getString(1);
			}
			rs.close();
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
		return ts;
	}
	
	public void close() {
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception se1) { }
	}
	
	public int getNext() {
		String SQL = "select id from bbs order by id desc;";
		try {
			PreparedStatement pStmt = conn.prepareStatement(SQL);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			} return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	} 
	
	public ArrayList<BbsDTO> getList(int pageNumber){
		String SQL = "select * from bbs where bbs.memberId < ? order by date desc limit 10";
		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
			try {
				PreparedStatement pStmt = conn.prepareStatement(SQL);
				pStmt.setInt(1,  getNext() - (pageNumber - 1) * 10);
				ResultSet rs = pStmt.executeQuery();
				while (rs.next()) {
					BbsDTO bDto = new BbsDTO();
					bDto.setId(rs.getInt(1));
					bDto.setMemberId(rs.getInt(2));
					bDto.setTitle(rs.getString(3));
					bDto.setName(rs.getString(4));
					bDto.setContent(rs.getString(5));
					list.add(bDto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	 }
 
	public boolean nextPage(int pageNumber) {
		String SQL = "select * from bbs where bbs.memberId < ? order by date desc limit 10";
		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
			try {
				PreparedStatement pStmt = conn.prepareStatement(SQL);
				pStmt.setInt(1,  getNext() - (pageNumber - 1) * 10);
				ResultSet rs = pStmt.executeQuery();
				while (rs.next()) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
	}
}
