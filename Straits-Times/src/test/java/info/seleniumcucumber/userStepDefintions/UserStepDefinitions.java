package info.seleniumcucumber.userStepDefintions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import env.DriverUtil;
import info.seleniumcucumber.methods.BaseTest;


public class UserStepDefinitions implements BaseTest {
	
	protected WebDriver driver = DriverUtil.getDefaultDriver();

	
	@Given("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to(String url) throws Throwable {
		
		String testUrl = "https://www.straitstimes.com";
		WebDriver driver;
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.get(testUrl);
		
        String expectedTitle = "The Straits Times";
        String actualTitle = "";
        actualTitle = driver.getTitle();       
        
        Thread.sleep(2000);
		if(actualTitle.contains(expectedTitle)){			
		//Assert.assertEquals("The Straits Times", actualTitle);
		}
	}
	
	@When("^I click on login link$")
	public void i_clicks_the_login_link() throws Throwable {
		WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/div[2]/div/ul/li[1]/a")); 
		btnLogin.click();
		Assert.assertNotEquals(0, driver.findElements(By.id("j_username")).size());
	}
	
	@Then("^I should go to login page$")
	public void i_verify_login_page() throws Throwable {
		Thread.sleep(2000);
		Assert.assertNotEquals(0, driver.findElements(By.id("j_username")).size());
	}
	
	@Given("^I am on the login page of Straits Times$")
	public void i_navigate_to_login_page() throws Throwable {
		Thread.sleep(2000);
		Assert.assertNotEquals(0, driver.findElements(By.id("j_username")).size());
	}
	
	
	@When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enters_valid_credetials(String username, String password) throws Throwable {
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("j_password")).sendKeys(password);
	}
	
	@And("^I click on login button$")
	public void i_click_login_button(String username, String password) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
	}
	
	
	@Then("^I should get successfully logged-in$")
	public void should_logged_in() throws Throwable {		
		Thread.sleep(2000);
		Assert.assertNotEquals(0, driver.findElements(By.name("login-user-name")).size());
	}
	
	@Given("^I am on the home page of logged in user$")
	public void i_am_home_page_of_user() throws Throwable {
		Assert.assertNotEquals(0, driver.findElements(By.name("login-user-name")).size());
	}
	
	
	@When("^I verify main article have media file$")
	public void verify_main_article_media_file() throws Throwable {
		WebElement mainArticle = driver.findElement(By.xpath("//*[@id=\"block-system-main\"]/div/div/div/div/div[4]/div/div/div/div[5]/div/div/div/div/div[3]")); 
        String articleClass = mainArticle.getAttribute("class");
        System.out.println(articleClass);
        if (articleClass.contains("has_media")){
            System.out.println("Media File available in main article");
        } else {
            System.out.println("Unable to find media file in main article");
            Assert.assertTrue(false);
        }
	}
	
	@Then("^I get media file successfully$")
	public void i_get_media_file() throws Throwable {
		WebElement mainArticle = driver.findElement(By.xpath("//*[@id=\"block-system-main\"]/div/div/div/div/div[4]/div/div/div/div[5]/div/div/div/div/div[3]")); 
        String articleClass = mainArticle.getAttribute("class");
        System.out.println(articleClass);
        if (articleClass.contains("has_media")){
            System.out.println("Media File available in main article");
        } else {
            System.out.println("Unable to find media file in main article");
            Assert.assertTrue(false);
        }
	}
	
	
	@Given("^I am on main article$")
	public void i_am_on_main_article() throws Throwable {
		WebElement clickArticle = driver.findElement(By.xpath("//*[@id=\"block-system-main\"]/div/div/div/div/div[4]/div/div/div/div[5]/div/div/div/div/a"));
	       String articleTitle =  clickArticle.getAttribute("title");
	       System.out.println(articleTitle);
	       clickArticle.click();
	}
	
	
	@When("^I verify text content of main article$")
	public void i_verify_text_content_main_article() throws Throwable {			       
	       WebElement articleHeader = driver.findElement(By.xpath("//*[@id=\"block-system-main\"]/div/div[1]/div/header/h1"));
	       String articleHeader_text =  articleHeader.getText();
	       System.out.println(articleHeader_text);
	}
	
	@Then("^I should get same text as home page$")
	public void i_get_same_text_as_home() throws Throwable {
		 WebElement clickArticle = driver.findElement(By.xpath("//*[@id=\"block-system-main\"]/div/div/div/div/div[4]/div/div/div/div[5]/div/div/div/div/a"));
	       String articleTitle =  clickArticle.getAttribute("title");
	       System.out.println(articleTitle);
	       clickArticle.click();
	       
	       WebElement articleHeader = driver.findElement(By.xpath("//*[@id=\"block-system-main\"]/div/div[1]/div/header/h1"));
	       String articleHeader_text =  articleHeader.getText();
	       System.out.println(articleHeader_text);   
	       
	       	Thread.sleep(2000);
	       	if (articleTitle.contentEquals(articleHeader_text)){
	               System.out.println("Expected header is matching with main article");
	           } else {
	               System.out.println("Expected header is not matching with article.");
	               Assert.assertTrue(false);
	               
	           }
	}
	
		
}
