package stepDefinitions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.*;

public class Steps{
	
	private static RemoteWebDriver driver;
	private Landing_Page Landing_Page ;
	private Preference_Page Preference_Page;
	
	@Before
	public void Setup() throws MalformedURLException {
		File f =new File("src\\test\\resources");
		File fs = new File(f,"ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Landing_Page = new Landing_Page(driver);
	}
	
	@Given("^I click preference$")
	public void i_click_view() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Landing_Page.btn_perference.click();
		
		Preference_Page = new Preference_Page(driver);
	}

	@Given("^I click preference dependencies$")
	public void i_click_preference_dependencies() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Preference_Page.btn_preference_dependencies.click();
		Reporter.addStepLog("Step Log message goes here");
	}


}
