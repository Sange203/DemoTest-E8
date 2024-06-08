package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePom {

	public LoginPagePom(WebDriver driver) {
      PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Log in")
	private WebElement LoginLink;
	
	@FindBy(linkText="Log out")
	private WebElement LogoutLink;

	public WebElement getLoginLink() {
		return LoginLink;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}
	
	@FindBy(id="Email")
	private WebElement emailTextField;
	
	@FindBy(id="Password")
	private WebElement passwordTextField;
	
	@FindBy(id="RememberMe")
	private WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginButton;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getRememberMeCheckbox() {
		return rememberMeCheckbox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
