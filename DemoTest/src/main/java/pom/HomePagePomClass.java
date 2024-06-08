package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePomClass {
  
	
	public HomePagePomClass(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="small-searchterms")
	private WebElement searchBox;
	
	@FindBy(partialLinkText="Books")
	private WebElement bookButton;
	
	@FindBy(xpath="//h2[contains(text(),'Welcome to our store')]")
	private WebElement welcomeText;
	
	@FindBy(linkText="Register")
	private WebElement registerButton;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getBookButton() {
		return bookButton;
	}

	public WebElement getWelcomeText() {
		return welcomeText;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
}
