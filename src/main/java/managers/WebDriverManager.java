package managers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.DriverType;
import enums.EnvironmentType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebDriverManager {
	private AppiumDriver<?> driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public AppiumDriver getDriver() throws MalformedURLException {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private AppiumDriver<?> createDriver() throws MalformedURLException {
		switch (environmentType) {
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private AppiumDriver<?> createRemoteDriver() throws MalformedURLException {
		
		String nodeUrl = "http://127.0.0.1:4723/wd/hub" ;
	
		
		switch (driverType) {
		/*case FIREFOX:
			
			driver = new RemoteWebDriver(new URL(nodeUrl), new FirefoxOptions());		
			driver.manage().window().setSize(new Dimension(1920, 1080));
			driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
					TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			
			break;
			
		case CHROME:
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			
			driver = new RemoteWebDriver(new URL(nodeUrl), options);
			driver.manage().window().setSize(new Dimension(1920, 1080));
			driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			
			break;
		case INTERNETEXPLORER:
			
			driver = new RemoteWebDriver(new URL(nodeUrl), DesiredCapabilities.internetExplorer());
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
					TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			break;*/
		case ANDROID:
			

			File appDirAndroid = new File("src\\test\\resources");
			File appAndroid = new File(appDirAndroid, "ekos_staging.apk");

			DesiredCapabilities androidCapabilities = new DesiredCapabilities();
			androidCapabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
			androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			androidCapabilities.setCapability("appPackage", "com.ekoapp.ekos.debug");
			androidCapabilities.setCapability("unicodeKeyboard", true);
			androidCapabilities.setCapability("resetKeyboard", true);
			//androidCapabilities.setCapability("connectHardwareKeyboard", false);
			androidCapabilities.setCapability("appActivity", "com.ekoapp.Home.HomeActivity2");
			androidCapabilities.setCapability(MobileCapabilityType.APP, appAndroid.getAbsolutePath());
			driver = new AndroidDriver<WebElement>(new URL(nodeUrl), androidCapabilities);
			driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
					TimeUnit.SECONDS);
			
		}
		
	
		return driver;
		
		
	}

	public void closeDriver() {
		driver.closeApp();
	}

	public void open(String url) {

		
	}

	public Alert swtichToAlert() {

		return driver.switchTo().alert();
	}

}