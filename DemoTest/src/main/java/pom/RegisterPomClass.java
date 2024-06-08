package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPomClass {

	public RegisterPomClass(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Register")
	private WebElement registerlink;

	public WebElement getRegisterlink() {
		return registerlink;
	}
	@FindBy(id="gender-male")
	private WebElement maleRadioButton;
	
	@FindBy(id="gender-female")
	private WebElement femaleRadioButton;
	
	@FindBy(id="FirstName")
	private WebElement fnameTextbox;
	
	@FindBy(id="LastName")
	private WebElement lnameTextbox;
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(xpath="//input[@name='Password']")
	private WebElement passwordField;
	
	public WebElement getRegisterButton() {
		return registerButton;
	}

	@FindBy(xpath="//input[@name='ConfirmPassword']")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath="//input[@name='register-button']")
	private WebElement registerButton;

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getFnameTextbox() {
		return fnameTextbox;
	}

	public WebElement getLnameTextbox() {
		return lnameTextbox;
	}

	public WebElement getEmailTextbox() {
		return emailTextbox;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getPasswordConfirmField() {
		return passwordConfirmField;
	}
	
}
