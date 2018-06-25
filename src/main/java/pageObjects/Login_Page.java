package pageObjects;




import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import managers.FileReaderManager;

public class Login_Page {
	
	private WebDriverWait wait;
	private AppiumDriver<?> driver;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/login_username_edittext")
	private WebElement username;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/login_password_edittext")
	private WebElement password;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/button")
	private WebElement btn_login;
	
	
	public Login_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver,FileReaderManager.getInstance().getConfigReader().getExplicitWait());
		this.driver = driver;
	}
	

	public void click_login(){
		
		btn_login.click();
		
	}
	
	public void set_username(String input){
		wait.until(ExpectedConditions.visibilityOfAllElements(username));
		username.sendKeys(input);
	}
	
	public void set_password(String input){
	
		password.sendKeys(input);
	}
	
	public boolean Is_login_page_active(){
		
		try {
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(username));
			return true;
		} catch (TimeoutException e) {
			return false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	


}
