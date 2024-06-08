package scripts;

import org.testng.annotations.Test;

import genericlib.BaseClass;
import pom.LoginPagePom;

public class ScriptLogin extends BaseClass{

	@Test
	public void login() {
		test=reports.createTest("Login page");

		lp=new LoginPagePom(driver);
		
		//lp.getLoginButton().click();
	}
}
