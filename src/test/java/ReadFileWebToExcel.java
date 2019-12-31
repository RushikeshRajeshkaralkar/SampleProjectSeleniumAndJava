import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadFileWebToExcel {

	
	@Test
	public void filpcart()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		WebElement loginalert = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		if (loginalert.isDisplayed()) {
			loginalert.click();
		}
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("input")));
		links.addAll(driver.findElements(By.tagName("button")));
		
		for(WebElement i:links)
		{
			String list=i.getText();
			System.out.println(list);
			
		}
		
	}
}
