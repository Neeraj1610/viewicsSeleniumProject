package pajeObjects.homePage;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.myproject.basepageobject.BasePageObject;

import myntraRepository.MyntraRepository;

/**
 * Page object for checkout page operations.
 * 
 * @author nadhikari
 *
 */
public class CheckoutPagePajeObject {

	// Driver
	public WebDriver driver;

	// Declare page objects
	BasePageObject basePageObject;

	// Declare repository objects
	MyntraRepository myntraRepository;

	// Declare dynamic locator list
	ArrayList<String> dynamicLocatorList;

	public CheckoutPagePajeObject(WebDriver driver){
		basePageObject = new BasePageObject(driver);
		myntraRepository = new MyntraRepository(driver);
	}

	public String verifyItemCounterOnCheckoutPage() throws Exception{
		
		String noOfItemsInCart = basePageObject.getText(myntraRepository.myShoppingBagXpath);
		
		return noOfItemsInCart;
	}
	
	public void clickOnPlaceOrderButton(){
		
		basePageObject.click(myntraRepository.placeOrderButton);
		
		//Wait for login page
		basePageObject.waitForElementVisibility(myntraRepository.loginToMyntra);
	}
	
	public String verifyRightSizeAddedInCart() throws Exception{
		
		String size = basePageObject.getText(myntraRepository.itemSelectedSizeXpath);
		
		System.out.println("Counter Value : " +size);
		
		return size;
	}
}