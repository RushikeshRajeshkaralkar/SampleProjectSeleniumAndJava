package Test;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipkart_Serach {

	@Test
	public void MobilePrice() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		WebElement loginalert = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		if (loginalert.isDisplayed()) {
			loginalert.click();
		}

		String parentwindow = driver.getWindowHandle();
		Set<String> chiledwindow = driver.getWindowHandles();

		int count = chiledwindow.size();
		for (String chile : chiledwindow) {
			if (!parentwindow.equalsIgnoreCase(chile)) {
				driver.switchTo().window(chile);
				driver.close();
				driver.switchTo().window(parentwindow);
				break;
			}
		}

		System.out.println(parentwindow);

		WebElement electron = driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']"));
		Actions action = new Actions(driver);
		action.moveToElement(electron).build().perform();

		List<WebElement> listElectornic = driver.findElements(By.xpath("//li[@class='_2GG4xt']//ul/li/a"));

		System.out.println(listElectornic.size());

		for (int i = 0; i < listElectornic.size(); i++) {
			String listofelement = listElectornic.get(i).getText();
			System.out.println(listofelement);
			if (("oppo").equalsIgnoreCase(listofelement)) {
				listElectornic.get(i).click();
				break;
			}

		}
		Thread.sleep(50000);

		List<WebElement> moblielist = driver
				.findElements(By.xpath("//div[@class='_1HmYoV hCUpcT']//div[@class='_3wU53n']"));
		System.out.println(moblielist.size());

		for (int i = 0; i < moblielist.size(); i++) {

			String mobilename = moblielist.get(i).getText();
			System.out.println(mobilename);
			if (("OPPO F11 (Marble Green, 128 GB)").equalsIgnoreCase(mobilename)) {
				moblielist.get(i).click();
				System.out.println("All Window Count " + count);
				for (String child : chiledwindow) {
					if (!parentwindow.equalsIgnoreCase(child)) {
						driver.switchTo().window(child);
						String mobilepric = driver
								.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']/../../div/div")).getText();

						System.out.println("price of mobile " + mobilepric);

						break;

					}

				}
				break;
			}

		}

		driver.close();

	}
}
