package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import managers.FileReaderManager;

public class Tasks_Page {

	private WebDriverWait wait;
	private AppiumDriver<?> driver;

	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/button_create_task")
	private WebElement create_task;

	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement task_title;

	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/task_create_dialog_create_button")
	private WebElement btn_create;

	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/task_card_title_textview")
	private List<WebElement> list_card_title;

	public Tasks_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getExplicitWait());
		this.driver = driver;
	}

	public void click_create_task() {
		wait.until(ExpectedConditions.visibilityOf(create_task));
		create_task.click();
	}

	public void set_task_title(String value) {
		wait.until(ExpectedConditions.visibilityOf(task_title));
		task_title.sendKeys(value);
	}

	public void click_create_button() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_create));
		btn_create.click();
	}

	public boolean check_card_title_name(String input) {
		boolean is_found = false;
		
		for (int i = 0; i < list_card_title.size(); i++) {

			if (list_card_title.get(i).getText().contains(input)) {
				is_found = true;
				
			}

		}
		
		return is_found;
	}
}
