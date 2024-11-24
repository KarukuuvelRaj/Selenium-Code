package week3.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class List_AJIO {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags", Keys.ENTER);
		driver.findElement(By.xpath("//label[@class='facet-linkname facet-linkname-genderfilter facet-linkname-Men']"))
		.click();
		WebElement fasBags = driver.findElement(By.xpath(
				"//label[@class='facet-linkname facet-linkname-l1l3nestedcategory facet-linkname-Men - Fashion Bags']"));
		driver.executeScript("arguments[0].click()", fasBags);
		Thread.sleep(5000);
		String totCount = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println("The total number of items found is: " + totCount);
		List<WebElement> brands = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println("The list of brands displayed in this page is: "+brands.size()); 
		for (WebElement lists : brands) {
			System.out.println("The brand names are: "+lists.getText());
		}
		/*
		 * System.out.println(" List of Brands"); List<WebElement> bagBrandList
		 * =driver.findElements(By.className("brand")); System.out.println(" Size :" +
		 * bagBrandList.size()); for (WebElement webElement : bagBrandList) { String
		 * text = webElement.getText(); System.out.println(text); }
		 */
		List<WebElement> bagNames = driver.findElements(By.xpath("//div[@class='nameCls']"));
		for (WebElement bags : bagNames) {
			System.out.println("The bag names are: "+bags.getText());
		}
		driver.close();
		/*
		 * List<WebElement> bagNameList = driver.findElements(By.className("nameCls"));
		 * System.out.println(" Size :" + bagNameList.size());
		 * System.out.println(" Names of the Bags"); for (WebElement webElement :
		 * bagNameList) { String text = webElement.getText(); System.out.println(text);
		 * }
		 */
	}
}
