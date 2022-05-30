package pages;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetObjectsSignUpFirstPage {
	WebDriver drive;
	WebDriverWait wait;
	Properties obj = new Properties();
	JavascriptExecutor js= (JavascriptExecutor)drive; 
	WebElement element;

	public GetObjectsSignUpFirstPage(WebDriver drive, WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		this.drive = drive;
		this.wait=wait;
	}

	public void setup() throws Exception {
		File src = new File("SignUpFirstPage.properties");
		FileInputStream objFile = new FileInputStream(src);
		obj.load(objFile);
	}

	public void setAccountEmailPassword() {
		drive.findElement(By.id(obj.getProperty("existingStudentNo.id"))).click();
		drive.findElement(By.id(obj.getProperty("enterUsername.id"))).sendKeys("testing12@test.com");
		drive.findElement(By.id(obj.getProperty("enterPassword.id"))).sendKeys("Testing2");
		drive.findElement(By.id(obj.getProperty("enterCountry.id"))).sendKeys("India");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> options = drive.findElements(By.id(obj.getProperty("enterCountry.id")));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India"))
				;
			option.click();
		}
		drive.findElement(By.id(obj.getProperty("submit_btn.id"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setPersonalInformation() {
		drive.findElement(By.id(obj.getProperty("chosenFirstName.id"))).sendKeys("Cname");
		drive.findElement(By.id(obj.getProperty("legalFirstName.id"))).sendKeys("Fname");
		drive.findElement(By.id(obj.getProperty("legalLastName.id"))).sendKeys("Lname");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drive.findElement(By.id(obj.getProperty("next1_btn.id"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setPhoneNumber() {
		drive.findElement(By.id(obj.getProperty("primaryPhone.id"))).sendKeys("1234567890");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drive.findElement(By.id(obj.getProperty("next2_btn.id"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setMilitaryId() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(obj.getProperty("noMilitary.id")))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element=drive.findElement(By.id(obj.getProperty("yesBachelorDegree.id")));
		js.executeScript("arguments[0].click();", element);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(obj.getProperty("yesBachelorDegree.id")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(obj.getProperty("noNursingDegree.id")))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drive.findElement(By.id(obj.getProperty("next3_btn.id"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startJourney() {
		drive.findElement(By.id(obj.getProperty("startJourney_btn.id"))).click();
	}
}
