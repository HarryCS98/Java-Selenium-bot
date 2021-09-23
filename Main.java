import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		//Create an object of this class
		Main main = new Main();

		//Run the run method
		main.run();
	
	
	}
	
	//Our main method which tells our bot where to navigate/click at
	private void run() throws AWTException, InterruptedException {
			
		//System property is optional but if you want to use it you must use it before you create and object of the WebDriver class
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harry\\Desktop\\WebDriver\\chromedriver.exe");
		
		//Create an object of the WebDriver class we will call it driver and use the Chrome Driver (this means it will use the chrome browser)
		WebDriver driver = new ChromeDriver();
		
		//Launch the Webbrowser and navigate to our first page
		launchBrowser(driver,"http://ushop.com/");
			
		//Click on the login button
		sendClick("//*[@id=\"navbarColor01\"]/ul[2]/li[2]/a", driver);
			
		//Input our email address to login field
		sendKeys("//*[@id=\"email\"]", "###EmailAddress###", driver);
		
		//Input our password into login field
		sendKeys("//*[@id=\"password\"]", "###Password###", driver);
		
		//Click the Login button on the login form
		sendClick("//*[@id=\"app\"]/main/div/div/div/div/div[2]/form/div[4]/div/button", driver);

		//Click on the Air Cooling drop down in the navigation bar
		sendClick("//*[@id=\"navbarDropdownMenuLink-555\"]", driver);
		
		//Click on Aircoolers in the Air Cooling drop down menu
		sendClick("//*[@id=\"navbarNav\"]/ul/li[2]/div/a", driver);
		
		//Click on our product from the selection on the AirCoolers page
		sendClick("//*[@id=\"app\"]/main/div/div/div/div[1]/div[1]/div/h4/a", driver);
		
		//Add the product to your basket
		sendClick("//*[@id=\"app\"]/main/div/div[1]/div[2]/div/div[4]/form/ul/li[3]/button", driver);
		
		//Navigate to your basket
		sendClick("//*[@id=\"navbarColor01\"]/ul[2]/li[1]/a", driver);
		
		//Go to the checkout
		sendClick("//*[@id=\"app\"]/main/div/div/div/table/tbody/tr[5]/td[5]/a", driver);
		
		//Has to wait 1 second due to problems with javascript events/elements not being loaded in time.
		Thread.sleep(1000);
		
		//Input first Name
		sendKeys("//*[@id=\"firstName\"]", "Harry", driver);
		
		//Input Last Name
		sendKeys("//*[@id=\"lastName\"]", "Surname", driver);
		
		//Input Email Address
		sendKeys("//*[@id=\"email\"]", "email@gmail.com", driver);
		
		//Input First Line of Address
		sendKeys("//*[@id=\"address\"]", "10 Spencer Road", driver);

		//Input zip code/postcode
		sendKeys("//*[@id=\"zip\"]", "NN1 3LR", driver);
		
		//Input credit card name
		sendKeys("//*[@id=\"cc-name\"]", "Mr H lastname", driver);
		
		//Input credit card number
		sendKeys("//*[@id=\"cc-number\"]", "389120739213", driver);
		
		//Input expiry code of credit card
		sendKeys("//*[@id=\"cc-expiration\"]", "04/28", driver);
	
		//Input cv2 number of credit card
		sendKeys("//*[@id=\"cc-cvv\"]", "902", driver);
		
		//Click the pay now button
		sendClick("//*[@id=\"app\"]/main/div/div/div/div/form/a", driver);
		
	}
	
	
	
	//Find an elements using its xpath and then send a click
	private void sendClick(String xpath, WebDriver driver) {
		
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	

	
	//Send keys normally to an element found using its xpath 
	private void sendKeys(String xpath,String input,WebDriver driver) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);
	}
	

	//Launch the browser and navigate it to our url
	private void launchBrowser(WebDriver driver, String url) {
		
		//navigate to the page
		driver.get(url); 
		
		//Maximise the browser window
		driver.manage().window().maximize();
	
		
	}
	
	
}
