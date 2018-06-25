package stepDefinitions;



import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.Profile_Page;

public class Step_Profile_Page {
	private TestContext testContext;
	private Profile_Page Profile_Page;

	public Step_Profile_Page(TestContext context) {
		testContext = context;
		Profile_Page = testContext.getPageObjectManager().getProfile_Page();

	}
	
	@Given("^I click setting on profile page$")
	public void i_click_profile() throws Throwable {	
		
		Profile_Page.click_setting();
		
	}
}
