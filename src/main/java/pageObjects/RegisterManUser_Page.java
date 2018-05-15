package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterManUser_Page {

	private WebDriverWait wait;

	public RegisterManUser_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver, 30);
	}
	
	@AndroidFindBy(className = "android.widget.EditText")
	private List<WebElement> list_textbox;
	
	public void set_name(String value){
		wait.until(ExpectedConditions.visibilityOfAllElements(list_textbox));
		list_textbox.get(0).sendKeys(value);
	}
	
	public void set_email(String value){
		wait.until(ExpectedConditions.visibilityOfAllElements(list_textbox));
		list_textbox.get(1).sendKeys(value);
	}
	
	public void set_password(String value){
		wait.until(ExpectedConditions.visibilityOfAllElements(list_textbox));
		list_textbox.get(2).sendKeys(value);
	}
	
	public void set_confirm_password(String value){
		wait.until(ExpectedConditions.visibilityOfAllElements(list_textbox));
		list_textbox.get(3).sendKeys(value);
	}
	
	public void set_introduct_myself(String value){
		wait.until(ExpectedConditions.visibilityOfAllElements(list_textbox));
		list_textbox.get(4).sendKeys(value);
	}
}
