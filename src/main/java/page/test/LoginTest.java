package page.test;

import page.actions.*;
import org.testng.annotations.Test;

public class LoginTest extends LoginActions  {

	@Test(priority = 0, groups = "")
	public void Login() throws Exception
	{
		NavigateSignIn();
		InputUserNamePassword("ak5@yahoo.com","test");
		ClickSignIn();
	}
}






