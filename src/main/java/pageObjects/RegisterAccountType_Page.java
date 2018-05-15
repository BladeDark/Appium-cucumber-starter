package pageObjects;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterAccountType_Page{

	private WebDriverWait wait;
	
	public RegisterAccountType_Page(AppiumDriver<?> driver){ 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver,30);
	}
	
	@AndroidFindBy(className = "android.widget.Image")
	private List<WebElement> list_image;
	
	@AndroidFindBy(className = "android.widget.Button")
	private List<WebElement> list_button;


	public void click_user_image(){
		wait.until(ExpectedConditions.visibilityOfAllElements(list_image));
		list_image.get(0).click();
	}
	
	public void click_select_button(){
		wait.until(ExpectedConditions.visibilityOfAllElements(list_button));
		list_button.get(1).click();
		
	}
}
