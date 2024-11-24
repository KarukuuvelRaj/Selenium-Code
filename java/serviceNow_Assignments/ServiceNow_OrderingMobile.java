package serviceNow_Assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class ServiceNow_OrderingMobile extends BaseClass {
	@Test
	public void orderMobile() throws InterruptedException {
		Thread.sleep(20000);
		dom.findElementByXPath("//span[text()='Service Catalog']").click();
		Thread.sleep(20000);
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("(//td[@class='homepage_category_only_description_cell']//h2)[8]")).click();
		driver.findElement(By.xpath("//a[@class='service_catalog']/strong")).click();
		WebElement sel1 = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select obj = new Select(sel1);
		obj.selectByVisibleText("Gold");
		WebElement sel2 = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select obj1 = new Select(sel2);
		obj1.selectByVisibleText("128");
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		String text = driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText();
		if(text.contains("submitted")) {
			System.out.println("Order is placed successfully");
		}else {
			System.out.println("Order is not placed");
		}
		String requestId = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("The request number is: "+requestId);
	}
}