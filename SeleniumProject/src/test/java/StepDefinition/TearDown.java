package StepDefinition;



import java.io.File;
import java.nio.file.Files;
import java.util.Properties;

import Utilities.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

	public class TearDown extends CommonMethods {
		public static Properties prop;

		@BeforeAll(order=0)
		public static void driverOpen() throws Exception {
			 prop= CommonMethods.getProp();
			startDriver(prop.getProperty("browser"));
			
		}
		
		
		@BeforeAll(order=0)
		public static void openURL() throws Exception {
			LoadURL();
			
		}
		
		@AfterAll
		public static void quitDriver() {
			getDriver().quit();
		}
		
		@After
		public void afterScenario(Scenario sce) {
			if(getDriver()!= null) {
				if(sce.isFailed()) {
					 String screenshotPath =CommonMethods.captureScreenshot(getDriver(), sce.getName());
			            try {
			                sce.attach(Files.readAllBytes(new File(screenshotPath).toPath()), "image/png", "Screenshot");
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			        }
				}
			}
		
		
	}