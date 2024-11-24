package week4.day1;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LeafGround_Alerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Alert (Simple Dialog)
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		driver.switchTo().alert().accept();
		String text = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		if(text.contains("successfully clicked")) {
			System.out.println("Simple alert is done");
		}else System.out.println("Problem is simple alert");
		//Alert (Confirm Dialog)
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		driver.switchTo().alert().accept();
		String text2 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		if(text2.contains("OK")) {
			System.out.println("Confirm Dialog is done");
		}else {
			System.out.println("Problem in Confirm dialog");
		}
		//Sweet Alert (Simple Dialog)
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following::span")).click();
		WebElement clc = driver.findElement(By.xpath("//span[text()='Dismiss']"));
		driver.executeScript("arguments[0].click()", clc);
		//Sweet Modal Dialog
		driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']/following::span")).click();
		WebElement clc1 = driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]"));
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click()", clc1);
		//Alert (Prompt Dialog)
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following::span")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Raj");
		alert.accept();
		String text3 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		if(text3.contains("Raj")) {
			System.out.println("Prompt dialog is done");
		}else {
			System.out.println("Problem in prompt dialog");
		}
		//Sweet Alert (Confirmation)
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']/following::span")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		//Minimize and Maximize
		driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']/following::span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
		Thread.sleep(3000);
		WebElement close = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']"));
		driver.executeScript("arguments[0].click()", close);
		Thread.sleep(3000);
		driver.close();
	}
}