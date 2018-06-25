package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import managers.FileReaderManager;

public class Search_Page {

	private WebDriverWait wait;
	private AppiumDriver<?> driver;

	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/search_src_text")
	private WebElement search_box;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/search_message_group_name_text_view")
	private WebElement name_search_result;
	
	@AndroidFindBy(className = "android.widget.ImageButton")
	private WebElement btn_back;
	

	public Search_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getExplicitWait());
		this.driver = driver;
	}

	public void set_name_search(String value) {
		search_box.sendKeys(value);
	}
	
	public void click_name_result() {
		name_search_result.click();
	}
	
	public void click_back(){
		wait.until(ExpectedConditions.visibilityOf(btn_back));
		btn_back.click();
	}
	
}
