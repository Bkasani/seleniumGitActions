package com.orangehrm.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Testone {

	@Test
	public void testone() {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		// byid frame
		// driver.switchTo().frame("frame1");
		// by index
		driver.switchTo().frame(1);
		// by

		String textt = driver.findElement(By.id("sampleHeading")).getText();

		System.out.println(textt);

		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");

		String textt2 = driver.findElement(By.id("sampleHeading")).getText();

		System.out.println(textt2);
		driver.quit();

	}
}
