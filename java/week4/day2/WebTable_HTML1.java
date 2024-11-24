package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_HTML1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//RowCount
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		System.out.println("The rows count is: "+rows.size());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='attributes-list']//tr/th"));
		System.out.println("The coloumn count is: "+cols.size());
		driver.close();
		}
}