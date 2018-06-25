package stepDefinitions;

import org.junit.Assert;
import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pageObjects.Chat_Page;

public class Step_Chat_Page {

	
	private TestContext testContext;
	private Chat_Page Chat_Page;
	
	public Step_Chat_Page(TestContext context) {
		testContext = context;
		Chat_Page = testContext.getPageObjectManager().getChat_Page();

	}
	
	@Given("^I send message as \"([^\"]*)\"$")
	public void i_search_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Chat_Page.set_message(arg1);
	}
	
	@Given("^I click message box$")
	public void i_click_seasrch_icon() throws Throwable {	
		Chat_Page.click_message();
		
		
		
	}
	
	@Given("^I click back on chat page$")
	public void i_click_back_on_chat_page() throws Throwable {	
		
		Chat_Page.click_back();
		
	}
	
	@And("^I check message \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_check_message_and(String arg1, String arg2) throws Throwable {
			Assert.assertTrue(Chat_Page.check_message(arg1, arg2));
	}
	
	
	
}
