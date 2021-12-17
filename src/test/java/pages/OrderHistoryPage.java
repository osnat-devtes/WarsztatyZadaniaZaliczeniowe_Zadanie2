package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends BasePage{
    public OrderHistoryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]")
    public WebElement viewMyCustomerAccountButton;

    @FindBy(xpath = "//*[@id=\"history-link\"]")
    public WebElement orderHistoryAndDetailsButton;

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/th")
    public WebElement orderReferenceInCustomerHistory;

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")
    public WebElement totalSumInCustomerHistory;

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[4]/span")
    public WebElement awaitingCheckPayment;

    public void goToTheCustomerInfoPage(){
        viewMyCustomerAccountButton.click();
        orderHistoryAndDetailsButton.click();
    }

    public String orderReferenceInCustomerHistoryInfo(){
        return orderReferenceInCustomerHistory.getText();
    }

    public String totalSumInCustomerHistoryInfo(){
        return totalSumInCustomerHistory.getText();
    }

    public String awaitingCheckPaymentInfo(){
        return awaitingCheckPayment.getText();
    }
}
