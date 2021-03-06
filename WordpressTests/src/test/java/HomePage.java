import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * POM class to use the home page after logging in
 */
public class HomePage {
    WebDriver driver;
    Actions actions;

    @FindBy(xpath = "//*[@id=\"wp-admin-bar-my-account\"]/a")
    private WebElement toolbar;

    @FindBy(linkText = "Log Out")
    private WebElement buttonLogOut;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This POM method will be exposed in test case to log out site
     */
    public void logOut() {
        actions = new Actions(driver);
        actions.moveToElement(toolbar).perform();
        actions.moveToElement(buttonLogOut);
        actions.click().build().perform();
    }
}
