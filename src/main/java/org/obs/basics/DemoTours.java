package org.obs.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class DemoTours
{
    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.guru99.com/test/newtours/");
        //WebElement yourDestination=driver.findElement(By.linkText("Register here"));
        //yourDestination.click();
        WebElement yourDestination=driver.findElement(By.partialLinkText("Register"));
        List<WebElement> hyperLinks=driver.findElements(By.tagName("a"));
        System.out.println("Count of hyperlinks : " +hyperLinks.size());
        yourDestination.click();
        driver.close();
    }
}
