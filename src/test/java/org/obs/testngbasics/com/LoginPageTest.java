package org.obs.testngbasics.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
    @Test(dataProvider ="userCredentialsfromExcel",dataProviderClass = LoginDataProvider.class)
    public void verifyInvalidUserLogin(String uName, String pword) {
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        String emailId = uName;
        String password = pword;
        WebElement emailfield = driver.findElement(By.id("Email"));
        emailfield.sendKeys(emailId);
        WebElement passwordfield = driver.findElement(By.name("Password"));
        passwordfield.sendKeys(password);
        WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginbutton.click();
        WebElement errorMessage= driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
        String actualErrormessage = errorMessage.getText();
        String expectedErrormessage = "Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals(actualErrormessage, expectedErrormessage, "Error message not displayed");
    }
    @Test(dataProvider ="orangeHRMCredentials",dataProviderClass = LoginDataProvider.class)
    public void verifyOrangeHRMInvalidUserLogin(String uName, String pword) {
        String emailId = uName;
        String password = pword;
        WebElement emailfield = driver.findElement(By.name("username"));
        emailfield.sendKeys(emailId);
        WebElement passwordfield = driver.findElement(By.name("password"));
        passwordfield.sendKeys(password);
        WebElement loginbutton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginbutton.click();
        WebElement errorMessage= driver.findElement(By.xpath("//p[text() ='Invalid credentials']"));
        String actualErrormessage = errorMessage.getText();
        String expectedErrormessage = "Invalid credentials";
        Assert.assertEquals(actualErrormessage, expectedErrormessage, "Error message not displayed");
    }
}
