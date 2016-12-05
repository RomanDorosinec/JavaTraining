import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WordpressTest {
    private static final String CHROME_PROPERTY_NAME = "webdriver.chrome.driver";
    private static final String WINDOWS_DEFAULT_CHROME_PATH = "C:\\Users\\Dorosinec\\IdeaProjects\\WordpressTests\\chromedriver.exe";

    WebDriver driver;
    ReadTxtFile readTxtFile = new ReadTxtFile();
    ArrayList<User> users;

    @BeforeClass
    public void start() {
        users = readTxtFile.allParametersUser();
        System.setProperty(CHROME_PROPERTY_NAME, WINDOWS_DEFAULT_CHROME_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:8888/wp-login.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider(name = "Users login and password")
    public Object[][] loginPassword() throws Exception {
        Object[][] eeee = new Object[users.size()][];
        for (int i = 0; i < eeee.length; i++) {
            eeee[i] = new Object[]{
                    users.get(i).getUser_login(),
                    users.get(i).getUser_pass()
            };
        }
        return eeee;
    }

    @Test(dataProvider = "Users login and password")
    public void loginInWordpress(String login, String pass) throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        element.sendKeys(login);
        driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys(pass);
        driver.findElement(By.cssSelector("#wp-submit")).click();
        driver.findElement(By.id("wpadminbar"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a"))).perform();
        actions.moveToElement(driver.findElement(By.linkText("Log Out"))).click().build().perform();
        Thread.sleep(500);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}