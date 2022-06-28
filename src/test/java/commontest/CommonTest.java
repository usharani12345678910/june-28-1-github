package commontest;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass1;

public class  CommonTest extends BaseClass1{
	
	
	@Test (groups= {"Regression"},priority=1,enabled=false)
	public void login_ActiTime() throws InterruptedException, IOException {
//		test= extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName())
//				.assignAuthor("Murali Sukumar").assignCategory("Regression").assignDevice("Windows");
		if(login_Page.getLogin_button().isDisplayed()==true) {
			System.out.println("We navigated to SignIn Page");
		}
		login_Page.getUsername_tbox().sendKeys(read.getusername());
		login_Page.getPassword_tbox().sendKeys(read.getpassword());
		login_Page.getKeepLogin_cbox().click();
		login_Page.getLogin_button().click();
//		wait.until(ExpectedConditions.visibilityOf(enterTimeTrack_PO.getEnterTimeTrack_Header()));
		
		}
	}

