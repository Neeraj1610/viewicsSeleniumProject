package com.myproject.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.myproject.logging.testng.TestNGListener;

/**
 * Class for database related operations.
 * 
 * @author nadhikari
 *
 */
public class DataBaseUtils {

	TestNGListener testNGListener=new TestNGListener();

	public void isUserPresent(String userName) throws ClassNotFoundException, SQLException
	{

		// TO DO
		ResultSet resultSet=testNGListener.establishDBConnection().executeQuery("SELECT * FROM E_USER WHERE USER_NAME='"+userName+"'");


		while(resultSet.next())
		{
			System.out.println("DB "+resultSet.getString("USER_ID"));			
		}
	}		
}