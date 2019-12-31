import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import bsh.commands.dir;

public class easyselenium {

	@Test
	public void allMenuLinksname() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("virat kohali");
		Thread.sleep(3000);
		List<WebElement> listdiv = driver
				.findElements(By.xpath("//ul[@role='listbox']//li[@class='sbct']//div[2]//div//span"));

		System.out.println(listdiv.size());

		for (int i = 0; i < listdiv.size(); i++) {
			String listofelement = listdiv.get(i).getText();
			System.out.println(listofelement);
			if (("virat kolhali").equals(listofelement)) {
				listdiv.get(i).click();
				break;
			}
			
			TakesScreenshot sc=(TakesScreenshot)driver;

		}

		driver.close();

	}

}
