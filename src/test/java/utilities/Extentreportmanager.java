package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Baseclass;

public class Extentreportmanager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public static ExtentTest Test;
	String reportname;
	
	 public void onStart(ITestContext testcontext) {
		 
		String timestamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		reportname="Test-Report-"+timestamp+".html";
		
		 String reportpath=System.getProperty("user.dir")+"\\reports\\"+ reportname;
		 
		 sparkReporter = new ExtentSparkReporter(reportpath);
		 
		 sparkReporter.config().setDocumentTitle("open cart automation testing");
		 sparkReporter.config().setReportName("open cart functional testing");
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		 extent =new ExtentReports();
		 extent.attachReporter(sparkReporter);

		 extent.setSystemInfo("Application", "Open cart");
		 extent.setSystemInfo("Module", "Customer");
		 extent.setSystemInfo("Sub module", "Login");
		 extent.setSystemInfo("User Name", System.getProperty("user.name"));
		 extent.setSystemInfo("Environment", "QA");
		 
		 String os=testcontext.getCurrentXmlTest().getParameter("os");
		 extent.setSystemInfo("os", os);
		 
		 String browser=testcontext.getCurrentXmlTest().getParameter("browser");
		 extent.setSystemInfo("Browser name", browser);
		 
		 List<String> groups = testcontext.getCurrentXmlTest().getIncludedGroups();
		 if(groups.isEmpty()) {
			 extent.setSystemInfo("grouping",groups.toString());
		 
	 }
	 }
	 public void onTestSuccess(ITestResult result) {
		  Test = extent.createTest(result.getTestClass().getName());
		  Test.assignCategory(result.getMethod().getGroups());
		  Test.log(Status.PASS, result.getName()+" is passed");
		   
	  }
	 

	   public void onTestFailure(ITestResult result) {
			 
		   Test = extent.createTest(result.getTestClass().getName());
			  Test.assignCategory(result.getMethod().getGroups());
			  Test.log(Status.FAIL, result.getName()+" is failed");
			  Test.log(Status.INFO, "Test case failed error:" +result.getThrowable().getMessage());
			  
			  try {
				  String screenshotpath=new Baseclass().captureScreen(result.getName());
				  Test.addScreenCaptureFromPath(screenshotpath);
		  
	  } catch( Exception e1) {
				  e1.printStackTrace();
			  } 	  
			  
	   }
	   public void onTestSkipped(ITestResult result) {
		   
		   Test = extent.createTest(result.getTestClass().getName());
			  Test.assignCategory(result.getMethod().getGroups());
			  Test.log(Status.SKIP, result.getName()+" is skipped");
			  Test.log(Status.SKIP, "Test case failed error:" +result.getThrowable().getMessage());
	   }
	   
	   public void onFinish(ITestContext testcontext) {
		  extent.flush();
		  
	String pathofextentreport=System.getProperty("user.dir")+"\\reports\\"+ reportname;
	File extentreports = new File(pathofextentreport);
	
	try {
		Desktop.getDesktop().browse(extentreports.toURI());
	}catch (IOException e) {
		e.printStackTrace();
	}
	  }

}
