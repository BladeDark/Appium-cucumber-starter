package stepDefinitions;



import org.junit.Assert;
import cucumber.TestContext;
import cucumber.api.java.en.Given;

import pageObjects.*;

public class Step_Login_Page {

	private TestContext testContext;
	private Login_Page Login_Page;
	
	public Step_Login_Page(TestContext context) {
		testContext = context;
		Login_Page = testContext.getPageObjectManager().getLogin_Page();

	}

	@Given("^I Login with admin user$")
	public void i_login_with_admin_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Login_Page.set_username("lek@ekoapp.com");
		Login_Page.set_password("password");
		Login_Page.click_login();
	}

	
	@Given("^I Login with first staff$")
	public void i_login_with_first_staff() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Login_Page.set_username("narongsak");
		Login_Page.set_password("password");
		Login_Page.click_login();
	}
	
	@Given("^I Login with second staff$")
	public void i_login_with_second_staff() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Login_Page.set_username("sakulchaikeaw");
		Login_Page.set_password("password");
		Login_Page.click_login();
	}
	
	@Given("I am on login page$")
	public void i_am_on_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		Assert.assertTrue(Login_Page.Is_login_page_active());
		
	}
}
