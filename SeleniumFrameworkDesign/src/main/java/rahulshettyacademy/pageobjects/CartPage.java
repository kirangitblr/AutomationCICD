package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	By cartProductsAppear=By.cssSelector(".cartSection h3");

	public Boolean verifyProductDisplay(String productName) {
		waitForElementToAppear(cartProductsAppear);
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
		return match;

	}
	public CheckoutPage goToCheckOut()
	{
		
		checkOut.click();
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		return checkoutPage;
	}
}
