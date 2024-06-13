package scripts;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import genericlib.BaseClass;
import genericlib.UtilityMethod;
import pom.HomePagePomClass;
import pom.RegisterPomClass;

public class ScriptRegister_Test  {
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentSparkReporter sparkReporter;
	public UtilityMethod um=new UtilityMethod();
	
	public static String getCurrentTime() {
		LocalDateTime l = LocalDateTime.now();
		String name = l.toString().replace(":", "-");
		return name;
		
	}
	@Test
	public void register(@Optional("Chrome")String browser) throws Throwable {
		
		sparkReporter=new ExtentSparkReporter("./reports/"+getCurrentTime()+".html");
		reports=new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		test=reports.createTest("Register Page");
		
//		hp=new HomePagePomClass(driver);
//		hp.getRegisterButton().click();
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
	
		
		RegisterPomClass reg = new RegisterPomClass(driver);
		reg.getRegisterlink().click();
		reg.getFemaleRadioButton().click();
		reg.getFnameTextbox().sendKeys(um.getDataFromExcelFile("Sheet1", 1, 1));
		reg.getLnameTextbox().sendKeys(um.getDataFromExcelFile("Sheet1", 1, 2));
		reg.getEmailTextbox().sendKeys(um.getDataFromExcelFile("Sheet1", 1, 3));
		reg.getPasswordField().sendKeys(um.getDataFromExcelFile("Sheet1", 1, 4));
		reg.getPasswordConfirmField().sendKeys(um.getDataFromExcelFile("Sheet1", 1, 5));
		reg.getRegisterButton().click();
		Reporter.log("user clicked on register page",true);
		test=reports.createTest("New user Registered....");
		test.log(Status.INFO, "New user Registered");
	}
	
}
