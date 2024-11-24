package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Chittorgarh {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tbody/tr"));
		int rowCount = rows.size();
		List<String> obj = new ArrayList<String>();
		System.out.println("Below are the Security names displayed in the page:");
		for(int i = 1; i<=rowCount; i++) {
			String names = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tbody/tr[" + i + "]/td[3]")).getText();
			System.out.println(names);
			obj.add(names);
		}	
		Set<String> obj1 = new HashSet<String>(obj);
		if(obj1.size() == obj.size()) {
			System.out.println("No duplicate names displayed");
		}else {
			System.out.println("Duplicate name(s) displayed");
		}
		driver.close();
	}
}