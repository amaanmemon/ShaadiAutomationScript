package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsObjects {
	
	@FindBy(id="com.shaadi.android:id/rlMyShaadi")
	public static WebElement tabShaadi;
	
	@FindBy(id="com.shaadi.android:id/tv_upgrade_now")
	public static WebElement btnUpgradeNow;
}