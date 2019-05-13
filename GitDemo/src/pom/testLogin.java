package pom;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class testLogin {
	
	WebDriver driver;
	Properties p;
	FileInputStream fi;
	Login_PageFactory log;
	
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  fi = new FileInputStream("src\\pom\\input.properties");
	  p = new Properties();
	  p.load(fi);
  }
  
  @Test
  public void verifyLogin() throws InterruptedException {
	  driver = ChooseDriver.use("C");
	  driver.manage().window().maximize();
	  driver.get(p.getProperty("url"));
	  
	  log = PageFactory.initElements(driver, Login_PageFactory.class);
	  
	  log.login(p.getProperty("un"), p.getProperty("pwd"));
	  
	  Thread.sleep(3000);
	  Assert.assertEquals(log.verify(), p.getProperty("un"));
	  
	  System.out.println("Test is passed");
	  
	  log.logout();
  }
}
