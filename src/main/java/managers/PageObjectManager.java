package managers;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import pageObjects.*;

public class PageObjectManager {

	private AppiumDriver<?> driver;

	private Login_Page Login_Page;
	private Home_Page Home_Page;
	private Search_Page Search_Page;
	private Chat_Page Chat_Page;
	private Profile_Page Profile_Page;
	private Setting_Page Setting_Page;
	private Directory_Page Directory_Page;
	private Tasks_Page Tasks_Page;
	
	public PageObjectManager(AppiumDriver<?> driver) {

		this.driver = driver;

	}

	public Login_Page getLogin_Page() {
		return (Login_Page == null) ? Login_Page = new Login_Page(driver) : Login_Page;
	}

	public Home_Page getHome_Page() {
		return (Home_Page == null) ? Home_Page = new Home_Page(driver) : Home_Page;
	}

	public Chat_Page getChat_Page() {
		return (Chat_Page == null) ? Chat_Page = new Chat_Page(driver) : Chat_Page;
	}

	public Search_Page getSearch_Page() {
		return (Search_Page == null) ? Search_Page = new Search_Page(driver) : Search_Page;
	}

	public Profile_Page getProfile_Page() {
		return (Profile_Page == null) ? Profile_Page = new Profile_Page(driver) : Profile_Page;
	}

	public Setting_Page getSetting_Page() {
		return (Setting_Page == null) ? Setting_Page = new Setting_Page(driver) : Setting_Page;
	}
	
	public Directory_Page getDirectory_Page() {
		return (Directory_Page == null) ? Directory_Page = new Directory_Page(driver) : Directory_Page;
	}
	public Tasks_Page getTasks_Page() {
		return (Tasks_Page == null) ? Tasks_Page = new Tasks_Page(driver) : Tasks_Page;
	}

}