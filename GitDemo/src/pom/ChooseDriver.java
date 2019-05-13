package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ChooseDriver {

	public static WebDriver use(String browser)
	{
		if(browser.equalsIgnoreCase("c"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Vanika\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Vanika\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else if (browser.equalsIgnoreCase("f"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Vanika\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
			return null;
		}
	}
}
