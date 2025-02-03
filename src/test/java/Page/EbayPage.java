package Page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class EbayPage {
    private static final Log log = LogFactory.getLog(EbayPage.class);
    public static WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void openBrowserAndLaunchUrl() {
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        WebElement logo = driver.findElement(By.xpath("//*[@id='gh-logo']"));
        Assert.assertTrue("Page not displayed", logo.isDisplayed());
    }

    public void searchForElement() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        searchBox.sendKeys("Book", Keys.ENTER);
    }

    public void selectElement() {
        driver.findElement(By.xpath("//*[@id='srp-river-results']/ul/li[1]/div/div[2]/a/div")).click();
    }

    public void addToCart(){
        Set<String> windowHandles = driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();
        for(String s: windowHandles){
            if(s!=currentWindow){
                driver.switchTo().window(s);
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='atcBtn_btn_1']")));
        driver.findElement(By.xpath("//*[@id='atcBtn_btn_1']")).click();
    }

    public void verifyCart() {
        String actualCartNum = driver.findElement(By.xpath("//*[@class='badge']")).getText();
        log.info("Your cart has been updated by: " + actualCartNum);
        Assert.assertTrue("Cart Value is not updated Properly!",actualCartNum.equalsIgnoreCase("1"));
        driver.quit();
    }


}

