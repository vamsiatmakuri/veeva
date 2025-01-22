package com.bdd.pages;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bdd.utilities.ElementHelper;

/**
 * The purpose of this class is to manage different actions of Sample Page.
 * For example, Redirect to Specific menu, Verify redirection, etc.
 */
@Log4j2
public class SamplePage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    /**
     * Constructor to assign driver.
     *
     * @param driver
     */
    public SamplePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void clickOnLinkCP(String cphomepage) {
    	
    	
    	 try {
             WebElement popup = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[1]/h2")); // Change locator
             if (popup.isDisplayed()) {
                 System.out.println("Popup is displayed!");
                 elementHelper.click("/html/body/div[4]/div[1]/div"); // Close button
             }else {
            	// elementHelper.click(String.format("//a[contains(text(), \"Men's\")][1]",cphomepage));
            	 
            	 String mainWindow = driver.getWindowHandle();
                 Set<String> allWindows = driver.getWindowHandles();

                 for (String window : allWindows) {
                     if (!window.equals(mainWindow)) {
                         driver.switchTo().window(window); // Switch to popup window
                         System.out.println("Popup window title: " + driver.getTitle());
                         driver.close(); // Close popup window
                         driver.switchTo().window(mainWindow); // Switch back to main window
                     }
                 }
             } 
    	 }catch (NoSuchElementException e) {
             System.out.println("No modal popup found.");
         }
    
    }
    
    public void click_on_news_and_features_page() {
    	//elementHelper.click(String.format("//a[contains(text(), \"Men's\")][1]",));
    	 Actions actions = new Actions(driver);
    	 try {
    		 Thread.sleep(5000);
    		 WebElement threedots = driver.findElement(By.xpath("//*[@id='nba-nav']/div[2]/nav/div/nav[2]/ul/li")); // Change locator
    		   if (threedots.isDisplayed()) {
    			   
    		 WebDriverWait wait = new WebDriverWait(driver, 3000);
    		 //  WebElement subMenu = driver.findElement(By.xpath("//a[text()='Submenu']")); // Change XPath
    	     //   subMenu.click();
    	        actions.moveToElement(threedots).build().perform();
    		 elementHelper.click("//*[@id='nba-nav']/div[2]/nav/div/nav[2]/ul/li");
    		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nba-nav']/div[2]/nav/div/nav[2]/ul"))).click();
    		        System.out.println("threedots is displayed!");
                // elementHelper.click("//*[@id=\"nba-nav\"]/div[2]/nav/div/nav[2]/ul"); 
             }
    	 }catch (NoSuchElementException | InterruptedException e) {
             System.out.println("Not able to click on threedots.");
         }
    	
    
    	 try {
			Thread.sleep(5000);
			 WebElement news = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/nav/div/nav[2]/ul/li/nav/ul/li[2]/a"));
	    	 actions.moveToElement(news).build().perform();
			 elementHelper.click("/html/body/div[1]/div[2]/div[1]/div[2]/nav/div/nav[2]/ul/li/nav/ul/li[2]/a");
		    	System.out.println("Clicked on News and Features " );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
  public void verify_the_number_of_videos_feeds_and_its_count() {
    
	  
	  try {
			 Thread.sleep(5000);
	  List<WebElement> videoFeeds = driver.findElements(By.xpath("//a[contains(@href, 'videos')][not(@href=preceding::a/@href)]"));
	  System.out.println("Number of video feeds on the page: " + videoFeeds.size());
	  
	  
	//*[@id="__next"]//time//span
	  
	  for (int i = 1; i <= videoFeeds.size(); i++) {
		    String dynamicXPath1 = "(//a[contains(@href, 'videos')][not(@href=preceding::a/@href)])[" + i + "]";
		    String dynamicXPath2 =  dynamicXPath1 + "/following::div[3]/div/time/span";
		    WebElement span = driver.findElement(By.xpath(dynamicXPath2));
		    System.out.println("Span " + i + ": " + span.getText());
		}
	  
	
	  } catch (NoSuchElementException | InterruptedException e) {
	             System.out.println("Not able to click on threedots.");
	  }
    }
    
}
