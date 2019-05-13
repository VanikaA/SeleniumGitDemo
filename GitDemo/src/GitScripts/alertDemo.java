package GitScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Vanika\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(4000);
		js.executeScript("alert('Lets go to a party today!!');");
	}

}
