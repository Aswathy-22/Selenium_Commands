package org.obs.seleniumcommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Base {
    public WebDriver driver;
    public void initializeTest(String browser) {
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        }
        else throw new RuntimeException("Invalid Browser");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void setUp() {
        initializeTest("Chrome");
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
