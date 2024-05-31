package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://pos.aksharatraining.in/pos/public/login");

		WebElement username = driver.findElement(By.id("input-username"));
		username.sendKeys("Admin");

		driver.navigate().refresh();
		try {
			username.sendKeys("Admin");
		} catch (Exception e) {
			username = driver.findElement(By.id("input-username"));
			username.sendKeys("Admin");
		}

	}

}
