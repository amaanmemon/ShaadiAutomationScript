package android.shaadi;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import android.shaadi.BaseTest;

import com.gargoylesoftware.htmlunit.javascript.host.Location;
import com.gargoylesoftware.htmlunit.javascript.host.Map;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSKeyCode;
public class BasePageActions  extends BaseTest{
	public static String pass;
	public static String teci;
	public static String text;
	public static String actual1;
	public static String textOFElement;
	public static String report_date;
	public static String report_date1 ;
	public static Properties prop = new Properties();
	public static String mahi;
	public static String feature_type = null;

	public static String currecntTime() {
		DateFormat dateFormat = new SimpleDateFormat("E-yyyy-MM-dd-'at'-hh-mma");
		// get current date time with Date()
		Date date = new Date();

		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		report_date1 = dateFormat.format(date);
		report_date = report_date1.toLowerCase();
		System.out.println("cureent time is" + report_date);
		return report_date;
	}

	public static void timeout(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void scrollios(String move){
		//down,up,left,right
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap scrollObject = new HashMap();
		scrollObject.put("direction", move);
		js.executeScript("mobile: scroll", scrollObject);

	}

	public static void click(WebElement locator, String description, String tc) {
		try {

			locator.isEnabled();
			locator.click();
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);
		   }
		}
		
		public static void InputValue(WebElement locator, String data, String description, String tc) {
			try {

				locator.isEnabled();
				locator.sendKeys(data);	
				extentTest.log(LogStatus.PASS, description);
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException:");
				System.out.println(e.getMessage());
				extentTest.log(LogStatus.FAIL, description);
				System.out.println("element not found :  " + locator + description);
				takeScreenshot(tc);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				extentTest.log(LogStatus.FAIL, description);
				takeScreenshot(tc);
			}
	}

	public static void clickMultiple(List <WebElement> locator, int index, String description, String tc) {
		try {
			locator.get(index).isEnabled();
			locator.get(index).click();
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + locator + description);
			takeScreenshot(tc);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tc);

		}

	}

	public static void takeScreenshot(String tcid) 
	{
		try{
			File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(SrcFile, new File(BaseTest.ScreenshotDirName+"/" + tcid+".PNG"));
		}
		catch(Exception ex)
		{
			System.out.println(" path: ./ScreenShot/"+ tcid + ".PNG");
			System.out.println("got exeception in screenshoot method");
			System.out.println(ex);
		}
	}

	public static void elementNotPresent(WebElement locator,
			String description, String tcid) {
		try {

			boolean value = locator.isDisplayed();

			if (value == true) {
				extentTest.log(LogStatus.FAIL, description);
			} else {
				extentTest.log(LogStatus.FAIL, description);
			}

		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.PASS, description);
			takeScreenshot(tcid);

		}
	}

	public static void elementIsPresent(WebElement locator, String description,
			String tcid) {
		boolean value = locator.isDisplayed();
		try {
			System.out.println("boolean value is :" + value);
			System.out.println( "Element presetnt: " + description);

			if (value == true) {
				extentTest.log(LogStatus.PASS, description);

			} else {
				extentTest.log(LogStatus.FAIL, description);
			}

		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);
		}
	}

	public static String FeaturedType(WebElement locator, String description, String tcid) {
		String value = locator.getAttribute("name");
		try {
			if(value != null && !isNullOrEmpty(value))
			{
				locator.isEnabled();
				locator.click();    
			}

		} catch (NoSuchElementException e) {
			takeScreenshot(tcid);
			extentTest.log(LogStatus.FAIL, description);
		}
		return value;
	}

	public static void WebUrl(WebElement locator, String description, String tcid) {
		locator.isEnabled();
		locator.click();
		try {
			extentTest.log(LogStatus.PASS, description);
		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);
		}
	}


	public static void dataIsPresentNumber(WebElement locator, String description,
			String tcid) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			boolean value = false;
			double x = locator.getText().length();
			String t = locator.getText();
			if(x>0 && StringUtils.isNumeric(t))
				value=true;
			else if(x>0  && t.matches("[0-9.]+"))
			{
				String[] a = t.split("\\.");
				int decimals = a[1].length();
				if(decimals <= 1)
					value=true;
			}
			System.out.println("boolean value is :" + value);

			if (value == true) {
				extentTest.log(LogStatus.PASS, description);

			} else {
				extentTest.log(LogStatus.FAIL, description);
			}
		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);

		}
	}

	public static void dataIsPresent(WebElement locator, String description,
			String tcid) {
		try {

			boolean value = false;
			double x = locator.getText().length();
			String t = locator.getText();
			if(x>0 && !t.toLowerCase().contains("null") && !isNullOrEmpty(t) && !isNullOrWhitespace(t))
				value= true;

			System.out.println("boolean value is :" + value);

			if (value == true) {
				extentTest.log(LogStatus.PASS, description);

			} else {
				extentTest.log(LogStatus.FAIL, description);
			}

		} catch (NoSuchElementException e) {
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);

		}
	}

	public static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	public static boolean isNullOrWhitespace(String s) {
		return s == null || isWhitespace(s);

	}
	private static boolean isWhitespace(String s) {
		int length = s.length();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				if (!Character.isWhitespace(s.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static void CheckImage(WebElement ImageFile, String description, String tcid) {

		try{
			Dimension size = ImageFile.getSize();
			Boolean ImagePresent; 
			//String test = ImageFile.getAttribute("visible");

			if(size.height > 0 && size.width > 0 && ImageFile.isDisplayed())
			{
				ImagePresent = true;
			}  
			else
			{
				ImagePresent = false;
			}
			if (!ImagePresent)
			{
				System.out.println("Image not displayed.");
				extentTest.log(LogStatus.FAIL, description);
				takeScreenshot(tcid);
			}
			else
			{
				System.out.println("Image displayed.");
				extentTest.log(LogStatus.PASS, description);
			}
		}
		catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException:");
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			System.out.println("element not found :  " + ImageFile + description);
			takeScreenshot(tcid);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);

		}

	}

	public static void verifyTextAmaan(WebElement locator, String value,String description, String tcid) 
	{
		String actual=null;
		try {
			actual = locator.getText();
			if(actual==null)
			{
				actual=locator.getAttribute("value");
			}
			if (actual.equals(value)) {
				extentTest.log(LogStatus.PASS, description);
				System.out.println("Actual Result:" +actual);
				System.out.println("Expected Result:" +value);
			} else {
				extentTest.log(LogStatus.FAIL, description);
				System.out.println("text not  matched ="+value+" = "+actual);
				takeScreenshot(tcid);
				System.out.println("text not matched :  " + description);
				System.out.println(actual + "  not equals  " + value);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);
			System.out.println("element not found" + locator + description);

		}catch (Exception e) {
			System.out.println(e.getMessage());
			extentTest.log(LogStatus.FAIL, description);
			takeScreenshot(tcid);
		}
	}

	public static void verifyText(WebElement locator,String expectedText,String description){
		try{
			String ActualValue = locator.getText();
			String Actual = ActualValue;
			String expected = ExcelUtils.readCell(expectedText);
			System.out.println("Actual---------> "+Actual);
			System.out.println("Expected-------> "+expected);
			if(Actual.equals(expected)){
				System.out.println(description + " Verified");
			}
			else{
				takeScreenshot(description);
				System.out.println("Actual---------> "+Actual);
				System.out.println("Expected-------> "+expected);
				extentTest.log(LogStatus.PASS, description);
				System.out.println("Fail to verify "+ description);
			}
		}catch (Exception e) {
			e.printStackTrace();
			extentTest.log(LogStatus.FAIL, "<span style='font-weight:bold;'>Failure trace Selenium:" + e.toString() + "</span>" );
			System.out.println(description +"not found to verify Text");
		}
	}

	public static void verifyTextMultiple(List <WebElement> locator,int index, String expectedText,String description){
		try{
			String ActualValue = locator.get(index).getText();
			String Actual = ActualValue;
			String expected = ExcelUtils.readCell(expectedText);
			System.out.println("Actual---------> "+Actual);
			System.out.println("Expected-------> "+expected);
			if(Actual.equals(expected)){
				System.out.println(description + " Verified");
			}
			else{
				takeScreenshot(description);
				System.out.println("Actual---------> "+Actual);
				System.out.println("Expected-------> "+expected);
				extentTest.log(LogStatus.PASS, description);
				System.out.println("Fail to verify "+ description);
			}
		}catch (Exception e) {
			e.printStackTrace();
			extentTest.log(LogStatus.FAIL, "<span style='font-weight:bold;'>Failure trace Selenium:" + e.toString() + "</span>" );
			System.out.println(description +"not found to verify Text");
		}
	}

	public static int GetElementText(WebElement locator, String description,String tcid)

	{
		int  count=0;
		try
		{
			String Counttext=locator.getText();
			System.out.println(" count text ="+Counttext);
			count= Integer.parseInt(Counttext) ;
			System.out.println("from function badge="+ count);
			return count;
		}
		catch(NoSuchElementException e)
		{

			extentTest.log(LogStatus.FAIL, e.getMessage());
			takeScreenshot(tcid);
			return count;
		}
		catch(Exception ex)
		{
			extentTest.log(LogStatus.FAIL, ex.getMessage());
			takeScreenshot(tcid);
			return count;

		}

	}

	public static void scroll(WebElement from){
		try{
			int x = from.getLocation().getX();
			int y = from.getLocation().getY();
			TouchAction action = new TouchAction((io.appium.java_client.MobileDriver) driver);
			action.press(x,y).moveTo(x,y-20).release().perform();
		}catch(Exception e){
			System.out.println("---------SCROLL FAILED--------");

		}
	}

	public static void scrollUpToDownMultiple(List<WebElement> from,int index,int index1, List<WebElement> to){
		try{

			Point value =  from.get(index).getLocation();
			int x = value.x;
			int y = value.y;
			Point value1 =  to.get(index1).getLocation();
			int x1 = value1.x;
			int y1 = value1.y;
			TouchAction ts = new TouchAction(driver);
			ts.press(x, y).moveTo(x1,y1).release().perform();
		}catch(Exception e){
			System.out.println("---------SCROLL FAILED--------");
		}

	}

	public static void scrollUpToDown(WebElement from,int index1,int index, WebElement to){
		try{

			Point value =  from.getLocation();
			int x = value.x;
			int y = value.y;
			Point value1 =  to.getLocation();
			int x1 = value1.x;
			int y1 = value1.y;
			driver.swipe(x1, y1, x, y, 1200);
		}catch(Exception e){
			System.out.println("---------SCROLL FAILED--------");
		}

	}

	public static void waitForSometime(int time) {

		try {
			Thread.sleep(time);
			System.out.println("wait for" + time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean testRunOnly(String expectedmatch){

		if(ExcelUtils.keysValue!=null && ExcelUtils.keysValue.size()>0){

			return ExcelUtils.keysValue.containsKey(expectedmatch);
		}     

		return false;
	}

}
