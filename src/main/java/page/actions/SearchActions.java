package page.actions;

import io.appium.java_client.TouchAction;
import android.shaadi.BasePageActions;
import page.objects.SearchObjects;
import org.openqa.selenium.WebElement;



public class SearchActions extends BasePageActions{
	
	public static void ClickSearch()
	{
	  click(SearchObjects.actionBarItemSearch.get(0),"Click on Search","Search-01");
	}
	
	public static void ClickSearchNow()
	{
	  click(SearchObjects.btnSearchNow,"Click on Search Now","Search-01");
	}
	

	public static void ClickConnectNow()
	{
	  click(SearchObjects.btnConnectNow.get(1),"Click on Connect Now","Search-01");
	}
	
	public static void ClickGotit()
	{
	  click(SearchObjects.btnGotIt,"Click on Button Got it","Search-02");
	}
	
	public static void Scroll()
	{
	  scroll(SearchObjects.imageViewRangeBarHeight);
	}
	
	public static void ScrollAgain()
	{
	  scroll(SearchObjects.dropDownMotherTongue);
	}
	
	public static void ScrollProfilePage()
	{
	  scroll(SearchObjects.btnConnectNow.get(0));
	}
	
	public static void ScrollAgainManglik()
	{
	  scroll(SearchObjects.dropDownState);
	}
	
	public static void ScrollSearchNow()
	{
	  scroll(SearchObjects.dropDownManglik);
	}
	
	public static void ClickMartialStatusDropdown()
	{
	  click(SearchObjects.dropDownMartialStatusList,"Click on Martial Status Dropdown","Search-03");
	}
	
	public static void ClickReligionDropdown()
	{
	  click(SearchObjects.dropDownReligion,"Click on Religion Dropdown","Search-03");
	}
	
	public static void ClickMotherTongueDropdown()
	{
	  click(SearchObjects.dropDownMotherTongue,"Click on Mother Tongue Dropdown","Search-03");
	}
	
	public static void ClickCommunityDropdown()
	{
	  click(SearchObjects.dropDownCommunity,"Click on Community Dropdown","Search-03");
	}
	
	public static void ClickCountryDropdown()
	{
	  click(SearchObjects.dropDownCountry,"Click on Country Dropdown","Search-03");
	}
	
	public static void ClickStateDropdown()
	{
	  click(SearchObjects.dropDownState,"Click on State Dropdown","Search-03");
	}
	
	public static void ClickManglikDropdown()
	{
	  click(SearchObjects.dropDownManglik,"Click on Manglik Dropdown","Search-03");
	}
	
	public static void VerifyProfilesCount()
	{
	  verifyText(SearchObjects.classTextView.get(1)," (45 Profiles)","Search-03");
	}
	
	public static void ClickNeverMarried()
	{
		boolean found = false;
		String strExpected = "Never Married";
		while (!found){
	        int size=0;
	        size = size+SearchObjects.textViewData.size();
	        for (int i = 0; i < size; i++) {
	        	 String strActual= SearchObjects.textViewData.get(i).getText();
	   		  if(strActual.equals(strExpected))
			  {
				  System.out.print("Text: " + SearchObjects.textViewData.get(i).getText());
				  click(SearchObjects.textViewData.get(i),"UnCheck Never Married","Search-05");
				  click(SearchObjects.textViewData.get(i),"Check Never Married","Search-05");
				  found= true;
				  break;
			  }
	        }
	        if(!found){
	        TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
	  		action.press(350,1000).moveTo(350,980).release().perform();
	      }
		}
	}
	
	public static void ClickHindu()
	{
		boolean found = false;
		String strExpected = "Hindu";
		while (!found){
	        int size=0;
	        size = size+SearchObjects.textViewData.size();
	        for (int i = 0; i < size; i++) {
	        	 String strActual= SearchObjects.textViewData.get(i).getText();
	   		  if(strActual.equals(strExpected))
			  {
				  System.out.print("Text: " + SearchObjects.textViewData.get(i).getText());
				  click(SearchObjects.textViewData.get(i),"UnCheck Hindu","Search-05");
				  click(SearchObjects.textViewData.get(i),"Check Hindu","Search-05");
				  found= true;
				  break;
			  }
	        }
	        if(!found){
	        TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
	  		action.press(350,1000).moveTo(350,980).release().perform();
	      }
		}
	}
	
	public static void ClickHindu_MotherTongue()
	{
		boolean found = false;
		String strExpected = "Hindi";
		while (!found){
	        int size=0;
	        size = size+SearchObjects.textViewData.size();
	        for (int i = 0; i < size; i++) {
	        	 String strActual= SearchObjects.textViewData.get(i).getText();
	   		  if(strActual.equals(strExpected))
			  {
				  System.out.print("Text: " + SearchObjects.textViewData.get(i).getText());
				  click(SearchObjects.textViewData.get(i),"Check Hindi","Search-05");
				  found= true;
				  break;
			  }
	        }
	        if(!found){
	        TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
	  		action.press(350,1000).moveTo(350,980).release().perform();
	      }
		}
	}
	
	public static void ClickCommunityData()
	{
		String strExpected = "96K Kokanastha";
		String strExpected1 = "Agri";
		int count=0;
		boolean found = false;
		while (!found){
	        int size=0;
	        size = size+SearchObjects.textViewData.size();
	        for (int i = 0; i < size; i++) {
	        	 String strActual= SearchObjects.textViewData.get(i).getText();
	   		  if(strActual.equals(strExpected) || strActual.equals(strExpected1))
			  {
				  System.out.print("Text: " + SearchObjects.textViewData.get(i).getText());
				  click(SearchObjects.textViewData.get(i),"Check " + strActual,"Search-05");
				  count++;
				  if(count == 2)
					  found= true;
				  break;
			  }
	 
	        }
	        if(!found){
	        TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
	  		action.press(350,1000).moveTo(350,980).release().perform();
	      }
		}
	}
	
	public static void ClickCountryData()
	{
		boolean found = false;
		String strExpected = "USA";
		while (!found){
	        int size=0;
	        size = size+SearchObjects.textViewData.size();
	        for (int i = 0; i < size; i++) {
	        	 String strActual= SearchObjects.textViewData.get(i).getText();
	   		  if(strActual.equals(strExpected))
			  {
				  System.out.print("Text: " + SearchObjects.textViewData.get(i).getText());
				  click(SearchObjects.textViewData.get(i),"Check USA and India","Search-05");
				  found= true;
				  break;
			  }
	        }
	        if(!found){
	        TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
	  		action.press(350,1000).moveTo(350,980).release().perform();
	      }
		}
	}
	
	public static void ClickStateData()
	{
		String strExpected = "Andhra Pradesh";
		String strExpected1 = "Maharashtra";
		int count=0;
		boolean found = false;
		while (!found){
	        int size=0;
	        size = size+SearchObjects.textViewData.size();
	        for (int i = 0; i < size; i++) {
	        	 String strActual= SearchObjects.textViewData.get(i).getText();
	   		  if(strActual.equals(strExpected) || strActual.equals(strExpected1))
			  {
				  System.out.print("Text: " + SearchObjects.textViewData.get(i).getText());
				  click(SearchObjects.textViewData.get(i),"Check " + strActual,"Search-05");
				  count++;
				  if(count == 2)
					  found= true;
				  break;
			  }
	 
	        }
	        if(!found){
	        TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
	  		action.press(350,1000).moveTo(350,980).release().perform();
	      }
		}
	}
	
	public static void ClickManglikData()
	{
		boolean found = false;
		String strExpected = "No Mangliks";
		while (!found){
	        int size=0;
	        size = size+SearchObjects.textViewData.size();
	        for (int i = 0; i < size; i++) {
	        	 String strActual= SearchObjects.textViewData.get(i).getText();
	   		  if(strActual.equals(strExpected))
			  {
				  System.out.print("Text: " + SearchObjects.textViewData.get(i).getText());
				  click(SearchObjects.textViewData.get(i),"Check No Mangliks","Search-05");
				  found= true;
				  break;
			  }
	        }
	        if(!found){
	        TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
	  		action.press(350,1000).moveTo(350,980).release().perform();
	      }
		}
	}
	
	public static void ClickApply()
	{
	  click(SearchObjects.textViewApply,"Click on Apply","Search-05");
	}
}
