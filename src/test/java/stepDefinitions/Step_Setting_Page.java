package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.Setting_Page;

public class Step_Setting_Page {
	private TestContext testContext;
	private Setting_Page Setting_Page;

	public Step_Setting_Page(TestContext context) {
		testContext = context;
		Setting_Page = testContext.getPageObjectManager().getSetting_Page();
	}
	
	@Given("^I click logout on setting page$")
	public void i_click_profile() throws Throwable {	
		
		Setting_Page.click_logout();
		Setting_Page.click_confirm_logout();
		
	}
	
	
}
