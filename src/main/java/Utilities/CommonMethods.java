package Utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends DriverClass{
	
	public static ClassLoader basedir;
	public static Properties prop;

	public static void LoadURL() {
		WebDriver driver =	getDriver();
		driver.get("https://www.imdb.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	    driver.manage().window().maximize();
	}
	
	
	public static void loadClassLoader() {
		basedir =CommonMethods.class.getClassLoader();
	}
	
	public static Properties getProp() throws IOException {
		prop =new Properties();
		prop.load(LoadFile("/config.properties"));
		return prop;
	}
	
	public static InputStream LoadFile(String file) {
		return CommonMethods.class.getResourceAsStream(file);
	}
	
	 public static String captureScreenshot(WebDriver driver, String scenarioName) {
		 
		 driver = getDriver();
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String screenshotName = scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";
	        String screenshotPath = "target/screenshots/" + screenshotName;

	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File dest = new File(screenshotPath);
	            Files.createDirectories(dest.getParentFile().toPath());
	            Files.copy(src.toPath(), dest.toPath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return screenshotPath;
	    }
	 
	 private static final int WAIT_TIME = 10; // seconds

	    private static WebDriverWait getWait(WebDriver webDriver) {
	        return new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME));
	    }

	    // ✅ Wait for visibility
	    public static WebElement waitForVisibility(WebElement element) {
	        return getWait(getDriver()).until(ExpectedConditions.visibilityOf(element));
	    }

	    public static WebElement waitForVisibility(By locator) {
	        return getWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    // ✅ Wait for element to be clickable
	    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
	        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
	        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    // ✅ Wait for presence of element
	    public static WebElement waitForPresence(WebDriver driver, By locator) {
	        return getWait(getDriver()).until(ExpectedConditions.presenceOfElementLocated(locator));
	    }

	 

	 
}
