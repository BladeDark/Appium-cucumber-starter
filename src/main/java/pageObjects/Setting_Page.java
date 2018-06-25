package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import managers.FileReaderManager;

public class Setting_Page {
	
	private WebDriverWait wait;
	private AppiumDriver<?> driver;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/logout_view")
	private WebElement btn_logout;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement confirm_logout;
	
	public Setting_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver,FileReaderManager.getInstance().getConfigReader().getExplicitWait());
		this.driver = driver;
	}
	
	public void click_logout(){
		wait.until(ExpectedConditions.visibilityOf(btn_logout));
		btn_logout.click();
	}
	
	public void click_confirm_logout(){
		wait.until(ExpectedConditions.visibilityOf(confirm_logout));
		confirm_logout.click();
	}
	
	

}
