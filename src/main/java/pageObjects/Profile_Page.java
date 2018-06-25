package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import managers.FileReaderManager;

public class Profile_Page {
	
	private WebDriverWait wait;
	private AppiumDriver<?> driver;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/action_setting")
	private WebElement btn_setting;
	
	public Profile_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver,FileReaderManager.getInstance().getConfigReader().getExplicitWait());
		this.driver = driver;
	}
	
	public void click_setting(){
		wait.until(ExpectedConditions.visibilityOf(btn_setting));
		btn_setting.click();
	}
}
