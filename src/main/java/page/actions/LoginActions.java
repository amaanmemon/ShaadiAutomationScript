package page.actions;

import android.shaadi.BasePageActions;
import page.objects.LoginObjects;


public class LoginActions extends BasePageActions{
	
	public static void InputUserNamePassword(String UserName, String Password)
	{
		InputValue(LoginObjects.editTextUserName,UserName,"Input Valid UserName","Login-02");
		InputValue(LoginObjects.editTextPassword,Password,"Input Valid Password","Login-03");
		driver.hideKeyboard();
	}	
	
	public static void ClickSignIn() throws InterruptedException
	{
	  click(LoginObjects.btnMainSignIn,"Click on SignIn Button to View Home Screen","Login-04");
	  Thread.sleep(10000);
	}
}
