package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement email=driver.findElement(By.id("userEmail"));
	// page factory
	@FindBy(id = "userEmail")
	WebElement userEmail;
	@FindBy(id = "userPassword")
	WebElement passwordEle;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement submit;
	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;

	public ProductCatalogue loginApplication(String userName, String password) {
		userEmail.sendKeys(userName);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
