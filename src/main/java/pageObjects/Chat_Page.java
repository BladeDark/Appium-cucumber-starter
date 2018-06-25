package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import managers.FileReaderManager;

public class Chat_Page {

	private WebDriverWait wait;
	private AppiumDriver<?> driver;
	
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement send_message;
	
	@AndroidFindBy(xpath = "(//android.widget.ImageButton)[1]")
	private WebElement btn_send;
	
	@AndroidFindBy(xpath = "(//android.widget.ImageButton)[2]")
	private WebElement btn_back;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/message")
	private List<WebElement> list_message;
	
	
	
	public Chat_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver,FileReaderManager.getInstance().getConfigReader().getExplicitWait());
		this.driver = driver;
	}
	
	
	public void set_message(String value) {
	
		send_message.sendKeys(value);
		btn_send.click();
	}
	
	public void click_message() throws InterruptedException{
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf(send_message));
		send_message.click();
	
	}
	
	public void click_back(){
		btn_back.click();
	}
	
	public boolean check_message(String last_message,String second_from_last) throws InterruptedException{
		Thread.sleep(6000);
	
		int last = list_message.size() - 2;
		int second_last = list_message.size() - 3;
	
		
		if (list_message.get(last).getText().contains(second_from_last) && list_message.get(second_last).getText().contains(last_message)) {
			return true;
		}else{
			return false;
		}
		

	}
	
	
	
	
}
