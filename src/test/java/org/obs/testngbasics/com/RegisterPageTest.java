package org.obs.testngbasics.com;
import org.obs.utility.RandomDataGeneration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RegisterPageTest extends Base{
    @Test
    public void verifyRegisterPage(){
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        String fName = RandomDataGeneration.getFirstname();
        String lName = RandomDataGeneration.getLastname();
        String emailId = fName + "." + lName + "@obsqura.com";
        String password = fName + "@" + lName;
        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-female']"));
        gender.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName' and @name='FirstName']"));
        firstName.sendKeys(fName);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName' and @name='LastName']"));
        lastName.sendKeys(lName);
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys(emailId);
        WebElement passWord = driver.findElement(By.xpath("//input[@id='Password']"));
        passWord.sendKeys(password);
        WebElement confirmPass = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPass.sendKeys(password);
        WebElement register1 = driver.findElement(By.xpath("//input[@name='register-button' ]"));
        register1.click();
        WebElement userAccountEmail = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualEmail = userAccountEmail.getText();
        Assert.assertEquals(actualEmail, emailId, "User Login failed");
    }
    @Test
    public void registerPageTitle(){
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop. Register";
        Assert.assertEquals(actualTitle, expectedTitle, "RegisterPage Title Mismatch");
    }
}
