package scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericlib.BaseClass;
import pom.HomePagePomClass;

public class Script1book extends BaseClass {

	@Test
	public  void script1() throws Throwable  {
test=reports.createTest("book page");
		hp=new HomePagePomClass(driver);
		hp.getBookButton().click();
//		test=reports.createTest("book page");

		test.log(Status.INFO, "USer click on book button");
		Thread.sleep(4000);
	}

}
