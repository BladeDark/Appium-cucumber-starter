package stepDefinitions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.*;

public class Steps {

	private static AppiumDriver<?> driver;
	private Landing_Page Landing_Page;
	private RegisterAccountType_Page RegisterAccountType_Page;
	private RegisterManUser_Page RegisterManUser_Page;

	@Before
	public void Setup() throws MalformedURLException {

		File appDirAndroid = new File("src\\test\\resources");
		File appAndroid = new File(appDirAndroid, "N2MU.apk");

		DesiredCapabilities androidCapabilities = new DesiredCapabilities();
		androidCapabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
		androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		androidCapabilities.setCapability("appPackage", "com.app.n2mu");
		androidCapabilities.setCapability("appActivity", "com.app.n2mu.MainActivity");
		androidCapabilities.setCapability(MobileCapabilityType.APP, appAndroid.getAbsolutePath());

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Landing_Page = new Landing_Page(driver);
	}

	@Given("^I click register$")
	public void i_click_register() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	

		Landing_Page.click_register_button();
		
		RegisterAccountType_Page = new RegisterAccountType_Page(driver);

	}

	@Given("^I click user image$")
	public void i_click_user_image() throws Throwable {
	
		RegisterAccountType_Page.click_user_image();
		RegisterAccountType_Page.click_select_button();
		Reporter.addStepLog("Test fill value in report step");
		
		
		RegisterManUser_Page = new RegisterManUser_Page(driver);
	}
	
	@Given("^I fill all required information$")
	public void i_fill_all_required_information() throws Throwable {
	
		RegisterManUser_Page.set_name("Narongsak Sakulchaikaew");
		RegisterManUser_Page.set_email("lek_test@gmail.com");
		RegisterManUser_Page.set_password("123456");
		RegisterManUser_Page.set_confirm_password("123456");
		RegisterManUser_Page.set_introduct_myself("ชื่อเล็ก แต่ไม่เล็ก");
	}


}
