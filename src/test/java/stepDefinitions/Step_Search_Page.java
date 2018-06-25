package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.Search_Page;

public class Step_Search_Page {
	
	private TestContext testContext;
	private Search_Page Search_Page;
	
	public Step_Search_Page(TestContext context) {
		testContext = context;
		Search_Page = testContext.getPageObjectManager().getSearch_Page();

	}
	

	@Given("^I search name \"([^\"]*)\"$")
	public void i_search_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Search_Page.set_name_search(arg1);
		Search_Page.click_name_result();
	}

	
	@Given("^I click back on search page$")
	public void i_click_back_on_search_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Search_Page.click_back();
	}

}
