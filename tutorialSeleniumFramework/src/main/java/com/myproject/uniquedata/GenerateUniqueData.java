package com.myproject.uniquedata;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.myproject.tutorial.log4j.Log4jLogger;

/**
 * Class to generate unique data.
 * 
 * @author nadhikari
 *
 */
public class GenerateUniqueData {
	String currentClassWithPackage=this.getClass().getName()+".";

	public String generateUniqueString(String restService)
	{
		String uniqueString="";

		try{
			HttpClient client=HttpClients.createDefault();
			HttpGet request=new HttpGet(restService);
			HttpResponse response=client.execute(request);

			BufferedReader buffReader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String xmlResponseString=buffReader.readLine();

			uniqueString=xmlResponseString.substring(xmlResponseString.indexOf("<string>"), xmlResponseString.indexOf("</string>")).replace("<string>", "");

			Log4jLogger.info("Unique string is: "+uniqueString);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return uniqueString;
	}

}
