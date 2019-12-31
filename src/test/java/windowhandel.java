import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class windowhandel {

	@Test
	public void windowhandel() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rushikesh\\Desktop\\ChromeDriver79\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		/*String parentwindow = driver.getWindowHandle();

		
		driver.findElement(By.xpath("//a[text()='Good PopUp #1']")).click();
		driver.findElement(By.xpath("//a[text()='Good PopUp #2']")).click();
		driver.findElement(By.xpath("//a[text()='Good PopUp #3']")).click();
		
		Set<String> chiledwindow = driver.getWindowHandles();

		ArrayList<String> ar = new ArrayList<String>(chiledwindow);
		System.out.println(ar.size());
		
		driver.switchTo().window(ar.get(1));
		System.out.println("First : "+driver.getWindowHandle());
		driver.close();
	
		
		driver.switchTo().window(ar.get(2));
		System.out.println("Second :  "+driver.getWindowHandle());
		driver.close();
		
		driver.switchTo().window(ar.get(3));
		System.out.println("Third :  "+driver.getWindowHandle());
		driver.close();
	
		driver.switchTo().window(ar.get(0));
		System.out.println("Zero :  "+driver.getWindowHandle());*/

		
		Dimension d=null;
		
		d=new Dimension(1500, 250);
		d=new Dimension(1200, 700);
		
		
	/*	Point p=new Point(-2000, -2000);
		driver.manage().window().setPosition(p);*/
		driver.manage().window().setSize(d);
		

	}
}
