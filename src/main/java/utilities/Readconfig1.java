package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig1 {
	public static 	Properties prop=null;
	public static  FileInputStream fis=null;;

	public Readconfig1() {
	try {
		 fis= new FileInputStream("D:\\New folder\\muralisirproject\\src\\test\\resources\\config.properties");
 prop=new Properties();
	
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public String getapplicationurl() {
		String url=prop.getProperty("url");
		return url;
	
	
	
	
	}public String getusername() {
		String url=prop.getProperty("username");
		return url;}
	
		public String getpassword() {
			String password=prop.getProperty("password");
			return password;
		}
		public String getchropath() {
			String chromepath=prop.getProperty("chromepath");
			return chromepath;
		}
		public String getiepath() {
			String ie=prop.getProperty("iepath");
			return ie;
		}
		public String getfirefoxpath() {
			String firepath=prop.getProperty("firefoxpath");
			return firepath;

		}
		public String getdesiredbrowser() {
			String browsername=prop.getProperty("browser");
			return browsername;

		}
		
		
	
	
	}

