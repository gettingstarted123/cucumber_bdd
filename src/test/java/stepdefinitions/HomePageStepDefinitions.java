package stepdefinitions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinitions {
	
	private WebDriver driver;
	private WebElement homePageImageLink;
	
	@Before
	public void initialiseDriver() {
		driver = new ChromeDriver();		
	}
	
	@After
	public void destroyDriver() {
		driver.close();
	}
	
	
	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.HOME_PAGE);
	}
	
	/** AC1 **/
	@When("I look at the page")
	public void i_look_at_the_page() {
		try {
			homePageImageLink = driver.findElement(By.xpath("//*[@id=\'logo_homepage_link\']"));
		}catch(Exception e) {
			System.err.println("logo was not found on home page");
		}		
	}

	@Then("I expect to see the duckduckgo logo on the page")
	public void i_expect_to_see_the_duckduckgo_logo_on_the_page() {
	    assertTrue("Is DuckDuckGo logo visible ?", null != homePageImageLink);
	}
	
	/** AC2 **/
	@When("I type {string} into the search box")
	public void i_type_into_the_search_box(String query) {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(query);
	}

	@Then("I expect to see exactly {int} suggestions in the typeahead dropdown")
	public void i_expect_to_see_exactly_suggestions_in_the_typeahead_dropdown(Integer expectedCount) throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> searchSuggestionList = driver.findElements(By.xpath("//div[contains(@class, 'acp')]"));
		
		assertTrue("Does search suggestions return " + expectedCount + " suggestions ? ", 
				null != searchSuggestionList && expectedCount == searchSuggestionList.size());
	}
	
	/** AC3 **/
	@When("I type {string} somewhere in the search box")
	public void getSearchResults(String query) {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(query);
	}
	
	
	@Then("I expect the first result to be {string}")
	public void i_expect_the_first_result_to_be(String expected) throws InterruptedException {
		Thread.sleep(3000);
		String result = "";
		List<WebElement> searchList = new ArrayList<WebElement>();
	    
	    /** returns us a List with count of search suggestion divs **/
	    //searchList = driver.findElements(By.xpath("//div[contains(@class, 'acp')]"));
	    
		/** from search suggestion list narrow down to first element **/
		searchList = driver.findElements(By.xpath("//div[@class='acp-wrap js-acp-wrap']/*[1]"));
	  
	    
	    if(null != searchList && searchList.size() > 0) {
			result = searchList.get(0).getText();
		}
	    assertTrue("Is first element from sugestion: " + result + 
	    		" the same as what we expect: which is " + expected, 
	    		null != result && result.trim().length() > 0 
	    		&& result.trim().equalsIgnoreCase(expected));
	}
	
	/** AC-4 **/
	@When("I click on the hamburger menu in the top right")
	public void i_click_on_the_hamburger_menu_in_the_top_right() {
		WebElement homePageImageLink = driver.findElement(By.xpath("//a[@class='header__button--menu  js-side-menu-open']"));
		homePageImageLink.click();
	}

	@Then("I expect to see a themes link")
	public void i_expect_to_see_a_themes_link() {
		
		WebElement linkElement = driver.findElement(By.xpath("//ul[@class='nav-menu--theme']//li[contains(@class, 'nav-menu__item clear')]//a"));
		//linkElement.click();
		assertNotNull("Do I see a Themes link ? ",null != linkElement);
	}
	
	/** AC-5 **/
	@When("I click on the themes link then click on the dark mode theme button")
	public void i_click_on_the_themes_link_then_click_on_the_dark_mode_theme_button() {
		/** Expand Hamburger **/
		WebElement hamburgerLink = driver.findElement(By.xpath("//a[@class='header__button--menu  js-side-menu-open']"));
		hamburgerLink.click();
		
		/** in Hamburger dropdown choose 'Themes' **/
		WebElement linkElement = driver.findElement(By.xpath("//ul[@class='nav-menu--theme']//li[contains(@class, 'nav-menu__item clear')]//a"));
		linkElement.click();     

	    /** In available Themes find the option for 'Dark' and choose to change background **/
		//WebElement buttonElement = driver.findElement(By.xpath("//div[@data-theme-id='d']//input[@name='setting_kae']"));
		WebElement buttonElement = driver.findElement(By.xpath("//div[@data-theme-id='d']"));
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(buttonElement));
		buttonElement.click();
		
	}

	@Then("My page background should change colour")
	public void my_page_background_should_change_colour() {
		WebElement bodyElement = driver.findElement(By.xpath("//body[@id='pg-settings']"));
		
		/** we will get the color of background in 'rgba'
		 *  where as the webpage is using hexadecimal notation 
		 *  website for black in hexadecimal = #1c1c1c
		 *  rgba notation for the same is    =  rgba(28, 28, 28, 1)
		 *  
		 *  so we will compare value with a constant in rgba
		 */
		String derivedColor = bodyElement.getCssValue("background-color");
		//System.out.println("no confusion >>>>>> " + bodyElement.getCssValue("background-color"));
		assertTrue("Is Background colour correctly set as expected ?",
				derivedColor.trim().equalsIgnoreCase(Constants.BACKGROUND_BODY_COLOUR));
	}
	
	/** AC-6 **/
	@When("I go to the homepage and type {string} then click the maginifying glass")
	public void i_go_to_the_homepage_and_type(String string) {
		/** enter search text in search text box **/
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(string);
		
		/** click on magnifying glass **/
		WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
		searchButton.click();
	}
	
	@Then("I should get {int}")
	public void theOutputShouldBeResult(int string) {
		List<WebElement> searchResultsList = new ArrayList<WebElement>();
		searchResultsList = driver.findElements(By.xpath("//div[@class='results js-results']//div[@class='nrn-react-div']"));
	    
	    assertTrue("Does search result count match ?" ,string 
	    		== searchResultsList.size());
	}
}


