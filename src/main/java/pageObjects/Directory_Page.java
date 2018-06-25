package pageObjects;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import managers.FileReaderManager;

public class Directory_Page {
	
	private WebDriverWait wait;
	private AppiumDriver<?> driver;
	
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/menu_star")
	private WebElement star;
	
	@AndroidFindBy(className = "android.widget.ImageButton")
	private WebElement btn_back;
	
	@AndroidFindBy(className = "android.support.v7.app.ActionBar$Tab")
	private List<WebElement> list_tab;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/view_all_textview")
	private WebElement view_all;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/score")
	private List<WebElement> skill_list_score;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/sentScore")
	private WebElement sentScore;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/otherScore")
	private WebElement otherScore;
	
	@AndroidFindBy(id = "com.ekoapp.ekos.debug:id/totalScore")
	private WebElement totalScore;
	
	public Directory_Page(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver,FileReaderManager.getInstance().getConfigReader().getExplicitWait());
		this.driver = driver;
	}
	
	public void click_name(String value) {
		WebElement element = driver.findElementByXPath("//android.widget.TextView[@text='" + value + "']");
		element.click();
	}
	
	public void click_star() {
		wait.until(ExpectedConditions.visibilityOf(star));
		star.click();
	}
	
	public void click_back() {
		btn_back.click();
	}
	
	public boolean check_name(String value) {
		WebElement element = driver.findElementByXPath("//android.widget.TextView[@text='" + value + "']");
		
		try {
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException e) {
			return false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void click_favorites_tab(){
		wait.until(ExpectedConditions.visibilityOf(list_tab.get(0)));
		list_tab.get(0).click();
	}
	
	public void click_view_all() {
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"View all details\"));"));
		
		wait.until(ExpectedConditions.visibilityOf(view_all));
		view_all.click();
	}
	
	
	
	public boolean check_total_score() {
		
		int sum = 0;
		
		for (int i=0;i<skill_list_score.size();i++) {
			sum = sum + Integer.parseInt(skill_list_score.get(i).getText());
		}
		
		sum = sum + Integer.parseInt(sentScore.getText());
		sum = sum + Integer.parseInt(otherScore.getText());
		
		
		if (sum == Integer.parseInt(totalScore.getText())) {
			return true;
			
		}else{
			return false;
		}
		
	}
	
	

}
