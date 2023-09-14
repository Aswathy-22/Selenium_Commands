package org.obs.testngbasics.com;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Base {
    public WebDriver driver;
    public void initializeTest(String browser) {
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
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
    @Parameters({"browser","baseurl"})
    public void setUp(String browserName, String url) {
        //initializeTest("Chrome");
        //driver.get("https://demowebshop.tricentis.com/");
        initializeTest(browserName);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    public void tearDown() {
        driver.close();//will kill current instance
    }
    @BeforeSuite
    public void connectDb(){
        System.out.println("CONNECTED TO DATABASE");
    }
    @AfterSuite
    public void closeDb(){
        System.out.println("CLOSE DATABASE");
    }
    @BeforeTest
    public void runLoginAPI(){
        System.out.println("RUNNING LOGIN API");
    }
    @AfterTest
    public void runLogoutAPI(){
        System.out.println("RUNNING LOGOUT API");
    }
    @BeforeClass
    public void createTestTable(){
        System.out.println("CREATING TEST FOLDER");
    }
    @AfterClass
    public void dropTestTable(){
        System.out.println("DROPPING TEST FOLDER");
    }
}
