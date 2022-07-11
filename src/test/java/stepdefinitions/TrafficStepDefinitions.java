package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrafficStepDefinitions {
	
	private WebDriver driver;
	
	@Before
	public void initialiseDriver() {
		driver = new ChromeDriver();		
	}
	
	@After
	public void destroyDriver() {
		driver.close();
	}
	
	@Given("I am on the traffic page")
	public void i_am_on_the_traffic_page() {
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://start.duckduckgo.com/traffic");
	}

	@When("I click on the {int} Traffic section")
	public void i_click_on_the_Traffic_section(Integer int1) {
		//div[@class='traffic__year__left']//h2
		
		//List<WebElement> searchList = new ArrayList<WebElement>();
		//searchList = driver.findElements(By.xpath("//div[@class='traffic__year__left']//h2"));
		
		/** this will retrieve the 14 master elements on page **/
		//searchList = driver.findElements(By.xpath("//div[@class='blk  blk--content']//div[@class='blk__text']"));
		
		
		
		
		
		
		/** try and identify the element for 2018 and click to expand it **/
		WebElement webElement2018 = driver.findElement(
				By.xpath("//div[@class='blk  blk--content']//div[@class='blk__text']//div[@class='traffic__year__left']//h2[text()='2018 Traffic']/ancestor::div[3]"));
		webElement2018.click();
		
		
		
		List<WebElement> monthlyDataList = new ArrayList<WebElement>();
		monthlyDataList = driver.findElements(By.xpath("//div[@class='blk  blk--content']//div[@class='blk__text']//div[@class='traffic__year__left']//h2[text()='2018 Traffic']/ancestor::div[3]//div[@class='traffic__month collapsed']"));
	
		//System.out.println("count of monthly data is " + monthlyDataList.size());
		
		List <String> extractMonthsList = new ArrayList<String>(); 
		int totalQueryCount = 0;
		if(null != monthlyDataList && monthlyDataList.size() > 0) {
			for(int j=0;j<monthlyDataList.size();j++) {
				WebElement webElementMonthData = monthlyDataList.get(j);
				//System.out.println(webElementMonthData.getText());
				
				/** now can we get child elements present within this element **/
				WebElement monthElement =  webElementMonthData.findElement(
						By.xpath(".//div[@class='wrap']//h3"));
				
				//System.out.println("month is >>> " + monthElement.getText());
				extractMonthsList.add(monthElement.getText());
				
				/** now can we get child elements present within this element **/
				WebElement monthQueryCountElement =  webElementMonthData.findElement(
						By.xpath(".//div[@class='wrap']//div[@class='traffic__month__right']//h2"));
				
				String monthlyCount = monthQueryCountElement.getText();
				monthlyCount = monthlyCount.replaceAll(",", "");
				//System.out.println("monthly query count is >>> " + monthQueryCountElement.getText());
				totalQueryCount = totalQueryCount + Integer.parseInt(monthlyCount);
			}
		}
	}

	@Then("I should see all the months listed in the order from Dec to Jan")
	public void i_should_see_all_the_months_listed_in_the_order_from_Dec_to_Jan() {
		
		/** try and identify the element for 2018 and click to expand it **/
		WebElement webElementTotalCount = driver.findElement(
				By.xpath("//div[@class='blk  blk--content']//div[@class='blk__text']//div[@class='traffic__year__left']//h2[text()='2018 Traffic']/ancestor::div[2]//div[@class='traffic__year__right']//h2"));
		//System.out.println("Total count for 2018 = " + webElementTotalCount.getText() );
		
		String yearlyCount = webElementTotalCount.getText();
		yearlyCount = yearlyCount.replaceAll(",", "");
		
		long annualQueryCount = Long.parseLong(yearlyCount);		
		//int annualQueryCount = 9239676317;
		
		List<WebElement> monthlyDataList = new ArrayList<WebElement>();
		monthlyDataList = driver.findElements(By.xpath("//div[@class='blk  blk--content']//div[@class='blk__text']//div[@class='traffic__year__left']//h2[text()='2018 Traffic']/ancestor::div[3]//div[@class='traffic__month collapsed']"));
	
		//System.out.println("count of monthly data is " + monthlyDataList.size());
		
		List <String> extractMonthsList = new ArrayList<String>(); 
		long totalQueryCount = 0L;
		
		if(null != monthlyDataList && monthlyDataList.size() > 0) {
			for(int j=0;j<monthlyDataList.size();j++) {
				WebElement webElementMonthData = monthlyDataList.get(j);
				//System.out.println(webElementMonthData.getText());
				
				/** now can we get child elements present within this element **/
				WebElement monthElement =  webElementMonthData.findElement(
						By.xpath(".//div[@class='wrap']//h3"));
				
				//System.out.println("month is >>> " + monthElement.getText());
				extractMonthsList.add(monthElement.getText());
				
				/** now can we get child elements present within this element **/
				WebElement monthQueryCountElement =  webElementMonthData.findElement(
						By.xpath(".//div[@class='wrap']//div[@class='traffic__month__right']//h2"));
				
				String monthlyCount = monthQueryCountElement.getText();
				monthlyCount = monthlyCount.replaceAll(",", "");
				
				//System.out.println("monthly query count is >>> " + monthQueryCountElement.getText());
				//totalQueryCount = totalQueryCount + Integer.parseInt(monthlyCount);
				totalQueryCount = totalQueryCount + Long.parseLong(monthlyCount);
				
			}
		}
		//System.out.println("totalQueryCount = " + totalQueryCount);
		//System.out.println("annualQueryCount = " + annualQueryCount);
		
		
		
		/** hacky way of creating a list of Months **/
		List <String> monthsToCompare = new ArrayList<String>();
		monthsToCompare.add("December");monthsToCompare.add("November");
		monthsToCompare.add("October");
		monthsToCompare.add("September");monthsToCompare.add("August");
		monthsToCompare.add("July");monthsToCompare.add("June");
		monthsToCompare.add("May");monthsToCompare.add("April");
		monthsToCompare.add("March");monthsToCompare.add("February");
		monthsToCompare.add("January");
		
		boolean isMonthlyOrder = true;
		
		for(int i=0;i<monthsToCompare.size();i++) {
			//System.out.println("extractMonthsList = " + extractMonthsList.get(i));
			//System.out.println("monthsToCompare = " + monthsToCompare.get(i));
			if(!extractMonthsList.get(i).startsWith(monthsToCompare.get(i))) {
				isMonthlyOrder = false;
			}
		}
		
		assertTrue("Months should be in descending order", isMonthlyOrder);
		assertEquals("total query counts should match", annualQueryCount, totalQueryCount);
	}
}
