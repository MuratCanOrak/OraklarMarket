package gui;

import java.sql.*;

import javax.swing.JOptionPane;

public class Baglanti {

	static  Statement stat;
	static Connection conn;
	public Baglanti() {
		 try {
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/marketdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "1234");
			 stat = conn.createStatement();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		
	
	}


	
	public ResultSet yap( String sorgu) {
		ResultSet rs = null;
		try {
			
			rs = stat.executeQuery(sorgu);

		} catch (Exception e) {
System.out.println("sorgu: "+sorgu);
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "LÜTFEN GÝRDÝÐÝNÝZ DEÐERÝ KONTROL EDÝNÝZ! YAP");

		}
		return rs;
	}
	
	public void update(String sorgu2)   {
		
		try {
			stat.executeUpdate(sorgu2);
			//JOptionPane.showMessageDialog(null, "BAÐLANTI OKEY UPDATE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void ekle (String sorgu3)   {
		
		try {
			stat.executeUpdate(sorgu3);
			//JOptionPane.showMessageDialog(null, "BAÐLANTI OKEY EKLE");
		} catch (SQLException e) {

			e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "LÜTFEN GÝRDÝÐÝNÝZ DEÐERÝ KONTROL EDÝNÝZ! EKLE");
		}
		
	}


}
