package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.Directory_Page;
import org.junit.Assert;

public class Step_Directory_Page {
	

	private TestContext testContext;
	private Directory_Page Directory_Page;
	
	
	
	public Step_Directory_Page(TestContext context) {
		testContext = context;
		Directory_Page = testContext.getPageObjectManager().getDirectory_Page();

	}
	
	
	@Given("^I click name \"([^\"]*)\" on directory page$")
	public void i_search_name(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Directory_Page.click_name(arg1);
	}
	
	@Given("^I click star icon$")
	public void i_click_star_icon() throws Throwable {
		Directory_Page.click_star();
	}

	@Given("^I click favorites tab$")
	public void i_click_favorites_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Directory_Page.click_favorites_tab();
	}

	@Given("^I check name \"([^\"]*)\" on directory page$")
	public void i_check_name_on_directory_page(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  Directory_Page.check_name(arg1);
	}
	
	@Given("^I click back_on_directory_page$")
	public void i_click_back_on_directory_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Directory_Page.click_back();
	}
	
	@Given("^I click view all details$")
	public void i_click_view_all_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Directory_Page.click_view_all();
	}
	
	@Given("^I check thumbs up total$")
	public void i_check_thumbs_up_total() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(Directory_Page.check_total_score());
		
	
	}

}
