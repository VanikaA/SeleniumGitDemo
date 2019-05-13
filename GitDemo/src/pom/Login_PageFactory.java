package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_PageFactory extends listenerDemo2{

	WebDriver driver;
	
	@FindBy(how=How.ID,using="Email")
	WebElement uName;
	
	@FindBy(how=How.ID,using="Password")
	WebElement pwd;
	
	@FindBy(how=How.XPATH, using="//input[@value='Log in']")
	WebElement loginBtn;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement getAccName;
	
	@FindBy(how=How.LINK_TEXT,using="Log out")
	WebElement logOut;
	
	public void login(String un, String pass)
	{
		uName.sendKeys(un);
		pwd.sendKeys(pass);
		loginBtn.click();
	}
	
	public String verify()
	{
		String accName= getAccName.getText();
		return accName;
	}
	
	public void logout()
	{
		logOut.click();
		driver.close();
	}
	
	public Login_PageFactory(WebDriver driver)
	{
		this.driver=driver;
	}
}
