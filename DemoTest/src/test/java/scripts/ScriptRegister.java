package scripts;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import genericlib.BaseClass;
import pom.HomePagePomClass;
import pom.RegisterPomClass;

public class ScriptRegister extends BaseClass {

	@Test
	public void register(@Optional("Chrome")String browser) throws Throwable {
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
		reg.getFemaleRadioButton().sendKeys(um.getDataFromExcelFile("Sheet1", 0, 0));
	}
	
}
