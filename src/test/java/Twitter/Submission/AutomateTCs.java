package Twitter.Submission;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AutomateTCs {

	public static WebDriver driver;
	String image1= "First.jpg";
	String image2= "Second.png";
	String image3= "Third.png";
	String image4= "Fourth.png";
	String image5= "Fifth.jpg";
	String image1path=System.getProperty("user.dir")+"\\src\\test\\resources\\"+image1;
	String image2path=System.getProperty("user.dir")+"\\src\\test\\resources\\"+image2;
	String image3path=System.getProperty("user.dir")+"\\src\\test\\resources\\"+image3;
	String image4path=System.getProperty("user.dir")+"\\src\\test\\resources\\"+image4;
	String image5path=System.getProperty("user.dir")+"\\src\\test\\resources\\"+image5;

	@BeforeTest

	public static void opentwitter() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\work space\\Submission\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://twitter.com");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

	}

	public void Login() {

		WebElement Login = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[2]/div[1]"));
		Login.click();

		WebElement username = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/label[1]/div[1]/div[2]/div[1]/input[1]"));
		username.sendKeys("testnn3");

		WebElement password = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/label[1]/div[1]/div[2]/div[1]/input[1]"));
		password.sendKeys("test123456");

		WebElement Login2 = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/div[1]"));
		Login2.click();
	}

//Validate that Twitter user can send a tweet of 280 characters
	@Test(priority = 1)
	public void tweet280char() {

		Login();
		WebElement Whatishappening = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
		Whatishappening.sendKeys(
				"Test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test testt");
		WebElement Tweetbutton = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/span[1]/span[1]"));
		Tweetbutton.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement text = driver.findElement(By.xpath(
				"//span[contains(text(),'Test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test testt')]"));
		Assert.assertEquals(text.getText(),
				"Test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test testt",
				"Error as text Should Accept 280 character ");
	}

	// Validate that user can't tweet same tweet twice
	@Test(priority = 2)
	public void SameTweet() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement Whatishappening = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
		Whatishappening.sendKeys(
				"Test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test testt");
		WebElement Tweetbutton = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/span[1]/span[1]"));
		Tweetbutton.click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		WebElement ValidationMessage = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
		Assert.assertEquals(ValidationMessage.getText(),
				"Something went wrong, but don’t fret — let’s give it another shot.",
				"Error as User can't Send Same tweet twice ");

	}

	// Validate that Twitter user can't send a tweet of 281 characters
	@Test(priority = 3)
	public void tweet281char() {
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		WebElement Whatishappening = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
		Whatishappening.sendKeys(
				"Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hell ");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		WebElement CountButton = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]"));
		Assert.assertEquals(CountButton.getText(), "-1", "Error as text can't Accept 281 character");
	}
@Test (priority=4)

public void upload4images() throws AWTException, InterruptedException {
	
	driver.navigate().refresh();
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	WebElement MediaButton=driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]"));
    MediaButton.click();
   
     Robot robot = new Robot();
    //Download image1
	// CTRL + C copy image path
    StringSelection selection = new StringSelection(image1path);
	System.out.println(image1path);
	java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContents(selection, null);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.delay(2000);
	// Click on CTRL + V 
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.delay(3000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(4000);
	
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.delay(3000);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	Thread.sleep(4000);
	
	//Upload image2
		// CTRL + C copy image path
	    StringSelection selection2 = new StringSelection(image2path);
		System.out.println(image2path);
		clipboard.setContents(selection2, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		// Click on CTRL + V 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		//Upload image3
		// CTRL + C copy image path
	    StringSelection selection3 = new StringSelection(image3path);
		System.out.println(image3path);
		clipboard.setContents(selection3, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		// Click on CTRL + V 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		//Upload image4
		// CTRL + C copy image path
	    StringSelection selection4 = new StringSelection(image4path);
		System.out.println(image4path);
		clipboard.setContents(selection4, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		// Click on CTRL + V 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		WebElement Whatishappening = driver.findElement(By.xpath(
				"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
		Whatishappening.sendKeys("Validate 4 Photos");
	
	WebElement Tweetbutton = driver.findElement(By.xpath(
			"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/span[1]/span[1]"));
	Tweetbutton.click();
    
	Thread.sleep(3000);
	
    WebElement Submittedtweet=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/span[1]"));
    Assert.assertEquals(Submittedtweet.getText(),"Validate 4 Photos","Erorr as user should be able to add up to 4 photos ");
}

//Validate that user can Create poll successfully
@Test (priority=5)
public void CreatePoll() throws InterruptedException {
	
	driver.navigate().refresh();
	
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	WebElement PollButton=driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]"));
	PollButton.click();
	
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	WebElement Question=driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
	Question.sendKeys("First OR Second ?");
	
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	WebElement Choice1=driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]/div[2]/div[1]/input[1]"));
	Choice1.sendKeys("First Choice");
	
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
	WebElement Choice2=driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/div[1]/div[2]/div[1]/input[1]"));
	Choice2.sendKeys("Second Choice");
	
	WebElement Tweetbutton = driver.findElement(By.xpath(
			"//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/span[1]/span[1]"));
	Tweetbutton.click();

	Thread.sleep(3000);
	
	WebElement SubmittedQuestion = driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/span[1]"));
	Assert.assertEquals(SubmittedQuestion.getText(),"First OR Second ?");
}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
