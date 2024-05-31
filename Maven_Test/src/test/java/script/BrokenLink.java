package script;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) {
		try {
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com/");

			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println(links.size());

			for (WebElement link : links) {
				String linkurl = link.getAttribute("href");

				URL url = new URL(linkurl);
				URLConnection openConnection = url.openConnection();
				HttpURLConnection httpurlconnection = (HttpURLConnection) openConnection;

				httpurlconnection.connect();

				if (httpurlconnection.getResponseCode() == 200) {
					System.out.println(httpurlconnection.getResponseCode() + " "
							+ httpurlconnection.getResponseMessage() + " " + linkurl);
				} else {
					System.err.println(httpurlconnection.getResponseCode() + " "
							+ httpurlconnection.getResponseMessage() + " " + linkurl);
				}

				httpurlconnection.disconnect();
			}
		} catch (Exception e) {

		}

	}
}
