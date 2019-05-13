package pom;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class listenerDemo2 implements ITestListener {
	
	
	protected static WebDriver driver;
	protected static ExtentReports reports;
	protected static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***********************");
		System.out.println("Test "+result.getTestClass()+ " " + result.getName()+ " has started");
		test=reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "Test has started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***********************");
		System.out.println("Test "+result.getTestClass()+ " " + result.getName()+ " is successful");
		test=reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***********************");
		System.out.println("Test "+result.getTestClass()+ " " + result.getName()+ " has failed");
		System.out.println("Error message is "+result.getThrowable());
		test.log(LogStatus.SKIP, result.getMethod().getMethodName()+ " Test has failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("***********************");
		System.out.println("Test "+result.getTestClass()+ " " + result.getName()+ " was skipped");
		System.out.println("Error message is "+result.getThrowable());
		test.log(LogStatus.FAIL, result.getMethod().getMethodName()+ " Test was skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("**********************");
		System.out.println("On Start");
		System.setProperty("webdriver.chrome.driver", "C:\\Vanika\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		reports = new ExtentReports("src/pom/test_" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms")
				.format(new Date()) + "reports.html");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		driver.close();
		reports.endTest(test);
		reports.flush();
	}

}
