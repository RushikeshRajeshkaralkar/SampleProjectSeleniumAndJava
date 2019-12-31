import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest {

	@Test
	public void googleSerch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("java");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='sbtc']//div"));
		int listSize = list.size();
		System.out.println(listSize);
		for (int i = 0; i < listSize; i++) {
			String listof = list.get(i).getText();
			if (("javascript").equalsIgnoreCase(listof)) {
				list.get(i).click();
				break;
			}

		}

		driver.close();
	}

}
