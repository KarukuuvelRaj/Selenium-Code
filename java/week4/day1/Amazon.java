package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Actions obj = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		obj.scrollToElement(driver.findElement(By.xpath("(//a[contains(@class,'underline-link-text s-link-style a-text-normal')])[5]//span"))).perform();
		String price = driver.findElement(By.xpath("(//a[contains(@class,'underline-link-text s-link-style a-text-normal')])[4]//span")).getText();
		String price1 = price.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("The Price of the first product is: "+price1);
		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath("(//span[@class='a-declarative'])[4]"));
		Thread.sleep(7000);
		obj.pause(Duration.ofSeconds(8)).click(ele).perform();
		String noOfRatings = driver.findElement(By.xpath("//span[@class='a-size-base a-color-secondary totalRatingCount']")).getText();
		System.out.println("The number of customer ratings are: "+noOfRatings);
			}
}