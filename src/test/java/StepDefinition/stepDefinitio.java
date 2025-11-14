package StepDefinition;

import PageClasses.IMDB__HomePage;
import Utilities.DriverClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class stepDefinitio {
    
	IMDB__HomePage home = new IMDB__HomePage(DriverClass.getDriver());

@Given("user search for Series {string}")
public void user_search_for_series(String string) {
  
	home.searchSeries(string);
	home.selectMovieSeries(string);
}


@When("user fetch the Rating")
public void user_fetch_rating() throws InterruptedException {
	home.fetchRating();
}

@When("user fetch Genre")
public void user_fetch_genre() {
   home.fetchGenre();
}

@And("user fetch the Star cast")
public void fetch_user_starcast() {
	
	home.fetchStar();
}

@And("user fetch Year Released for movie {string}")
public void fetch_year_released(String movie) {
	home.fetchYear(movie);
}

@And("user fetch duration for movie {string}")
public void fetch_duration(String movie) {
	home.duration(movie);
}


}
