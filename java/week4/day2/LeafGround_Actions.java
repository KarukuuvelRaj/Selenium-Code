package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Actions {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions obj = new Actions(driver);
		//Draggable
		WebElement ele = driver.findElement(By.xpath("//span[text()='Drag me around']"));
		obj.dragAndDropBy(ele, 130, 40).perform();
		//Droppable
		WebElement source = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement destination = driver.findElement(By.xpath("//span[text()='Droppable Target']"));
		obj.dragAndDrop(source, destination).perform();
		//Draggable Columns
		WebElement sou = driver.findElement(By.xpath("//span[text()='Quantity']"));
		WebElement des = driver.findElement(By.xpath("//span[text()='Category']"));
		obj.dragAndDrop(sou, des).perform();
		//Draggable Rows
		obj.scrollToElement(driver.findElement(By.xpath("//h5[text()='Draggable Rows']/following-sibling::div//tr[9]")));
		Thread.sleep(4000);
		WebElement souRow = driver.findElement(By.xpath("//h5[text()='Draggable Rows']/following-sibling::div//tr[2]/td"));
		WebElement desRow = driver.findElement(By.xpath("//h5[text()='Draggable Rows']/following-sibling::div//tr[7]/td"));
		obj.dragAndDrop(souRow, desRow).perform();
		Thread.sleep(4000);
		//Resize Image
		WebElement reSize = driver.findElement(By.xpath("//h4[text()='Resize Image']//following::div/div"));
		obj.dragAndDropBy(reSize, 16, 9).perform();
		//Progress Bar
		WebElement start = driver.findElement(By.xpath("//span[text()='Start']"));
		obj.click(start).perform();
		Thread.sleep(13000);
		String text = driver.findElement(By.xpath("//div[@class='ui-progressbar-label']")).getText();
		if(text.contains("100")) {
			System.out.println("Progress is complete");
		}else {
			System.out.println("Progress is not complete");
		}
		//Range Slider
		WebElement newSou = driver.findElement(By.xpath("//div[contains(@class,'ui-slider ui-corner-all')]//span"));
		WebElement newDes = driver.findElement(By.xpath("//div[contains(@class,'ui-slider ui-corner-all')]//span[2]"));
		obj.dragAndDropBy(newSou, 30, 0).perform();
		obj.dragAndDropBy(newDes, -20, 0).perform();
	}

}
