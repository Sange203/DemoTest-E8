package scripts;

import org.testng.annotations.Test;

import genericlib.BaseClass;
import genericlib.Methods;
import pom.BookPagePom;
import pom.HomePagePomClass;

public class Script4Bookposition extends BaseClass{
	
	@Test
	public void bookposionDropdown() throws Throwable {
		hp=new HomePagePomClass(driver);
		hp.getBookButton().click();
		Thread.sleep(4000);
		bp=new BookPagePom(driver);
		ms=new Methods();
	    ms.selectDropDownByVisibleText(bp.getProductDropdown(), "Name: Z to A");
	}

}
