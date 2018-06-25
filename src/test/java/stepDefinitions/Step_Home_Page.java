package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.Home_Page;


public class Step_Home_Page {
	
	private TestContext testContext;
	private Home_Page Home_Page;
	
	public Step_Home_Page(TestContext context) {
		testContext = context;
		Home_Page = testContext.getPageObjectManager().getHome_Page();

	}
	
	@Given("^I click next on first time open for admin$")
	public void i_click_skip_for_admin_user() throws Throwable {	
		for (int i=1;i<=5;i++) {
			Home_Page.click_next__first_open();
		}
		Home_Page.click_get_started();
	}
	
	@Given("^I click next on first time open for normal user")
	public void i_click_skip_for_normal_user() throws Throwable {	
		
		for (int i=1;i<=3;i++) {
			Home_Page.click_next__first_open();
		}
		Home_Page.click_get_started();
	}
	
	@Given("^I click search icon$")
	public void i_click_seasrch_icon() throws Throwable {	
		
		Home_Page.click_search_icon();
		
	}
	
	@Given("^I click recents on home page$")
	public void i_click_recetns() throws Throwable {	
		
		Home_Page.click_recents();
		
	}
	
	@Given("^I click directory on home page$")
	public void i_click_directory() throws Throwable {	
		
		Home_Page.click_directory();
		
	}
	
	@Given("^I click tasks on home page$")
	public void i_click_tasks() throws Throwable {	
		
		Home_Page.click_tasks();
		
	}
	
	@Given("^I click forms on home page$")
	public void i_click_forms() throws Throwable {	
		
		Home_Page.click_forms();
		
	}
	
	@Given("^I click profile on home page$")
	public void i_click_profile() throws Throwable {	
		
		Home_Page.click_profile();
		
	}

}
