package android.shaadi;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import jxl.Workbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import page.objects.*;
import android.shaadi.BasePageActions;
import android.shaadi.ExcelUtils;
import android.shaadi.Reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseTest {

	public static ExtentTest extentTest;
	public static String baseDir;
	public static String ScreenshotDirName;
	public static AppiumDriver driver;
	public static ExtentReports report = null;
	public static ExcelUtils xlsUtil;
	static Hashtable table = new Hashtable();

	@Parameters({"environment","runEnvironment","baseDirPath","screenshotDirName",
		"app","appPackage","browserName","url","deviceName","platformVersion", "platformName", "appiumVersion",
		"appPath","bundleId","udid","testDroidusername","testDroidpassword",
		"testdroid_testrun","testdroid_project","testdroid_description","testdroid_app","appActivity"})

	@BeforeSuite
	public static void setup(String environment, String runEnvironment, String baseDirPath, String screenshotDirName,
			String app, String appPackage, String browserName, String url, String deviceName, String platformVersion, String platformName, String appiumVersion,
			String appPath, String bundleId, String udid, String testdroidUsername, String testdroidPassword,
			String testdroidTestrun,String testdroidProject ,String testdroidDescription,String testdroidApp,String appActivity)throws Exception 
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		baseDir=baseDirPath;
		System.out.println("base dir is " +baseDir);
		ScreenshotDirName=screenshotDirName ;
		System.out.println("base screenshot is " +ScreenshotDirName);
		report = Reports.getReports(baseDirPath);
		report.addSystemInfo("Environment", environment);
		String ObjectEnv = appPackage;


		File src = new File("src/main/resources/testdata.xls");
        System.out.println("excle path is " +src.getAbsolutePath());
        Workbook we = Workbook.getWorkbook(src);
        for (int i = 0; i < we.getNumberOfSheets(); i++) {
            xlsUtil = new ExcelUtils(table, we, i);
            ExcelUtils.rowdictionary();
        }	

		try {

			switch(runEnvironment){

			case "iOSLocal":
				capabilities.setCapability("deviceName", deviceName);
				capabilities.setCapability("app", appPath);
				capabilities.setCapability("bundleId",bundleId);
				capabilities.setCapability("udid",udid);
				capabilities.setCapability("automationName", "XCUITest");
				capabilities.setCapability("useNewWDA", false);
				capabilities.setCapability("sendKeyStrategy", "setValue");
				capabilities.setCapability("showIOSLog", true);
				capabilities.setCapability("showXcodeLog", true);
				driver = new IOSDriver(new URL(url), capabilities);
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);


			case "iOSTestDroid":
				capabilities.setCapability("bundleId",bundleId);
				capabilities.setCapability("testdroid_username",testdroidUsername);
				capabilities.setCapability("testdroid_password", testdroidPassword);
				capabilities.setCapability("testdroid_project", testdroidProject);
				capabilities.setCapability("testdroid_description",testdroidDescription);
				capabilities.setCapability("testdroid_testrun", testdroidTestrun);
				capabilities.setCapability("testdroid_target", "ios");
				capabilities.setCapability("testdroid_device",deviceName);
				capabilities.setCapability("automationName", "XCUITest");
				capabilities.setCapability("platformName", "ios");
				capabilities.setCapability("testdroid_app",testdroidApp);
				driver = new IOSDriver(new URL(url), capabilities);
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);


			case "androidLocal":
				System.out.println("Testing started");
				capabilities.setCapability("deviceName", deviceName);
				capabilities.setCapability("platformVersion", platformVersion);
				capabilities.setCapability("platformName", platformName);
				capabilities.setCapability("appium-version", appiumVersion);
				capabilities.setCapability("app", app); 
				capabilities.setCapability("appPackage", appPackage); 
				capabilities.setCapability("appActivity", appActivity);
				driver = new AndroidDriver(new URL(url), capabilities);
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				Thread.sleep(15000);
				

			case "androidTestDroid":
				capabilities.setCapability("app-package", bundleId); //Replace with your app's package
				capabilities.setCapability("bundleId",bundleId);
				capabilities.setCapability("testdroid_username",testdroidUsername);
				capabilities.setCapability("testdroid_password", testdroidPassword);
				capabilities.setCapability("testdroid_project", testdroidProject);
				capabilities.setCapability("testdroid_description",testdroidDescription);
				capabilities.setCapability("testdroid_testrun", testdroidTestrun);
				capabilities.setCapability("testdroid_target", "android");
				capabilities.setCapability("testdroid_device",deviceName);
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			}
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}

	

	@AfterSuite
	public static void tearDown() throws Exception {
		try {
			driver.quit();
		} catch (Exception ex) {
		}

	}

	@BeforeMethod
	public void nameBefore(Method method) {

		extentTest = report.startTest(method.getName(),method.getAnnotation(org.testng.annotations.Test.class).description()).assignCategory(
				method.getAnnotation(org.testng.annotations.Test.class)
				.groups()).assignAuthor("Amaan Memon");
		System.out.println("we are in " + method.getName());

	}

	@AfterMethod
	public void afterMethod(Method method) {
		report.endTest(extentTest);
		report.flush();
	}

	@BeforeClass
	public void beforeclass() {

		String className = this.getClass().getSimpleName();
		String[] parts = className.split("T", 2);
		String string1 = parts[0];

		System.out.println("Class name: " + string1);

		Class s;
		try {
			s = Class.forName("page.objects." + string1 + "Objects");
			Object t = s.newInstance();
			PageFactory.initElements(driver, t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
