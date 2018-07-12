package page.actions;

import page.objects.SignupObjects;
import android.shaadi.BasePageActions;

public class SignupActions extends BasePageActions {
	public static void NavigateSignIn()
	{
	  click(SignupObjects.btnNavigateSignIn,"Click on SignIn Button to Navigate Login Page","Login-01");
	}
}

