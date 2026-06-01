package StepDefinition;

import java.io.File;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import PageClasses.IMDB__HomePage;
import Utilities.ContextKey;
import Utilities.DriverClass;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitio {
    
	IMDB__HomePage home = new IMDB__HomePage(DriverClass.getDriver());
	
	 TestContext testContext;
	 
	 public stepDefinitio(TestContext context) {
	        testContext = context;
	    }

@Given("user search for Series {string}")
public void user_search_for_series(String string) {
  
	home.searchSeries(string);
	home.selectMovieSeries(string);
	testContext.getScenarioContext().setContext(ContextKey.MOVIE_NAME, string);
}


@When("user fetch the Rating")
public void user_fetch_rating() throws InterruptedException {
	String rate = home.fetchRating();
	 testContext.getScenarioContext().setContext(ContextKey.MOVIE_RATING, rate);
}

@When("user fetch Genre")
public void user_fetch_genre() {
  List<String> genre= home.fetchGenre();
   testContext.getScenarioContext().setContext(ContextKey.MOVIE_Genre, genre);
}

@And("user fetch the Star cast")
public void fetch_user_starcast() {
	
	home.fetchStar();
	  testContext.getScenarioContext().setContext(ContextKey.MOVIE_StarCast, home.fetchStar());
}

@And("user fetch Year Released for movie {string}")
public void fetch_year_released(String movie) {
	home.fetchYear(movie);
	 testContext.getScenarioContext().setContext(ContextKey.MOVIE_ReleasedYear, home.fetchYear(movie));
}

@And("user fetch duration for movie/series {string}")
public void fetch_duration(String movie) {
	home.duration(movie);
	 testContext.getScenarioContext().setContext(ContextKey.MOVIE_DURATION, home.duration(movie));
}


}


