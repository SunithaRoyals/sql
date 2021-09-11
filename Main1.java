package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");
		
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from sample.signup");
		
		while(rs.next()) {
			int id=rs.getInt("id");
			String firstname=rs.getString("firstname");
			String lastname=rs.getString("lastname");
			int age=rs.getInt("age");
			String city=rs.getString("city");
			System.out.println("id: "+id+" firstname: "+firstname+" lastname :"+lastname+" age :"+age+" city: "+city);
		}
		
	}

}
