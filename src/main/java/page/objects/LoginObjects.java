package page.objects;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebElement;

public class LoginObjects {
	
	@FindBy(id="com.shaadi.android:id/signIn")
	public static WebElement btnNavigateSignIn;
	
	@FindBy(id="com.shaadi.android:id/username")
	public static WebElement editTextUserName;
	
	@FindBy(id="com.shaadi.android:id/password")
	public static WebElement editTextPassword;
	
	@FindBy(id="com.shaadi.android:id/SignInWithProgressbar")
	public static WebElement btnMainSignIn;
	
	@FindBy(name="Search")
	public static WebElement actionBarItemSearch;
	
	@FindBy(id="com.shaadi.android:id/set_marital_status")
	public static WebElement dropDownMartialStatusList;
	
	@FindBy(id="com.shaadi.android:id/label")
	public static WebElement textViewMartialStatusData;
}

