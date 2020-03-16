package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



@RunWith(Cucumber.class)
public class stepDefinations {
	
	WebDriver driver= new ChromeDriver();
    @Given("^Verify the Links on Documentation page$")
    public void verify_the_links_on_documentation_page() throws Exception {
    	
    	//go to here.com
    	System.setProperty("webdriver.chrome.driver", "/Users/maheshramakotaiah/Documents/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://developer.here.com");  
		
    }

    @When("^I am on the Documentation page$")
    public void i_am_on_the_documentation_page() throws Exception {
    	//navigate to documentation page using mouse hover action class
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	WebElement we=driver.findElement(By.xpath(("//li[@class='menu-list-item menu-list-item--primary binded']//a[@class='menu-link menu-link--primary']//span[@class='link-content'][contains(text(),'Documentation')]")));
		Actions act=new Actions(driver);
		act.moveToElement(we).click().build().perform();
       
    }

    @Then("^Validate all links on that page are loading$")
    public void validate_all_links_on_that_page_are_loading() {
    	String homepage="here.com";
		HttpURLConnection httpuc = null;
		int respCode = 200;
		int validcount=0;
		int incorrectlink=0;
		int emptyurl=0;
		int outsideurl=0;
		String url = "";
		//limiting the driver scope to main segment
		List<WebElement> tags= driver.findElements(By.xpath("//div[@id='maps_section']//div[contains(@class,'cards__container cards__carousel-off cards__full-image-background-off container')]"));
		
		Iterator<WebElement> ib = tags.iterator();
		
		while(ib.hasNext()) {
		
		//within child driver finding the documentation links
		List<WebElement> links = ((WebElement) tags).findElements(By.xpath("xpath=//a[contains(@href,'/documentation')]"));
	
		System.out.println(((WebElement) tags).findElements(By.xpath("xpath=//a[contains(@href,'/documentation')]")).size());
		
		Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
        
            if(url == null || url.isEmpty()){
            	System.out.println(url + " is either not configured for anchor tag or it is empty");
            	emptyurl++;
                continue;
            }
            if(!url.contains(homepage)){
                System.out.println("URL belongs to another domain, skipping it."+ url);
                outsideurl++;
                continue;
            }
            
            try {
                httpuc = (HttpURLConnection)(new URL(url).openConnection());
                
                httpuc.setRequestMethod("HEAD");
                
                httpuc.connect();
                
                respCode = httpuc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link"); // checking for broken links
                    incorrectlink++;
                }
                else{
                    
                    validcount=validcount+1;
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            ib.next();
        }
        
		}
        driver.quit();
        System.out.println(validcount+" urls is having a valid link");
        System.out.println(emptyurl+" urls is having no link");
        System.out.println(outsideurl+" urls is having link outside here.com");
        System.out.println(incorrectlink+" urls is having broken link");
		
	}
  
        


    @And("^For each link validate if Angular has initialized$")
    public void for_each_link_validate_if_angular_has_initialized()  {
        
    }

}