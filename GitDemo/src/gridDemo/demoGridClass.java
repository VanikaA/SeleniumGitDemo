package gridDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class demoGridClass {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.ANY);
		
		ChromeOptions options = new ChromeOptions();
		options. addArguments("--disable-extensions");
		WebDriver d = new RemoteWebDriver(new URL("http://10.216.139.100:4444/wd/hub"),dc);
		
		d.get("http://demowebshop.tricentis.com/login");
		Thread.sleep(2000);
		d.findElement(By.id("Email")).sendKeys("testauto1@abc.com");
		d.findElement(By.id("Password")).sendKeys("testauto1");
		d.close();
	}

}
