package org.iths.test.sprint2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	
	private WebDriver webdriver;

	public TestSelenium() {
		System.setProperty("webdriver.chrome.driver", "commonFiles/chromedrive/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void openURL(String siteURL) {
		webdriver.get(siteURL);
	}  
	
	public void sendText(String text) {
		WebElement element = webdriver.findElement(By.xpath("/html/body/form/textarea"));
		element.click();
		delay(2000);
		element.sendKeys(text);
	}
	
	public void clickLearn() {
		WebElement element = webdriver.findElement(By.cssSelector("#learn"));
		element.click();
	}
	
	public String getValue() {
		WebElement element = webdriver.findElement(By.cssSelector("#learn"));
		return element.getText();
	}
	
	public void delay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
			}
			catch (InterruptedException a) {
			}
	}
	
	public void quitSelenium() {
		webdriver.quit();
	}
	
}
