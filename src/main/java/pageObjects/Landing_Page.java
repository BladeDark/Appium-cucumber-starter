package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Landing_Page {
	
	private WebDriverWait wait;

	
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.Button"))); 
	
	public Landing_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver,30);
	}
	
	@AndroidFindBy(className = "android.widget.Button")
	private List<WebElement> list_button;
	
	
	

	public void click_register_button(){
		
		wait.until(ExpectedConditions.visibilityOfAllElements(list_button));
		list_button.get(0).click();
		
	}
	
	/*public void Select_dropdown(){
		Select dropdown = new Select(btn_preference);
		dropdown.s
	}*/

}
