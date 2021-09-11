package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		        //STEP 1-Load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//STEP 2-Establish Connection
				Connection con = null;
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","root");
				if(con!=null) {
				    System.out.println("Connection Establishes");
					}
					else 
					{
					 System.out.println("Connection not Establishes");
	                 }
				//Step 3- Creating statement
				PreparedStatement ps=con.prepareStatement("insert into sample.student values(?,?,?,?)");
				ps.setInt(1,14);
			    ps.setString(2,"Vishnu");
				ps.setInt(3,56);
				ps.setString(4,"chn");
				
				ps.executeUpdate();
				//Step 4-getting result
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery("select * from sample.student");
				
				while(rs.next()) {
					int id=rs.getInt("id");
					String name=rs.getString("name");
					int age=rs.getInt("age");
					String address=rs.getString("address");
					System.out.println("id: "+id+" name: "+name+" age :"+age+" address: "+address);
				}
				//Step 5-Closing the connection
				con.close();
			

				
		      
}
}

