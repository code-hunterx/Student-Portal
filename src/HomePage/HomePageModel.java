package HomePage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class HomePageModel 
{

	Connection con;
	int ID;
	String username,password,firstname,lastname,middlename,department,division,parentno,semester,studentno,birthdate;
	InputStream studentphoto;
	
	
	
	public HomePageModel()
	 {
		final String USER="root";
		final String PASSWORD="1234";
		final String URL1="jdbc:mysql://127.0.0.1:3306/test1";
		
		 try {
			con=DriverManager.getConnection(URL1, USER, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	public void getID(int id) 
	{
		ID=id;
	}
	
	public void setHomePage() throws SQLException, IOException 
	{
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from logindetails where id="+ID+"");
		if(rs.next())
		{
			ID=rs.getInt(1);
			username=rs.getString(2);
			firstname=rs.getString(4);
			middlename=rs.getString(5);
			lastname=rs.getString(6);
			department=rs.getString(7);
			division=rs.getString(8);
			semester=rs.getString(9);
			parentno=rs.getString(10);
			studentno=rs.getString(11);
			birthdate=rs.getString(12);
			studentphoto=rs.getBinaryStream(13);
		}
		
		else
		{
			rs.close();
			s.close();
		}
		
	}

}
