package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions obj = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		obj.moveToElement(ele).perform();
		driver.findElement(By.xpath("//span[@class='linkTest' and text()='Sports Shoes']")).click();
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		String shoeCount = count.replaceAll("[^a-zA-Z0-9 ]", "");
		System.out.println("The count of the sports shoe are:"+shoeCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(3000);
		WebElement arrow = driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']"));
		driver.executeScript("arguments[0].click()", arrow);
		Thread.sleep(3000);
		WebElement sort = driver.findElement(By.xpath("(//ul[@class='sort-value']//li)[2]"));
		driver.executeScript("arguments[0].click()", sort);
		/*List<WebElement> sortPrices = driver.findElements(By.xpath("//span[contains(@id,'display-price')]"));
		int size = sortPrices.size();
		for(int i=1; i<=size; i++) {
			if(sortPrices.get(i)).(sortPrices.get(i+1)){
				
			}*/
		WebElement one = driver.findElement(By.xpath("//input[@type='text' and @name='fromVal']"));
		one.clear();
		one.sendKeys("900");
		WebElement two = driver.findElement(By.xpath("//input[@type='text' and @name='toVal']"));
		two.clear();
		two.sendKeys("1200");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View More ']")).click();
		driver.findElement(By.xpath("//input[@id='Color_s-Yellow']/following-sibling::label")).click();
		String price = driver.findElement(By.xpath("//div[@class='filters']//a")).getText();
		System.out.println(price);
		if(price.contains("Rs. 900 - Rs. 1200")) {
			System.out.println("Price range filter is applied successfully");
		}else {
			System.out.println("Price range is not applied");
		}
		String color = driver.findElement(By.xpath("(//div[@class='navFiltersPill']//a)[2]")).getText(); 
		System.out.println(color);
		if(color.contains("Yellow")) {
			System.out.println("Colour is selected sccessfully");
		}else {
			System.out.println("Color is not selected");
		}
		WebElement pic = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		Thread.sleep(5000);
		obj.moveToElement(pic).perform();
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']//div")).click();
		String amount = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span")).getText();
		String amount1 = amount.replaceAll("[^0-9]", "");
		System.out.println("The cost of the product is: Rs."+amount1);
		String percent = driver.findElement(By.xpath("(//div[@class='product-price pdp-e-i-PAY-l clearfix']/span)[2]")).getText();
		String percent1 = percent.replaceAll("[^0-9%]", "");
		System.out.println("The discount percentage of the product is: "+percent1);
		WebElement pic1 = driver.findElement(By.xpath("//div[@class='col-xs-11 quickViewModal ']"));
		File source = pic1.getScreenshotAs(OutputType.FILE);
		File des = new File("./Snaps/Screenshot-01.png");
		FileUtils.copyFile(source, des);
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		driver.quit();
	}
}