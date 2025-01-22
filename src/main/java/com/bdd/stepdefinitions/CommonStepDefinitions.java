package com.bdd.stepdefinitions;

import com.bdd.pages.SamplePage;
import com.bdd.utilities.ElementHelper;
import com.bdd.utilities.TestDataUtil;
import com.bdd.utilities.WebDriverManager;
import com.fasterxml.jackson.databind.JsonNode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.logging.Logger;

@Log4j2
public class CommonStepDefinitions {

    private Scenario scenario;
    private WebDriver driver;
    private JsonNode testData;
    private ElementHelper elementHelper;
    private SamplePage samplePage;

    @Before
    public void setUp(Scenario scenario) {
        driver = WebDriverManager.getDriver();
        samplePage = new SamplePage(driver);
        elementHelper = new ElementHelper(driver);
        this.scenario = scenario;
        testData = TestDataUtil.getJsonNode(scenario);
        log.info("Scenario: " + scenario.getName()); // Log scenario name
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @After
    public void quit() {
        WebDriverManager.quitDriver(scenario);
        TestDataUtil.removeDataNode();
        log.info("WebDriver quit.");
    }

    @And("Wait for {int} seconds")
    public void wait(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }
    
  
    @When("click on {string}")
    public void click_on(String cphomepage) {
        // Write code here that turns the phrase above into concrete actions
    	samplePage.clickOnLinkCP(cphomepage);
    	
        //throw new io.cucumber.java.PendingException();
    }
    
    @And("click on news and features page")
    public void click_on_news_and_features_page() {
    	
    	 samplePage.click_on_news_and_features_page();
       // System.out.println("Logging in with: " + username + " / " + password);
    }
    
    
    @Then("verify the number of videos feeds and its count")
    public void verify_the_number_of_videos_feeds_and_its_count() {
       // System.out.println("Logging in with: " + username + " / " + password);
    	samplePage.verify_the_number_of_videos_feeds_and_its_count();
    }

}
