package trial;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class MysqlCon {

	public static void main(String args[]){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tests","root","");  
		//here sonoo is database name, root is username and password  
		Statement stmt = (Statement) con.createStatement();  
		ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from wedhall");  
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		}  
}
