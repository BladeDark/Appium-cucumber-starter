package stepDefinitions;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;

public class Hooks {
	
	TestContext testContext;
	public static Scenario scenario;
	private AppiumDriver<?> driver;
	
	

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void beforeScenario(Scenario scenario) throws MalformedURLException {
		this.scenario = scenario;

	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) throws WebDriverException, MalformedURLException {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot)testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");		
		}
	}

	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}
	
	

}
