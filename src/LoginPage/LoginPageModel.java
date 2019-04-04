package LoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageModel 
{
		Connection con;
		int ID;
		int conflag;
		public LoginPageModel()
		 {
			final String USER="root";
			final String PASSWORD="1234";
			final String URL1="jdbc:mysql://127.0.0.1:3306/test1";
			
			 try {
				con=DriverManager.getConnection(URL1, USER, PASSWORD);
				System.out.print("connected!");
				conflag=1;
			} catch (SQLException e) {
				e.printStackTrace();
				conflag=0;
			}
		 }
		public boolean checkLogin(String username,String password) throws SQLException 
		{
			PreparedStatement ps=con.prepareStatement("select * from logindetails where Uname=? and Pword=?");
			ps.setString(1,username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ID=rs.getInt(1);
				ps.close();
				rs.close();
				return true;
			}
			else 
			{
				ps.close();
				rs.close();
				return false;
			}
		}
		public int getId()
		{
			return ID;
		}

	

}
