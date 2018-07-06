package page.objects;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebElement;

public class SearchObjects {
	
	@FindBy(className="android.support.v7.app.ActionBar$Tab")
	public static List<WebElement> actionBarItemSearch;
	
	@FindBy(id="com.shaadi.android:id/btnGotIt")
	public static WebElement btnGotIt;
	
	@FindBy(id="com.shaadi.android:id/btn_search")
	public static WebElement btnSearchNow;
	
	@FindBy(id="com.shaadi.android:id/tv_button3")
	public static List<WebElement> btnConnectNow;
	
	@FindBy(id="com.shaadi.android:id/set_marital_status")
	public static WebElement dropDownMartialStatusList;
	
	@FindBy(id="com.shaadi.android:id/label")
	public static List<WebElement> textViewData;
	
	@FindBy(id="com.shaadi.android:id/tv_apply")
	public static WebElement textViewApply;
	
	@FindBy(id="com.shaadi.android:id/btnSearchByID")
	public static WebElement btnGoToProfile;
	
	@FindBy(id="android.widget.TextView")
	public static List<WebElement> classTextView;
	
	@FindBy(id="com.shaadi.android:id/rangebar_height")
	public static WebElement imageViewRangeBarHeight;
	
	@FindBy(id="com.shaadi.android:id/set_religion")
	public static WebElement dropDownReligion;
	
	@FindBy(id="com.shaadi.android:id/set_display_language")
	public static WebElement dropDownMotherTongue;
	
	@FindBy(id="com.shaadi.android:id/set_caste")
	public static WebElement dropDownCommunity;
	
	@FindBy(id="com.shaadi.android:id/set_country")
	public static WebElement dropDownCountry;
	
	@FindBy(id="com.shaadi.android:id/set_state")
	public static WebElement dropDownState;
	
	@FindBy(id="com.shaadi.android:id/set_manglik")
	public static WebElement dropDownManglik;
}

