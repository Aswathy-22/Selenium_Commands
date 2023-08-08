package org.obs.basics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DemoWebpageRegistration {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demowebshop.tricentis.com/login");
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName' and @name='FirstName']"));
        firstName.sendKeys("Aswathy");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName' and @name='LastName']"));
        lastName.sendKeys("SS");
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("aswathy@gmail.com");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='Password']"));
        passWord.sendKeys("aswathy22");
        WebElement confirmPass = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPass.sendKeys("aswathy22");
        WebElement register1 = driver.findElement(By.xpath("//input[@name='register-button' ]"));
        register1.click();
        driver.close();
    }
}
