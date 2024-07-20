package Task22;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDownSyn {

	public static void main(String[] args) throws Exception {
		//setting Chrome driver Setup
		WebDriverManager.chromedriver().setup();

		//Launching firefox driver instance
		WebDriver driver=new ChromeDriver();

		//Navigate to the URL
		driver.get("https://phptravels.com/demo/");

		//Maximize the browser window
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(3));
		// First Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='first_name']")));
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Abi");

		// Last Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='last_name']")));
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Vignesh");

		//Whatsapp number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='whatsapp']")));
		driver.findElement(By.xpath("//input[@name='whatsapp']")).sendKeys("8098888906");


		// Business Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Business Name']")));
		driver.findElement(By.xpath("//input[@placeholder='Business Name']")). sendKeys("Vetrivel Business");

		//Email ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		driver.findElement(By.name("email")).sendKeys("abi91it@gmail.com");

		//Sum verification
		//First number
		WebElement number1=driver.findElement(By.id("numb1"));
		String num1=number1.getText();
		
		//Convert string into Integer
		int n1= Integer.parseInt(num1);

		//Second Number
		WebElement number2=driver.findElement(By.id("numb2"));
		String num2=number2.getText();
		
		//Convert string into Integer
		int n2= Integer.parseInt(num2);

		//calculate sum of two numbers
		int sum = n1+n2;
		
		// convert this sum into string because sendkeys method will take String as a parameter
		String sum1 = Integer.toString(sum);

		//Giving the value to the result box
		driver.findElement(By.id("number")).sendKeys(sum1);

		// Click on submit
		WebElement element = driver.findElement(By.id("demo"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

		//Verify that the form is submitted successfully		   
		WebElement ty=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='text-center cw mt-3']")));
		String formtext=ty.getText();

		if((formtext.equals("Thank you!"))) {
			System.out.println("User registered");
		}
		else {
			System.out.println("User not registered");
		}
		Thread.sleep(1000);

		// Take screenshot
		TakesScreenshot ts=(TakesScreenshot) driver;

		File src=ts.getScreenshotAs(OutputType.FILE);
		File tgt=new File(".\\screenshots1\\phptravels.png");
		FileUtils.copyFile(src, tgt);

		//Close the browser instance
		driver.quit();

	}

}


/*OUTPUT
User registered */
