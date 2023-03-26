package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class ControllerStudent {

	public boolean save(int sid, String name,String course) {
		boolean result=false;
		String url = "jdbc:mysql://localhost/demo1";
		try {
			Connection conn = DriverManager.getConnection(url, "root", "");
			String sql = "INSERT INTO tbl_students VALUES(?,?,?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, sid);
			pstat.setString(2, name);
			pstat.setString(3, course);
			pstat.executeUpdate(); //Save
			pstat.close();
			conn.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return result;
	}

}
