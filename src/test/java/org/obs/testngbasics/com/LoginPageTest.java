package org.obs.testngbasics.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base{
    @Test
    public void verifyUserLogin() {
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        String emailId = "aswathyarabind@gmail.com";
        String password = "marryGold257%";
        WebElement emailfield = driver.findElement(By.id("Email"));
        emailfield.sendKeys(emailId);
        WebElement passwordfield = driver.findElement(By.name("Password"));
        passwordfield.sendKeys(password);
        WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginbutton.click();
        WebElement userAccountEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualEmail = userAccountEmail.getText();
        Assert.assertEquals(actualEmail, emailId, "User Login failed");
    }
   @Test
    public void loginPageTitle(){
       WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
       login.click();
       String actualTitle = driver.getTitle();
       String expectedTitle = "Demo Web Shop. Login";
       Assert.assertEquals(actualTitle, expectedTitle, "LoginPage Title Mismatch");
   }

}
