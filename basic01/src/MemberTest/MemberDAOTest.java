package MemberTest;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import member.*;

public class MemberDAOTest {
	private MemberDAO mDao = new MemberDAO();
	
	@Test
	public void verifyIdPasswordTest() {
		int result = mDao.verifyIdPassword(100006, "1234");
		assertEquals(MemberDAO.ID_PASSWORD_MATCH, result);
	}
}


