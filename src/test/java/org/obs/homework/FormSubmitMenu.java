package org.obs.homework;
import org.obs.utility.RandomDataGeneration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FormSubmitMenu extends Baseform {
    @Test
    public void formSubmitMenu() {
        driver.get("https://selenium.obsqurazone.com/form-submit.php");
        String fName = RandomDataGeneration.getFirstname();
        String lName = RandomDataGeneration.getLastname();
        String uName = RandomDataGeneration.getFirstname();
        String cty = RandomDataGeneration.getCity();
        String states = RandomDataGeneration.getState();
        String zcode = RandomDataGeneration.getPostalCode();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
        firstName.sendKeys(fName);
        WebElement lastName = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
        lastName.sendKeys(lName);
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys(uName);
        WebElement city = driver.findElement(By.xpath("//input[@placeholder='City']"));
        city.sendKeys(cty);
        WebElement state = driver.findElement(By.xpath("//input[@placeholder='State']"));
        state.sendKeys(states);
        WebElement zipCode = driver.findElement(By.xpath("//input[@placeholder='Zip']"));
        zipCode.sendKeys(zcode);
        WebElement agreeCheckBox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
        agreeCheckBox.click();
        Assert.assertTrue(agreeCheckBox.isSelected(),"Agree checkbox should be selected");
        WebElement submitform = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        submitform.submit();
        Assert.assertTrue(submitform.isDisplayed(),"Submit button should be displayed");
    }
}
