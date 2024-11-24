package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActionsClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions obj = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//span[@class='catText']"));
		obj.moveToElement(ele).perform();
		driver.findElement(By.xpath("//span[text()='Shirts']")).click();
		WebElement ele2 = driver.findElement(By.xpath("//picture[@class='picture-elem']/img"));
		Thread.sleep(3000);
		obj.moveToElement(ele2).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']//div")).click();
	}

}
