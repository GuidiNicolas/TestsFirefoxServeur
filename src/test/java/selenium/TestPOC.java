package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nicochu on 14/12/2016.
 */
public class TestPOC {

    static WebDriver driver;
    private static ChromeDriverService service;
    static Wait<WebDriver> wait;

    @Before
    public void createDriver() {
        System.setProperty("webdriver.gecko.driver", "/usr/firefoxdriver/geckodriver");
        driver = new FirefoxDriver();
    }



    @Test
    public void testHibernateJSP() {
        
        wait = new WebDriverWait(driver, 30);
        driver.get("localhost:8088");

        try {
            driver.findElement(By.xpath("//h2"));
        }
        catch (NoSuchElementException e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

    @After
    public void killFirefox() {
        driver.quit();
    }
}