package PageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;

public class IMDB__HomePage extends CommonMethods{
	
	@FindBy(xpath="//input[@id='suggestion-search']")
	WebElement searchBox;
	@FindBy(xpath="//div[@class='sc-4dc495c1-2 jaffDQ']")
	List<WebElement> rating;
	
	public IMDB__HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}

	public void searchSeries(String name) {
		
		CommonMethods.waitForVisibility(searchBox);
		searchBox.sendKeys(name);
		//searchBox.sendKeys(Keys.ENTER);
	}
	
	public void selectMovieSeries(String name) {
		By loc = By.xpath(String.format("//div[text()='%s']", name));
		CommonMethods.waitForVisibility(loc);
		WebElement ele = getDriver().findElement(loc);
	
		ele.click();
	}
	
	public void fetchRating() throws InterruptedException {
		 getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
         System.out.println(rating.size());
		System.out.println(rating.get(0).getAttribute("innerText"));
	}
	
}
