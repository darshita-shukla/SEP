package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import getpageobjects.ObjectProperties;
import pages.GetObjectsLogin;
import pages.GetObjectsSignUpFirstPage;

public class GetObjectsTest {
	WebDriver drive;
	WebDriverWait wait;
	GetObjectsLogin obj;
	GetObjectsSignUpFirstPage obj1;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\darshita.shukla\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		drive=new ChromeDriver();
		wait=new WebDriverWait(drive, Duration.ofSeconds(10));
		drive.manage().window().maximize();
		ObjectProperties.initializeObjectProperty();
		drive.get(ObjectProperties.getElementProperty("url"));
		obj = new GetObjectsLogin(drive);
		obj1 =new GetObjectsSignUpFirstPage(drive, wait);
	}
	@Test
	public void step01_test() throws Exception {
			obj.setup();
			obj.enterUsername();
			Thread.sleep(2000);
			obj.enterPassword();
			Thread.sleep(2000);
			obj.Login();
			
	}
	
	@Test
	public void step02_test() throws Exception {
		obj.applyNew();
		obj1.setup();
		obj1.setAccountEmailPassword();;
		obj1.setPersonalInformation();
		obj1.setPhoneNumber();
		obj1.setMilitaryId();
		obj1.startJourney();
	}
	@AfterClass
	public void quit() {
		drive.quit();
	}
}
