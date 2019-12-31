package Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.StaticInitializerCoercer;
import org.testng.annotations.Test;

public class classby {

	@Test
	public void classbymethod() throws InterruptedException, IOException {

		
		Properties pro=new Properties();
		FileInputStream fil=new FileInputStream("A:\\JavaPrograms\\SeleniumPractice\\src\\test\\java\\config.properties");
		pro.load(fil);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);

		driver.get("https://book.spicejet.com/");

		By b1 = By
				.xpath("//input[@name='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']");

		By b2 = By.xpath(
				"//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT']");

		WebElement element = driver.findElement(b1);
		element.click();
		List<WebElement> set1 = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//div//ul//li"));

		set1.addAll(driver.findElements(By.xpath("//div[@id='dropdownGroup2']//div//ul//li")));

		System.out.println("------------------First DropDown List ------------------------");
		for (int i = 0; i < set1.size(); i++) {

			try {
				String setlist1 = set1.get(i).getText();
				System.out.println(setlist1);

				if ((pro.getProperty("DepartureCity")).equalsIgnoreCase(setlist1)) {
					set1.get(i).click();
					break;
				}

			} catch (Exception e) {
				System.out.println("Enter Correct City Name");
			}

		}

		Thread.sleep(2000);

		WebElement element2 = driver.findElement(b2);
		element2.click();

		List<WebElement> set2 = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//div//ul//li"));
		set2.addAll(driver.findElements(By.xpath("//div[@id='dropdownGroup2']//div//ul//li")));

		System.out.println("------------------Sacond DropDown List ------------------------");
		for (int i = 0; i < set2.size(); i++) {

			try {

				String setlist3 = set2.get(i).getText();
				System.out.println(setlist3);
				if ((pro.getProperty("ArrivalCity")).equalsIgnoreCase(setlist3)) {
					set2.get(i).click();
					break;
				}

			} catch (Exception e) {
				System.out.println("Enter Correct City Name");
			}

		}

		String Excepted = pro.getProperty("ExceptedYear");

		WebElement FirstTextFiled = driver.findElement(By.xpath("//input[@id='custom_date_picker_id_1']"));
		FirstTextFiled.click();

		Thread.sleep(2000);

		String CureentDate = driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']"))
				.getText();

		Thread.sleep(2000);

		System.out.println("Cureent Date : " + CureentDate);

		Thread.sleep(2000);

		String nextDate = driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-last']//div[@class='ui-datepicker-title']"))
				.getText();

		System.out.println("Next date : " + nextDate);

		Thread.sleep(2000);

		if (Excepted.equalsIgnoreCase(CureentDate)) {
			System.out.println("Cureent Date is " + CureentDate);
			Thread.sleep(2000);
			List<WebElement> list1 = driver.findElements(
					By.xpath("//div[@cl" + "ass='ui-datepicker-group ui-datepicker-group-first']//table//td"));

			for (int i = 0; i < list1.size(); i++) {
				String listString1 = list1.get(i).getText();
			//	System.out.println(listString1);

				if (Excepted.equalsIgnoreCase(CureentDate) && listString1.equalsIgnoreCase(pro.getProperty("ExceptedDate"))) {
					list1.get(i).click();
					System.out.println("This Is Date Of Select : " + listString1+""+Excepted);
					break;
				}
			}

			Thread.sleep(2000);

			List<WebElement> list2 = driver
					.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table//td"));

			System.out.println("----------------------//---------------------");
			for (int i = 0; i < list2.size(); i++) {
				String listString2 = list2.get(i).getText();
				// System.out.println(listString2);
			}

		} else {
			for (int i = 0; i < 12; i++) {
				WebElement next = driver.findElement(By.xpath(
						"//div[@class='ui-datepicker-group ui-datepicker-group-last']//span[@class='ui-icon ui-icon-circle-triangle-e']"));
				next.click();
				Thread.sleep(3000);

				CureentDate = driver.findElement(By.xpath(
						"//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']"))
						.getText();
			//	System.out.println("Inside else cureent Date : " + CureentDate + " : " + i);
				if (Excepted.equalsIgnoreCase(CureentDate)) {
					System.out.println("Current Date is Click");
					break;

				}

			}

			Thread.sleep(2000);
			List<WebElement> list1 = driver.findElements(
					By.xpath("//div[@cl" + "ass='ui-datepicker-group ui-datepicker-group-first']//table//td"));

			for (int j = 0; j < list1.size(); j++) {
				String listString1 = list1.get(j).getText();
				// System.out.println(listString1);

				if (Excepted.equalsIgnoreCase(CureentDate) && listString1.equalsIgnoreCase(pro.getProperty("ExceptedDate"))) {
					list1.get(j).click();
					System.out.println("This is Date OF Selected : " + listString1+""+Excepted);
					break;
				}
			}

			Thread.sleep(2000);

			List<WebElement> list2 = driver
					.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table//td"));

			System.out.println("----------------------//---------------------");
			for (int k = 0; k < list2.size(); k++) {
				String listString2 = list2.get(k).getText();
				// System.out.println(listString2);
			}

		}
		Thread.sleep(5000);
		System.out.println("Script Is Pass ");
		driver.close();
	}

}
