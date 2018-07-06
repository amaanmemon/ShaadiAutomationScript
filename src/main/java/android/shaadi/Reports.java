package android.shaadi;
import android.shaadi.BasePageActions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import data.VerificationData;


public class Reports {
	public static ExtentReports report = null;
	public static ExtentTest extentTest;
	public static String report_name = VerificationData.reportName+BasePageActions.report_date+".html";
	

	public static ExtentReports getReports(String baseDirPath) {
		if (report == null) {
			
			report = new ExtentReports(baseDirPath
					+ report_name);
			report.addSystemInfo("Selenium Version",
					VerificationData.seleniumVersion);
		}
		return report;
	}
}
