package Dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class KetNoi {
	public Connection cn;
	
	public void KetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Connect succsessfully");
			
			String st = "jdbc:sqlserver://DESKTOP-707CQ4J\\SQLEXPRESS:1433;databaseName=QlPhim;user=sa; password=Hinata210211";
			cn = DriverManager.getConnection(st);
			System.out.println("Connect succsessfully 2");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KetNoi kn = new KetNoi();
		kn.KetNoi();
	}

}
