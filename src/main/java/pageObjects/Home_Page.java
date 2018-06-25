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

public class Home_Page{
	
	private WebDriverWait wait;
	private AppiumDriver<?> driver;

	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/view_onboarding_forward")
	private WebElement click_next_first_open;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/view_onboarding_item_subtitle")
	private WebElement item_subtitle;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/action_home_search")
	private WebElement btn_search;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/view_onboarding_dialog_button")
	private WebElement get_started;
	
	
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/relativeLayout9")
	private List<WebElement> btn_list_menu;
	

	
	public Home_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver,FileReaderManager.getInstance().getConfigReader().getExplicitWait());
		this.driver = driver;
	}
	


	public void click_next__first_open(){
		wait.until(ExpectedConditions.visibilityOf(click_next_first_open));
		click_next_first_open.click();
	}
	
	public void click_get_started(){
		wait.until(ExpectedConditions.visibilityOf(get_started));
		get_started.click();
	}
	
	public void click_search_icon(){
		wait.until(ExpectedConditions.visibilityOf(btn_search));
		btn_search.click();
	}
	
	public void click_recents(){
		wait.until(ExpectedConditions.visibilityOf(btn_list_menu.get(0)));
		btn_list_menu.get(0).click();
	}
	
	
	public void click_directory(){
		wait.until(ExpectedConditions.visibilityOf(btn_list_menu.get(1)));
		btn_list_menu.get(1).click();
	}
	
	public void click_tasks(){
		wait.until(ExpectedConditions.visibilityOf(btn_list_menu.get(2)));
		btn_list_menu.get(2).click();
	}
	
	public void click_forms(){
		wait.until(ExpectedConditions.visibilityOf(btn_list_menu.get(3)));
		btn_list_menu.get(3).click();
	}
	
	public void click_profile(){
		wait.until(ExpectedConditions.visibilityOf(btn_list_menu.get(4)));
		btn_list_menu.get(4).click();
	}
	
	
}
