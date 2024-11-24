package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions obj = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//a[text()='brands']"));
		obj.moveToElement(ele).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		Thread.sleep(3000);
		WebElement prod = driver.findElement(By.xpath("(//div[@class='css-ov2o3v']//a)[1]"));
		obj.pause(Duration.ofSeconds(3)).click(prod).perform();
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("L'Oreal Paris")) {
			System.out.println("The Page title contains L'Oreal Paris");
		}else {
			System.out.println("The page doesn't contain L'Oreal Paris");
		}
		driver.findElement(By.xpath("//button[@class=' css-n0ptfk']/span")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Shampoo']//following::div")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']//following::div")).click();
		String filter = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		if(filter.contains("Shampoo")) {
			System.out.println("Shampoo filter is applied succesfully");
		}else {
			System.out.println("Shampoo filter is not applied");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
		Set<String> windows = driver.getWindowHandles();
		List<String> win = new ArrayList<String>(windows);
		driver.switchTo().window(win.get(1));
		Thread.sleep(3000);
		WebElement mlSize = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
		Select size = new Select(mlSize);
		size.selectByVisibleText("175ml");
		String price = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e']/span)[2]")).getText();
		String price1 = price.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("The price of the product is: "+price1);
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		driver.findElement(By.xpath("//button[@type='button' and @class='css-g4vs13']")).click();
		Thread.sleep(5000);
		WebElement frame = driver.findElement(By.xpath("//div[@class='    css-1w65igk e1j92jav0']/iframe"));
		driver.switchTo().frame(frame);
		Thread.sleep(8000);
		String totAmount = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		String totAmount1 = totAmount.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("The total amount of the product is: "+totAmount1);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='button' and @class='btn full big']")).click();
		Thread.sleep(3000);
		String grandTot = driver.findElement(By.xpath("(//div[@class='value']//span)[2]")).getText();
		String grandTot1 = grandTot.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("The grand total is: "+grandTot1);
		if(grandTot1.equalsIgnoreCase(totAmount1)) {
			System.out.println("The grand total and total amount are same");
		}else {
			System.out.println("The price differs");
		}
		driver.quit();
	}
}