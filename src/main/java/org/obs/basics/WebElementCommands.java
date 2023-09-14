package org.obs.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebElementCommands
{
    public static void main(String args[])
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demowebshop.tricentis.com/login");
        WebElement emailfield=driver.findElement(By.id("Email")); //To find web element
        emailfield.sendKeys("aswathyarabind@gmail.com");
        WebElement passwordfield=driver.findElement(By.name("Password"));
        passwordfield.sendKeys("marryGold257%");
        WebElement loginbutton=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginbutton.click();//to click login button

    }
}
