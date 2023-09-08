package org.obs.testngbasics.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base{
    @Test
    public void verifyHomePageTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop";
        Assert.assertEquals(actualTitle, expectedTitle, "HomePage Title Mismatch");
    }
    @Test
    public void verifySubscribeMessage(){
        WebElement messageField= driver.findElement(By.id("newsletter-email"));
        messageField.click();
        WebElement subscribeButton= driver.findElement(By.id("newsletter-subscribe-button"));
        subscribeButton.click();
        String actualMessage = driver.getTitle();
        String expectedMessage = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";
        Assert.assertEquals(actualMessage, expectedMessage, "Email Subscription failed");
    }
}
