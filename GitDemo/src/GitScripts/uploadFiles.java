package GitScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.glass.events.KeyEvent;

public class uploadFiles {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Vanika\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://postimages.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("uploadFile")).click();
		
		driver.getWindowHandle();
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("C:\\Vanika\\New.png"));
		
		//Copying file path to clipboard like Ctrl+C
		StringSelection copy = new StringSelection("C:\\Vanika\\New.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy, null);
		
		//Pasting file path from Clipboard like Ctrl+V
		
		Robot robo = new Robot();
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.setAutoDelay(1000);
		
		robo.keyPress(KeyEvent.VK_V);
		robo.setAutoDelay(1000);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.setAutoDelay(1000);
		
		robo.keyRelease(KeyEvent.VK_V);
		robo.setAutoDelay(1000);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.setAutoDelay(1000);
		
		System.out.println("Image uploaded successfully");
	}

}
