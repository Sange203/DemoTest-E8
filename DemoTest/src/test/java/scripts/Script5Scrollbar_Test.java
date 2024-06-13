package scripts;

import genericlib.BaseClass;
import genericlib.Methods;

public class Script5Scrollbar_Test extends BaseClass {

	public void ScrollDown() throws Throwable {

		Thread.sleep(4000);
		ms=new Methods();
		ms.scrollDown(driver);
		Thread.sleep(4000);
	}
}
