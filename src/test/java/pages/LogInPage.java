package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{
    LogInPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    public WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"submit-login\"]")
    public WebElement sign_inButton;

    public void logIn(String email, String password){
        signInButton.click();
        enterText(loginInput,email);
        enterText(passwordInput,password);
        sign_inButton.click();
    }
}
