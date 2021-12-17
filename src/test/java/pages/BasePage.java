package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterText(WebElement element, String enteredText){
        element.sendKeys(Keys.CONTROL + "A");
        element.sendKeys(Keys.DELETE);
        element.clear();
        element.sendKeys(enteredText);
    }

    public void tickDropdownText(WebElement element, String enteredDropdownText){
        element.click();
        Select drpElement = new Select(element);
        drpElement.selectByVisibleText(enteredDropdownText);
    }
}
