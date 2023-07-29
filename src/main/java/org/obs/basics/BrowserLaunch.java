package org.obs.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BrowserLaunch {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();//upcasting
        //EdgeDriver driver=new EdgeDriver(); or driver=new EdgeDriver();//to open edge browser
        //FirefoxDriver driver=new FirefoxDriver(); driver=new FirefoxDriver();//to open firefox browser
        driver.manage().window().maximize();//maximising browser
        driver.get("https://selenium.obsqurazone.com/index.php");
        String actualTitle = driver.getTitle();//to get title of the website and return is string variable
        System.out.println(actualTitle);
        String actualCurrenturl = driver.getCurrentUrl();
        System.out.println(actualCurrenturl);
        String actualSourcecode = driver.getPageSource();
        System.out.println(actualSourcecode);
        driver.close();//closing the corresponding browser window
    }
}
