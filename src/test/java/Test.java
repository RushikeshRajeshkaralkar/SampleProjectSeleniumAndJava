import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {


	public static void main(String[] args) {
		
	
    String dateTime ="12/07/2014 9:00 PM";

	System.setProperty("webdriver.gecko.driver",
			"C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();

    driver.manage().window().maximize();
    
    driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.findElement(By.xpath("//input[@title='datetimepicker']")).sendKeys(dateTime);
    
    WebElement valuetime= driver.findElement(By.xpath("//input[@title='datetimepicker']"));
   
    String value=valuetime.getText();
    
    System.out.println("vlaue of time is enter :  "+value);
     
    
    driver.close();
	

	}
}
