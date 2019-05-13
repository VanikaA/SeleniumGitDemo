package pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testListenerScript {

	@Test
	public void passTest()
	{
		Assert.assertEquals("SRK", "SRK");
		System.out.println("Test is passed");
	}
	
	@Test
	public void failTest()
	{
		Assert.assertEquals("SRK", "Salman");
		System.out.println("Test is failed");
	}
	
	@Test(dependsOnMethods= {"failTest"})
	public void skipTest()
	{
		Assert.assertEquals("Frog", "Prince");
		System.out.println("Test is skipped");
	}
	
	@Test(dependsOnMethods= {"passTest"})
	public void runTest()
	{
		Assert.assertEquals("Frog", "Frog");
		System.out.println("Dependent test is passed");
	}
}
