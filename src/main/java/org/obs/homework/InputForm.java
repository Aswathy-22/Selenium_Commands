package org.obs.homework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class InputForm
{
    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement enterMessageField=driver.findElement(By.className("form-control"));
        enterMessageField.sendKeys("Hello Everyone");
        WebElement showMessageButton=driver.findElement(By.xpath("//*[@id=\"button-one\"]"));
        showMessageButton.click();
        WebElement enterValueAfield=driver.findElement(By.id("value-a"));
        enterValueAfield.sendKeys("100");
        WebElement enterValueBfield=driver.findElement(By.id("value-b"));
        enterValueBfield.sendKeys("100");
        WebElement gettotalbutton=driver.findElement(By.cssSelector("#button-two"));
        gettotalbutton.click();//to click login button
        driver.close();
    }

}
