package script;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement twowheeler = driver.findElement(By.xpath("(//span[.='Two Wheelers'])[2]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(twowheeler).perform();

		driver.findElement(By.xpath("//a[.='Electric Vehicles']")).click();
		driver.findElement(By.xpath("//span[.='VIEW ALL']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[.='Brand'])[2]")));
		WebElement brand = driver.findElement(By.xpath("(//div[@class='FtQCb2 _3Owiq+'])[1]"));
		brand.click();
		driver.findElement(By.xpath("(//div[@class='XqNaEv'])[3]")).click();

//		driver.get(driver.getCurrentUrl());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='KzDlHZ'])")));
		List<WebElement> text = driver.findElements(By.xpath("(//div[@class='KzDlHZ'])"));
		
		try {
			for (WebElement bouncetext : text) {
				String text2 = bouncetext.getText();
				System.out.println(text2);
			}
		} catch (Exception e) {
			text = driver.findElements(By.xpath("(//div[@class='KzDlHZ'])"));
			for (WebElement bouncetext : text) {
				String text2 = bouncetext.getText();
				System.out.println(text2);
			}
		}
		
		
		driver.quit();
	}

}
