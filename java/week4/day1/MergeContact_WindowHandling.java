package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact_WindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lis = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lis.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[4]//td")).click();
		//driver.close();
		driver.switchTo().window(lis.get(0));
		driver.findElement(By.xpath("//input[@name='partyIdTo']/following::img")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> lis1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(lis1.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[6]")).click();
		//driver.close();
		driver.switchTo().window(lis.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
		String title = driver.getTitle();
		if(title.contains("View")) {
			System.out.println("Merge contact is successful");
		}else {
			System.out.println("Merge contact is not successful");
		}
		driver.close();
	}
}