package Cucumber.Selenium;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;



/**
 * Unit test for simple App.
 */
public class Cucumbers 
{
    @Test
	public void test() {
    	/* TODO Auto-generated method stub
	
			String homepage="here.com";
			HttpURLConnection httpuc = null;
			int respCode = 200;
			int validcount=0;
			int incorrectlink=0;
			int emptyurl=0;
			int outsideurl=0;
			System.setProperty("webdriver.chrome.driver", "/Users/maheshramakotaiah/Documents/chromedriver");
			WebDriver driver= new ChromeDriver();
			driver.get("https://developer.here.com");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement we=driver.findElement(By.xpath(("//li[@class='menu-list-item menu-list-item--primary binded']//a[@class='menu-link menu-link--primary']//span[@class='link-content'][contains(text(),'Documentation')]")));
			Actions act=new Actions(driver);
			act.moveToElement(we).click().build().perform();
			String url = "";
			List<WebElement> links = driver.findElements(By.tagName("a"));
			
			System.out.println(driver.findElements(By.tagName("a")).size());
			
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
	                    System.out.println(url+" is a broken link");
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
	        }
	        
	        driver.quit();
	        System.out.println(validcount+" urls is having a valid link");
	        System.out.println(emptyurl+" urls is having no link");
	        System.out.println(outsideurl+" urls is having link outside here.com");
	        System.out.println(incorrectlink+" urls is having broken link");
			
		}
}  */

    }
}
