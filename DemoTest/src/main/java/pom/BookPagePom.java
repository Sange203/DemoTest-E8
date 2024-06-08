package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPagePom {

	
	public BookPagePom(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="products-orderby")
	private WebElement productDropdown;

	public WebElement getProductDropdown() {
		return productDropdown;
	}
}
