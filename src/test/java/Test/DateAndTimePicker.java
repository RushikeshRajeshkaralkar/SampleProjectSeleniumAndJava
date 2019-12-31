package Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DateAndTimePicker {

	@Test
	public void testDAtePicker() throws Exception {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		/*
		 * DateFormat dateFormat = new Simp leDateFormat("yyyy/MM/dd"); Date date = new
		 * Date(); String currentDate=dateFormat.format(date);
		 */

		String ExceptedDate = "February 2020";
		String Excepted = "";
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//input[@class='hasDatepicker']")).click();
		String currentDate = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println("The Cureent Date is : " + currentDate);

		if (ExceptedDate.equalsIgnoreCase(currentDate)) {
			System.out.println("Current Year  is");

		} else {
			for (int i = 0; i < 12; i++) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				Thread.sleep(2000);
				currentDate = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
				if (ExceptedDate.equalsIgnoreCase(currentDate)) {
					System.out.println("Current Date clicked");
					break;

				}

			}
		}

		List<WebElement> listDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td"));
		System.out.println("List Of Date : " + listDates.size());

		for (int i = 0; i < listDates.size(); i++) {
			String Dates = listDates.get(i).getText();
			/*System.out.println(Dates);*/
			String year = listDates.get(i).getAttribute("data-year");
			
			String monthString = listDates.get(i).getAttribute("data-month");
			Integer valusInterger=Integer.valueOf(monthString);
			int allVales=valusInterger+1;
			

			String TotalDates = Dates + "/" + allVales + "/" + year;
			//System.out.println("Dates id :" + TotalDates);

			if (TotalDates.contains("21/2/2020")) {
				System.out.println("Dates is  :" + TotalDates);
				listDates.get(i).click();
				break;
			}
		}
		driver.close();

	}
}
