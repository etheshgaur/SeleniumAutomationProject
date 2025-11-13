package Utilities;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverClass {

	private static ThreadLocal<WebDriver> locDriver = new ThreadLocal<>();
	public static Properties prop;
	
	public static void startDriver(String bName) throws Exception {
		setDriver(bName);
	}
	
	 private static void setDriver(String bName) throws Exception {
		 prop= CommonMethods.getProp();
		 CommonMethods.loadClassLoader();
	        switch (bName.toLowerCase()) {
	            case "chrome":
	                ChromeOptions chromeOptions = new ChromeOptions();
	                chromeOptions.setAcceptInsecureCerts(true);
	                locDriver.set(new ChromeDriver(chromeOptions));
	                break;

	            case "edge":
	                EdgeOptions edgeOptions = new EdgeOptions();
	                edgeOptions.setAcceptInsecureCerts(true);
	                locDriver.set(new EdgeDriver(edgeOptions));
	                break;

	            default:
	                throw new Exception("Driver " + bName + " not defined");
	        }
	    }
	 
	 public static WebDriver getDriver() {
	        return locDriver.get();
	    }

	    public static void stopDriver() {
	        if (getDriver() != null) {
	            getDriver().quit();
	            locDriver.remove();
	        }
	    }
	    
		/*
		 * public static void main(String[] args) throws Exception {
		 * startDriver("chrome"); getDriver().get("https://google.com");
		 * System.out.println("Title: " + getDriver().getTitle()); stopDriver(); }
		 */
	
}
