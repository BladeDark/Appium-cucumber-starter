package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.Tasks_Page;

public class Step_Tasks_Page {
	
	private TestContext testContext;
	private Tasks_Page Tasks_Page;

	public Step_Tasks_Page(TestContext context) {
		testContext = context;
		Tasks_Page = testContext.getPageObjectManager().getTasks_Page();
	}

	
	
	@When("^I click created task icon$")
	public void i_click_created_task_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Tasks_Page.click_create_task();
	}

	@When("^I input task title \"([^\"]*)\"$")
	public void i_input_task_title(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Tasks_Page.set_task_title(arg1);
	}

	@When("^I click create button$")
	public void i_click_create_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Tasks_Page.click_create_button();
	}

	@When("^I check task name \"([^\"]*)\"$")
	public void i_check_task_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Tasks_Page.check_card_title_name(arg1);
	}
}
