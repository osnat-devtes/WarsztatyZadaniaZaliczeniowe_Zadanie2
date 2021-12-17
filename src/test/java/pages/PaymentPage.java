package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"id-address-delivery-address-18209\"]/header/label/div")
    public WebElement addressInfo;

    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
    public WebElement confirmAddressButton;

    @FindBy(id = "delivery_option_1")
    public WebElement pickUpInStoreRadioButton;

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    public WebElement pickUpInStoreContinueButton;

    @FindBy(id = "payment-option-1")
    public WebElement payByCheckRadioButton;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    public WebElement approveTermsOfServiceCheckboxButton;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    public WebElement submitOrderButton;

    @FindBy(xpath = "//*[@id=\"order-items\"]/div/table/tbody/tr[3]/td[2]")
    public WebElement totalOrderSum;

    @FindBy(xpath = "//*[@id=\"order-details\"]/ul/li[1]")
    public WebElement orderReferenceString;

    public String getAddressInformation(){
       return addressInfo.getText();
    }
    public void confirmAddress(){
        confirmAddressButton.click();
    }
    public void clickPickUpInStore(){
        if(pickUpInStoreRadioButton.isSelected()==false){
            pickUpInStoreRadioButton.click();
        }
        pickUpInStoreContinueButton.click();
    }

    public void clickPayByCheck(){
        if(payByCheckRadioButton.isSelected()==false){
            payByCheckRadioButton.click();
        }
        if(approveTermsOfServiceCheckboxButton.isSelected()==false){
            approveTermsOfServiceCheckboxButton.click();
        }
        submitOrderButton.click();
    }
    public String totalOrderSumInfo(){
        return totalOrderSum.getText();
    }

    public String orderReferenceInfo(){
        return orderReferenceString.getText();
    }
}
