package org.power;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase {
	public static WebDriver driver;

	@AfterClass
	public static void afterclass() {
		driver.quit();
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@Before
	public void before() {
		System.out.println("before");
	}

	@BeforeClass
	public static void beforeclass() {
		System.out.println("beforeclass");
	}

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipseworkspace\\Junitt\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");

		String url = driver.getCurrentUrl();
		boolean b = url.contains("demo.automationtesting.in/Register");
		Assert.assertTrue("verify url", b);

		WebElement fstame = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input"));
		fstame.sendKeys("Raj");
		Assert.assertEquals("verift fstame", "Raj", fstame.getAttribute("value"));

		WebElement lstname = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input"));
		lstname.sendKeys("senthil");
		Assert.assertEquals("verift lstname", "senthil", lstname.getAttribute("value"));

		WebElement addrs = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"));
		addrs.sendKeys("chennai");
		Assert.assertEquals("verift addrs", "chennai", addrs.getAttribute("value"));

		WebElement emailadrs = driver.findElement(By.xpath("//*[@id=\"eid\"]/input"));
		emailadrs.sendKeys("snthlkumr@gmail.com");
		Assert.assertEquals("verift emailadrs", "snthlkumr@gmail.com", emailadrs.getAttribute("value"));

		WebElement phone = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input"));
		phone.sendKeys("9095797510");
		Assert.assertEquals("verift phone", "9095797510", phone.getAttribute("value"));

		WebElement gender = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input"));
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);

		WebElement crickt = driver.findElement(By.xpath("//*[@id=\"checkbox1\"]"));
		crickt.click();
		Assert.assertEquals(crickt.isSelected(), true);

		WebElement skills = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[8]/div/select"));
		Select s1 = new Select(skills);
		s1.selectByValue("Analytics");
		Assert.assertEquals("Analytics", s1.getFirstSelectedOption().getText());

		WebElement country = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[9]/div/select"));
		Select s4 = new Select(country);
		s4.selectByValue("Åland Islands");
		Assert.assertEquals("Åland Islands", s4.getFirstSelectedOption().getText());

		WebElement dby = driver.findElement(By.xpath("//*[@id=\"yearbox\"]"));
		Select s = new Select(dby);
		s.selectByValue("2015");
		Assert.assertEquals("2015", s.getFirstSelectedOption().getText());

		WebElement dbm = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[11]/div[2]/select"));
		Select s2 = new Select(dbm);
		s2.selectByValue("February");
		Assert.assertEquals("February", s2.getFirstSelectedOption().getText());

		WebElement dbd = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[11]/div[3]/select"));
		Select s3 = new Select(dbd);
		s3.selectByValue("5");
		Assert.assertEquals("5", s3.getFirstSelectedOption().getText());

		WebElement pswd = driver.findElement(By.xpath("//*[@id=\"firstpassword\"]"));
		pswd.sendKeys("12345");
		Assert.assertEquals("verift pswd", "12345", pswd.getAttribute("value"));

		WebElement cfmpswd = driver.findElement(By.xpath("//*[@id=\"secondpassword\"]"));
		cfmpswd.sendKeys("12345");
		Assert.assertEquals("verift pswd", "12345", cfmpswd.getAttribute("value"));

		WebElement btn = driver.findElement(By.xpath("//*[@id=\"Button1\"]"));
		btn.click();

	}
}
