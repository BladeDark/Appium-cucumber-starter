package pageObjects;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preference_Page{

	public Preference_Page(RemoteWebDriver driver){ 
		PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	public RemoteWebElement btn_preference_dependencies;
	
	public void click_preference_dependencies(){
		btn_preference_dependencies.click();
		
	}
}
