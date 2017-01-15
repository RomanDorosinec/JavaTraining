import by.dorosinec.traning.finalProject.addUsers.Users;
import by.dorosinec.traning.finalProject.ParserTxtFile;
import by.dorosinec.traning.finalProject.dataBases.WorkerWithMySQL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WordpressTest {
    private static final String URL = "http://localhost:8888/wp-login.php";
    private static final String CHROME_PROPERTY_NAME = "webdriver.chrome.driver";
    private static final String WINDOWS_DEFAULT_CHROME_PATH = "chromedriver.exe";

    WebDriver driver;
    ParserTxtFile parser = new ParserTxtFile();
    ArrayList<Users> users;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void start() {
        users = parser.allParametersUser();
        new WorkerWithMySQL().addLineOfTables(users);
        System.setProperty(CHROME_PROPERTY_NAME, WINDOWS_DEFAULT_CHROME_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test(priority = 1)
    public void openWebSite() {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider(name = "Users login and password")
    public Object[][] loginPassword() throws Exception {
        Object[][] userAndLoginCorrect = new Object[users.size()][];
        for (int i = 0; i < userAndLoginCorrect.length; i++) {
            userAndLoginCorrect[i] = new Object[]{
                    users.get(i).getUser_login(),
                    users.get(i).getUser_pass()
            };
        }
        return userAndLoginCorrect;
    }

    @Test(dataProvider = "Users login and password", priority = 2)
    public void loginInWordpress(String login, String pass) throws Exception {
        driver.get(URL);
        loginPage = new LoginPage(driver);
        loginPage.logInToSite(login, pass);
        homePage = new HomePage(driver);
        homePage.logOut();
    }

    @DataProvider(name = "Correct users login, but uncorrected password")
    public Object[][] correctLoginUncorrectedPassword() throws Exception {
        Object[][] userCorrectLoginUncorrected = new Object[users.size()][];
        for (int i = 0; i < userCorrectLoginUncorrected.length; i++) {
            userCorrectLoginUncorrected[i] = new Object[]{
                    users.get(i).getUser_login(),
                    String.valueOf(new Random().nextInt(490))
            };
        }
        return userCorrectLoginUncorrected;
    }

    @Test(dataProvider = "Correct users login, but uncorrected password", priority = 3)
    public void correctLoginUncorrectedPassword(String login, String pass) throws Exception {
        driver.get(URL);
        loginPage = new LoginPage(driver);
        loginPage.errorLogIn(login, pass);
    }

    @DataProvider(name = "Uncorrected users login, but correct password")
    public Object[][] uncorrectedLoginUncorrectedPassword() throws Exception {
        Object[][] userCorrectLoginUncorrected = new Object[users.size()][];
        for (int i = 0; i < userCorrectLoginUncorrected.length; i++) {
            userCorrectLoginUncorrected[i] = new Object[]{
                    String.valueOf(new Random().nextInt(490)),
                    users.get(i).getUser_pass()
            };
        }
        return userCorrectLoginUncorrected;
    }

    @Test(dataProvider = "Uncorrected users login, but correct password", priority = 4)
    public void uncorrectedLoginCorrectedPassword(String login, String pass) throws Exception {
        driver.get(URL);
        loginPage = new LoginPage(driver);
        loginPage.errorLogIn(login, pass);
    }
}