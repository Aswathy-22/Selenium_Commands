package org.obs.basics;

import org.obs.utility.RandomDataGeneration;
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
        String fName= RandomDataGeneration.getFirstname();
        String lName=RandomDataGeneration.getLastname();
        String emailId=fName+"."+lName+"@obsqura.com";
        String password=fName+"@"+lName;
        String phNumber=RandomDataGeneration.getPhonenumber();
        String uName=RandomDataGeneration.getFirstname();
        String addr=RandomDataGeneration.getAddress();
        String cty=RandomDataGeneration.getCity();
        String states=RandomDataGeneration.getState();
        String pcode=RandomDataGeneration.getPostalCode();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys(fName);
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys(lName);
        WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(phNumber);
        WebElement emailid = driver.findElement(By.xpath("//input[@id='email']"));
        emailid.sendKeys(emailId);
        WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
        address.sendKeys(addr);
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys(cty);
        WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
        state.sendKeys(states);
        WebElement postalCode = driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCode.sendKeys(pcode);
        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys(uName);
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys(password);
        WebElement confirmPass = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPass.sendKeys(password);
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
        driver.close();
    }
}
