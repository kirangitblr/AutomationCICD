package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;
	
	

	public Boolean verifyOrderDisplay (String productName) {
		
	
		Boolean match = productNames.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
		return match;

	}
	
}
