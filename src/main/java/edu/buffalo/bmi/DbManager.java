package edu.buffalo.bmi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class DbManager {

	public static ArrayList encryptedStrings = null;

	public static void CreateStudy(StudyBean studyBean)
			throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionManager.getInstance().getConnection();
		ResourceBundle rbi = ResourceBundle.getBundle("sql");
		try {

			PreparedStatement pstmt = conn.prepareStatement(rbi
					.getString("insertIntoResearchStudyInfo"));
			pstmt.setInt(1, studyBean.getStatus());
			pstmt.setString(2, studyBean.getComments());
			pstmt.setString(3, studyBean.getUserId());
			pstmt.setString(4, studyBean.getInvestigator());
			pstmt.setString(5, studyBean.getProjectTitle());
			pstmt.setString(6, studyBean.getInstitution());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}// end of createstudy

	public static void insertIntoHumanResearch(String attr1, String attr2,
			String attr3, String attr4, String attr5, String attr6,
			String attr7, String attr8, String attr9, String attr10,
			String attr11, String attr12, int studyID)
			throws SQLException {
		Connection conn = ConnectionManager.getInstance().getConnection();
		ResourceBundle rbi = ResourceBundle.getBundle("sql");
		try {

			PreparedStatement pstmt = conn.prepareStatement(rbi
					.getString("insertIntoHumanResearch"));
			pstmt.setInt(1, studyID);
			pstmt.setString(2, attr1);
			pstmt.setString(3, attr2);
			pstmt.setString(4, attr3);
			pstmt.setString(5, attr4);
			pstmt.setString(6, attr5);
			pstmt.setString(7, attr6);
			pstmt.setString(8, attr7);
			pstmt.setString(9, attr8);
			pstmt.setString(10, attr9);
			pstmt.setString(11, attr10);
			pstmt.setString(12, attr11);
			pstmt.setString(13, attr12);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}// end of insertIntoHumanResearch

	public static void insertIntoExempt(String attr1, String attr2,
			String attr3, String attr4, String attr5, String attr6,
			String attr7, String attr8, String attr9, String attr10, int studyID)
			throws SQLException {
		Connection conn = ConnectionManager.getInstance().getConnection();
		ResourceBundle rbi = ResourceBundle.getBundle("sql");
		try {

			PreparedStatement pstmt = conn.prepareStatement(rbi
					.getString("insertIntoExempt"));
			pstmt.setInt(1, studyID);
			pstmt.setString(2, attr1);
			pstmt.setString(3, attr2);
			pstmt.setString(4, attr3);
			pstmt.setString(5, attr4);
			pstmt.setString(6, attr5);
			pstmt.setString(7, attr6);
			pstmt.setString(8, attr7);
			pstmt.setString(9, attr8);
			pstmt.setString(10, attr9);
			pstmt.setString(11, attr10);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}// end of insertIntoExempt

	public static void insertIntoExpedited(String ele1, String ele2,
			String ele3, String ele4, String ele5, String ele6, String ele7,
			String ele8, int studyID) throws SQLException {
		Connection conn = ConnectionManager.getInstance().getConnection();
		ResourceBundle rbi = ResourceBundle.getBundle("sql");
		try {

			PreparedStatement pstmt = conn.prepareStatement(rbi
					.getString("insertIntoExpedited"));
			pstmt.setInt(1, studyID);
			pstmt.setString(2, ele1);
			pstmt.setString(3, ele2);
			pstmt.setString(4, ele3);
			pstmt.setString(5, ele4);
			pstmt.setString(6, ele5);
			pstmt.setString(7, ele6);
			pstmt.setString(8, ele7);
			pstmt.setString(9, ele8);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}// end of insertIntoExpedited

	public static void insertIntoHIPAA(String bool1, String bool2,
			String bool3, String bool4, String bool5, String bool6,
			String bool7, String bool8, int studyID) throws SQLException {
		Connection conn = ConnectionManager.getInstance().getConnection();
		ResourceBundle rbi = ResourceBundle.getBundle("sql");
		try {

			PreparedStatement pstmt = conn.prepareStatement(rbi
					.getString("insertIntoHIPAA"));
			pstmt.setInt(1, studyID);
			pstmt.setString(2, bool1);
			pstmt.setString(3, bool2);
			pstmt.setString(4, bool3);
			pstmt.setString(5, bool4);
			pstmt.setString(6, bool5);
			pstmt.setString(7, bool6);
			pstmt.setString(8, bool7);
			pstmt.setString(9, bool8);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}// end of insertIntoHIPAA

	public static void insertIntoConsentWaiver(String var1, String var2,
			String var3, String var4, String var5, int studyID)
			throws SQLException {
		Connection conn = ConnectionManager.getInstance().getConnection();
		ResourceBundle rbi = ResourceBundle.getBundle("sql");
		try {

			PreparedStatement pstmt = conn.prepareStatement(rbi
					.getString("insertIntoConsentWaiver"));
			pstmt.setInt(1, studyID);
			pstmt.setString(2, var1);
			pstmt.setString(3, var2);
			pstmt.setString(4, var3);
			pstmt.setString(5, var4);
			pstmt.setString(6, var5);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}// end of insertIntoConsentWaiver

	public static int checkUser(LoginBean loginBean)
			throws ClassNotFoundException, SQLException,
			IllegalBlockSizeException, BadPaddingException,
			InvalidParameterSpecException, UnsupportedEncodingException {
		Connection conn = ConnectionManager.getInstance().getConnection();
		ResourceBundle rbc = ResourceBundle.getBundle("sql");
		int count = 0;
		String passwd = null;
		String decryptedPassword = null;
		EncryptDecrypt en = null;
		try {
			en = new EncryptDecrypt();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			PreparedStatement pstmt = conn.prepareStatement(rbc
					.getString("registerPwd"));
			pstmt.setString(1, loginBean.getUsername());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				passwd = rs.getString(1);
			}
			try {
				decryptedPassword = en.decrypt(passwd);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if ((loginBean.getPassword()).equalsIgnoreCase(decryptedPassword)) {
				PreparedStatement pstmtCount = conn.prepareStatement(rbc
						.getString("registerCount"));
				pstmtCount.setString(1, loginBean.getUsername());
				pstmtCount.setString(2, passwd);
				ResultSet rsCount = pstmtCount.executeQuery();
				while (rsCount.next()) {
					count = rsCount.getInt(1);
				}
				rs.close();
				pstmt.close();
				rsCount.close();
				pstmtCount.close();
			} else {
				count = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return count;
	}

	public static void updateStatus(int studyID, int status)
			throws SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("sql");
		Connection conn = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(rb
					.getString("updateStatus"));
			pstmt.setInt(1, status);
			pstmt.setInt(2, studyID);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}

	}

	public static int getRole(String name) throws SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("sql");
		int userId = 0;
		int roleId = 0;
		Connection conn = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(rb
					.getString("selectUserQuery"));
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					userId = rs.getInt("userID");
				}
			}
			PreparedStatement pstmt1 = conn.prepareStatement(rb
					.getString("selectRoleQuery"));
			pstmt1.setInt(1, userId);
			ResultSet rs1 = pstmt1.executeQuery();
			if (rs1 != null) {
				while (rs1.next()) {
					roleId = rs1.getInt("RoleID");
				}
			}
			pstmt.close();
			rs.close();
			pstmt1.close();
			rs1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return roleId;
	}

	public static int getUserId(String name) throws SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("sql");
		int userId = 0;
		Connection conn = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(rb
					.getString("selectUserQuery"));
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					userId = rs.getInt("userID");
				}
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return userId;
	}

	public static int getStudyID(String investigator, String projectTitle, String institution)
			throws SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("sql");
		int studyID = 1;
		Connection conn = ConnectionManager.getInstance().getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(rb
					.getString("selectStudyID"));
			pstmt.setString(1, investigator);
			pstmt.setString(2, projectTitle);
			pstmt.setString(3, institution);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					studyID = rs.getInt("StudyID");
				}
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return studyID;
	}

	public static void InsertUserInDB(LoginBean loginBean)
			throws ClassNotFoundException, SQLException {

		Connection conn = ConnectionManager.getInstance().getConnection();
		// encrypt password before storing it in db
		String encryptedPassword = null;
		try {
			EncryptDecrypt ed = new EncryptDecrypt();
			try {
				encryptedPassword = ed.encrypt(loginBean.getPassword());
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResourceBundle rbi = ResourceBundle.getBundle("sql");
		try {
			PreparedStatement pstmt = conn.prepareStatement(rbi
					.getString("insertIntoUsers"));
			pstmt.setString(1, loginBean.getFname());
			pstmt.setString(2, loginBean.getLname());
			pstmt.setString(3, loginBean.getUsername());
			pstmt.setString(4, encryptedPassword);
			pstmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setString(6, "Y");
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}

	}

	public static void InsertIntoUserRole(int UserID)
			throws ClassNotFoundException, SQLException {

		Connection conn = ConnectionManager.getInstance().getConnection();

		ResourceBundle rbi = ResourceBundle.getBundle("sql");
		try {

			PreparedStatement pstmt = conn.prepareStatement(rbi
					.getString("insertIntoUserRole"));
			pstmt.setInt(1, UserID);
			pstmt.setInt(2, 1);

			pstmt.executeUpdate();

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}

	}// end of InsertIntoUserRole

}
