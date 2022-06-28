package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import pagesobjects.EnterTimeTrack_PO;
import pagesobjects.Login_PO;
import pagesobjects.Tasks_PO;


	public class BaseClass1 {
	
		public Readconfig1 read=new Readconfig1();
		public static WebDriver driver=null;
		public static WebDriverWait wait=null;

		public static Login_PO login_Page= null;
		public static EnterTimeTrack_PO enterTimeTrack_PO= null;
		public static Tasks_PO tasks_PO= null;
		public static ExtentReports extent = null;
		public static ExtentSparkReporter  spark = null;
		public static ExtentTest test= null;
		public static File file = null;
		public static POIFSFileSystem fs = null;
		public static HSSFWorkbook wb = null;
		public static HSSFSheet sheet = null;
		public static HSSFRow row = null;
		public static HSSFCell cell = null;

		
		
		@BeforeSuite
		public void initialSetUp() throws IOException {
		
		  spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\sparrk.html");
		  
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("ActiTime Test Report");
			spark.config().setReportName("Extent Reports");
			ExtentReports extent=new  ExtentReports();
			extent.attachReporter(spark);
			
			extent.setSystemInfo("os", "Windows");
			file = new File("D:\\New folder\\muralisirproject\\src\\test\\resources\\testData\\testData1.xls");
			
			fs = new POIFSFileSystem(new FileInputStream(file));
			wb = new HSSFWorkbook(fs);
		    HSSFRow row;
		    HSSFCell cell;
	
		
			//ExtentTest test=extent.createTest("this is url");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\PRAVEENA\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
			driver = new ChromeDriver();
			wait= new WebDriverWait(driver, 30);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(read.getapplicationurl());
			driver.manage().window().maximize();
			
			
			
		}
		
		@BeforeTest
		public void setUp() throws IOException {
			login_Page= PageFactory.initElements(driver, Login_PO.class);
			enterTimeTrack_PO= PageFactory.initElements(driver, EnterTimeTrack_PO.class);
			tasks_PO= PageFactory.initElements(driver, Tasks_PO.class);
		}
		
		
		@Test (groups= {"Regression"},priority=1)
		public void login_ActiTime() throws InterruptedException, IOException {
//			test= extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName())
//					.assignAuthor("Murali Sukumar").assignCategory("Regression").assignDevice("Windows");
			if(login_Page.getLogin_button().isDisplayed()==true) {
				System.out.println("We navigated to SignIn Page");
			}
			login_Page.getUsername_tbox().sendKeys(read.getusername());
			login_Page.getPassword_tbox().sendKeys(read.getpassword());
			login_Page.getKeepLogin_cbox().click();
			login_Page.getLogin_button().click();
//			wait.until(ExpectedConditions.visibilityOf(enterTimeTrack_PO.getEnterTimeTrack_Header()));
			
			}
	
		
		
		@AfterSuite
		public void closeConnection() throws IOException, InterruptedException {
			Thread.sleep(5000);
			enterTimeTrack_PO.getLogoutLink().click();
			if(login_Page.getLogin_button().isDisplayed()==true) {
				System.out.println("We navigated to SignIn Page");
			}
			extent.flush();
			driver.close();
			
		}
	}