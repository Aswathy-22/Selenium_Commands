package org.obs.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Registration
{
    public static void main(String[] args) {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement register=driver.findElement(By.xpath("//a[text()='REGISTER']"));
        register.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys("Aswathy ");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys("S S");
        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys("8547283301");
        WebElement email = driver.findElement(By.xpath("//input[@id='userName']"));
        email.sendKeys("aswathyarabind@gmail.com");
        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys("Pappanamcod");
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("Trivandrum");
        WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
        state.sendKeys("Kerala");
        WebElement postalCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCode.sendKeys("695019");
        WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
        userName.sendKeys("Aswathy22");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("aswathy22");
        WebElement confirmPass = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPass.sendKeys("aswathy22");
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
        driver.close();
    }
}
