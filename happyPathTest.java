package HappyPath;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class happyPathTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test

    public void logTest() {

        driver.get("https://outlook.live.com/owa/");



        WebElement singLogButton = driver.findElement(By.xpath("/html/body/header/div/aside/div/nav/ul/li[2]/a"));
        singLogButton.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("i0116")))).sendKeys("demoTestSelenium@outlook.com");

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("idSIButton9")))).click();

        driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("Rafael06-09-1985");

        new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable((By.id("idSIButton9"))));

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@type='submit']"))));

        new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable((By.id("idSIButton9")))).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Oznacz wszystkie jako przeczytane")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://outlook.live.com/mail/0/inbox" );
        System.out.println(URL);


        driver.quit();

    }

}
