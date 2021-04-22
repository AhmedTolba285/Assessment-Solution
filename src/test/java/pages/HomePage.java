package pages;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	public static String NewNum = ""+(int)(Math.random()*Integer.MAX_VALUE);
	
	public HomePage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath ="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")
	WebElement TweetBox;
	
	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div/div/span/span")
	WebElement TweetBtn;
	
	@FindBy(xpath="//*[@id=\"layers\"]/div[2]/div/div/div/div/div[1]/span")
	WebElement ConfirmMsg;
	
	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div[1]/div[3]/div")
	WebElement ErrorCount;
	
	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div")
	WebElement MultipleTweetError;
	
	@FindBy(xpath ="//div[@aria-label='Add poll']") 
	WebElement Addpoll;
	
//	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div[1]/div[1]")
//	WebElement AskQuestion;
	
	@FindBy(xpath ="//input[@name='Choice1']") 
	WebElement ChoiceOne;
	
	@FindBy(xpath ="//input[@name='Choice2']") 
	WebElement ChoiceTwo;
	
	@FindBy(xpath ="//div[@aria-label='Add a GIF']") 
	WebElement AddGif;
	
	
	@FindBy(xpath ="//div[@aria-label='Add photos or video']") 
	WebElement AddInvalidFile;
	
	
	@FindBy(xpath ="//input[@placeholder='Search for GIFs']") 
	WebElement AgreeGif;
	
	@FindBy(xpath ="//img[@alt='GIF by happydog']") 
	WebElement SelectAgreeGif;
	
	
	public void TweetwithValidText() throws Exception {
		TweetBox.click();
		TweetBox.sendKeys("hello"+NewNum);
		TweetBtn.click();
	}
	
	public boolean ConfirmationDisplay() {
		boolean ER= ConfirmMsg.isDisplayed();
		return ER;
	}
	public void TweetwithInvalidText() throws Exception {
		TweetBox.click();
		TweetBox.sendKeys("testfjdnfjsdnfjkdsgjkfsbgkjfbgjkfdgbkjdfgbkdfjgbdfkjgbfdjkgbfjgbfdjgbfdjgfdkjgndfjgknfdjgfdngjkdfgnkjdfngjkdfgdfgdfgdfgfdgfdgdfggfdgfdgdfgdfgfdgjfdhgjfdhgfdjhgfdjghjfdkghjdfghudfighiudfhguidfhgufdghdfughdfguhdfugdfhgufdhgufdhgufdhgfgfgfgfgfgfvfvfvfvrvrvrvrvrvrvrvrvrvrvrvrvrvrvrvrvr");
	}
	public String CountErrorDisplay() {
		String ER= ErrorCount.getText();
		return ER;
	}
	public void TypeTweetTwice() throws Exception {
		TweetBox.click();
		TweetBox.sendKeys("Hello Test One");
		TweetBtn.click();
		TweetBox.sendKeys("Hello Test One");
		}
	public boolean TweetTwoErrorDisplay() {
		boolean ER= MultipleTweetError.isDisplayed();
		return ER;
	}
	public void AddPollQuestion() throws Exception {
		TweetBox.sendKeys("What is your favourite fruit");
		Addpoll.click();
		ChoiceOne.sendKeys("Apple");
		ChoiceTwo.sendKeys("Bananna");
		TweetBtn.click();
	}
	public void AddGif() throws Exception {
		AddGif.click();
		AgreeGif.sendKeys("Agree");
		SelectAgreeGif.click();
		TweetBtn.click();
	}
	public void TweetWithInvalidFileType() throws Exception {
	
		AddInvalidFile.sendKeys("/AssignmentTest/src/test/java/utilits/ExcelTest.xlsx");
	}
	
}
