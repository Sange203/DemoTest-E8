package genericlib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pom.BookPagePom;
import pom.HomePagePomClass;
import pom.LoginPagePom;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public UtilityMethod um=new UtilityMethod();
	public LoginPagePom lp;
	public HomePagePomClass hp;
	public BookPagePom bp;
	public Methods ms;
	
	@BeforeSuite(alwaysRun= true)
	public void beforeSuite(){
		sparkReporter=new ExtentSparkReporter("./reports/"+um.getCurrentTime()+".html");
		reports=new ExtentReports();
		reports.attachReporter(sparkReporter);
		
	}
	
	@BeforeClass(alwaysRun=true)
	public void beforeClass(@Optional("Chrome")String browser) throws Throwable {
		if(browser.equals("Chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("Edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println("Please enter a valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(um.getDataFromPropertyFile("url"));
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws Throwable {
//		test=reports.createTest(method.getName());
//		test=reports.createTest("login");
		lp=new LoginPagePom(driver);
		lp.getLoginLink().click();
		test = reports.createTest(getClass().getSimpleName());

//		test.log(Status.INFO, "User has clicked on login link");
		lp.getEmailTextField().sendKeys(um.getDataFromPropertyFile("un"));
		lp.getPasswordTextField().sendKeys(um.getDataFromPropertyFile("pwd"));
		lp.getLoginButton().click();
	}

	
	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		lp.getLogoutLink().click();
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		//driver.close();
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		reports.flush();
	}
	
}
