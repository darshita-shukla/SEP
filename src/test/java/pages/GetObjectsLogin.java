package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetObjectsLogin {
	WebDriver drive;
	Properties obj = new Properties();

	public GetObjectsLogin(WebDriver drive) {
		// TODO Auto-generated constructor stub
		this.drive = drive;
	}

	public void setup() throws Exception {
		File src = new File("ObjectRepo.properties");
		FileInputStream objFile = new FileInputStream(src);
		obj.load(objFile);
	}
	
	public void enterUsername() {
		drive.findElement(By.id(obj.getProperty("username.id"))).sendKeys("Abcd1234@test.com");
	}
	public void enterPassword() {
		drive.findElement(By.id(obj.getProperty("password.id"))).sendKeys("Abcd1234");
	}
	public void Login() {
		drive.findElement(By.xpath(obj.getProperty("submit_btn.xpath"))).click();
	}
	public void applyNew() {
		drive.findElement(By.xpath(obj.getProperty("btn_applyNow.xpath"))).click();
	}
}
