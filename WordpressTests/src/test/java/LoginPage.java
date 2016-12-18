import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class LoginPage {
    private static final String URL = "http://localhost:8888/wp-login.php";
    private WebDriver driver;

    @FindBy(id = "user_login")
    private WebElement login;

    @FindBy(id = "user_pass")
    private WebElement password;

    @FindBy(id = "wp-submit")
    private WebElement buttonLogIn;

    By errorMessage = By.xpath("//strong[contains(text(), \"ERROR\")]");

    public LoginPage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL)) {
            throw new IllegalStateException("This is not the page you are expected");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setLoginUser(String userLogin) {
        login.sendKeys(userLogin);
    }

    public void setPassword(String userPassword) {
        password.sendKeys(userPassword);
    }

    public void clickLogIn() {
        buttonLogIn.click();
    }

    public void logInToSite(String userLogin, String userPassword) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.setLoginUser(userLogin);
        this.setPassword(userPassword);
        this.clickLogIn();
    }

    public void errorLogIn(String userLogin, String userPassword) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.setLoginUser(userLogin);
        this.setPassword(userPassword);
        this.clickLogIn();
        driver.findElement(errorMessage);
        login.clear();
    }
}
