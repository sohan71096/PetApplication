/*----------------------------------------------------------------------------------------------------------------
//	This class emphasizes on establishing connection with database using credentials stored in .propreties file
-----------------------------------------------------------------------------------------------------------------*/	


package com.cg.pa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection
{
	public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException
	{
			FileInputStream fis= new FileInputStream("resources/DB.properties");
			Properties p=new Properties();
			p.load(fis);
			
			String purl=p.getProperty("url");
			String pusername=p.getProperty("username");
			String ppassword=p.getProperty("password");
			String driver = p.getProperty("driver");
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(purl,pusername,ppassword);
			return con;
		}
}
