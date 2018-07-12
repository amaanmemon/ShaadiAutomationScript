package page.test;

import page.actions.*;
import org.testng.annotations.Test;

public class SignupTest extends SignupActions  {

	@Test(priority = 0, groups = "")
	public void Signup() throws Exception
	{
		NavigateSignIn();
	}
};
