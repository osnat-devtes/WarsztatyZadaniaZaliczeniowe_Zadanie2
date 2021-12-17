package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChoosingClothesPage extends BasePage{
    public ChoosingClothesPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "article.js-product-miniature")
    List<WebElement> availableClothesList;

    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/article[2]/div/div[1]/h2/a")
    public WebElement hummingbirdPrintedSweater;

   @FindBy(xpath = "//*[@id=\"group_1\"]")
   public WebElement sizeInput;

   @FindBy(id = "quantity_wanted")
   public WebElement quantityInput;

   @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
   public WebElement addToCartButton;

   @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
   public WebElement proceedToCheckout;

   @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
   public WebElement nextProceedToCheckout;

   @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[3]/span[2]")
   public WebElement sizeInfo;

    @FindBy(xpath = "//*[@id=\"cart-subtotal-products\"]/span[1]")
   public WebElement quantityInfo;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]/span")
    public WebElement regularPrice;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]")
    public WebElement priceWithTwentyPercentDiscount;

    public boolean areAnyClothesAvailable() {
        return availableClothesList.size()>0;
    }

    public void choosingHummingbirdPrintedSweater() {

        for (int i = 0; i < availableClothesList.size(); i++) {
            if (availableClothesList.get(i).findElement(By.cssSelector("h2.product-title"))
                    .getText().equals("Hummingbird Printed Sweater")) {
                WebElement hummingbirdPrintedSweater = availableClothesList.get(i).findElement(By.cssSelector("h2.product-title"));
                hummingbirdPrintedSweater.click();
            }
        }
    }
    public void choosingSize(String clothesSize) {
        tickDropdownText(sizeInput, clothesSize);
        }

        public void choosingQuantity(String clothesQuantity){
        enterText(quantityInput, clothesQuantity);
    }

    public String sizeInformation(){
        return sizeInfo.getText();
    }

    public String quantityInformation(){
        return quantityInfo.getText();
    }

    public void proceedToCheckout(){
        addToCartButton.click();
        proceedToCheckout.click();
    }

    public void nextProceedToCheckout(){
        nextProceedToCheckout.click();
    }

    public double regularPriceInfo(){
        String regularPriceString = regularPrice.getText().substring(1);
        double regularPriceDouble = Double.parseDouble(regularPriceString);
        return regularPriceDouble;
    }

    public double priceWithTwentyPercentDiscountInfo(){
        String priceWithTwentyPercentDiscountString = priceWithTwentyPercentDiscount.getText().substring(1);
        double priceWithTwentyPercentDiscountDouble = Double.parseDouble(priceWithTwentyPercentDiscountString);
        return priceWithTwentyPercentDiscountDouble;
    }
}
