package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath ="//a[@data-testid='loginButton']")
	WebElement loginBtn;

	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[1]/label/div/div[2]/div/input")
	WebElement UserEmail;
	
	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[2]/label/div/div[2]/div/input")
	WebElement UserPass;
	
	@FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div")
	WebElement SubmitBtn;
	

	public HomePage Login(String Email,String Pass ) throws Exception {
		loginBtn.click();
		UserEmail.sendKeys(Email);
		UserPass.sendKeys(Pass);
		SubmitBtn.click();
		return new HomePage(driver);
	}
	public void SetUpChrome() {
		driver.get("https://twitter.com/");
	}
}
