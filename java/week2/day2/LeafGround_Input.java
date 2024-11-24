package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Input {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']")).sendKeys("Raj");
		driver.findElement(By.xpath("//h5[text()='Append Country to this City.']/following::input")).sendKeys("Madurai");
		WebElement one = driver.findElement(By.xpath("//input[@disabled='disabled']"));
		if(one.isEnabled()) {
			System.out.println("The field is enabled");
		}else System.out.println("The field is disabled");
		driver.findElement(By.xpath("//h5[text()='Clear the typed text.']/following::input")).clear();
		String text = driver.findElement(By.xpath("//h5[text()='Retrieve the typed text.']/following::input")).getAttribute("value");
		System.out.println("The retrieved text is: "+text);
		driver.findElement(By.xpath("//input[@placeholder='Your email and tab']")).sendKeys("abc@gmail.com",Keys.TAB);
		WebElement abtYours = driver.findElement(By.xpath("//textarea[@placeholder='About yourself']"));
		if(abtYours.equals(driver.switchTo().activeElement())) {
			System.out.println("Cursor moved to next element");
		}else System.out.println("Cursor is not moved");
		abtYours.sendKeys("Trying to become an Automation Engineer");
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("This is text editor field");
		driver.findElement(By.xpath("(//h5[text()='Just Press Enter and confirm error message*']/following::input)[2]")).sendKeys(Keys.ENTER);
		String errMsg = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
		System.out.println("The error message displayed in the webpage after clicking enter button is: "+errMsg);
		WebElement labelPos = driver.findElement(By.xpath("//label[@class='ui-outputlabel ui-widget']"));
		Point location1 = labelPos.getLocation();
		driver.findElement(By.xpath("//span[@class='ui-float-label']//input")).click();
		Point location2 = labelPos.getLocation();
		if(location1.equals(location2)) {
			System.out.println("Position not changed");
		}else System.out.println("Position changed");
		driver.findElement(By.xpath("//li[@class='ui-autocomplete-input-token']//input")).sendKeys("t");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//ul[contains(@class,'ui-autocomplete-items ui-autocomplete')]//li)[3]")).click();
		
	}

}
