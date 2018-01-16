package Community_parking_fee;

import java.sql.*;
public class Connect_db {
    public static String driverName ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   	public static String Url="jdbc:sqlserver://localhost:1433;DatabaseName=community_parking_fee_system";
 	public static String UName="sa";
 	public static String Upwd="666666";
	Connection con = null;
	public Connection get_con() {
    	try {
    		Class.forName(driverName);
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	try {
    		con = DriverManager.getConnection(Url, UName, Upwd);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
		return con;
	}
}
