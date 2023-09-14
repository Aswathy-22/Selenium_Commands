package org.obs.testngbasics.com;
import org.obs.failedtestretry.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HomePageTest extends Base{
    @Test(priority = 1,invocationCount = 2,groups = {"Sanity","Regression"})
    public void verifyHomePageTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop";
        Assert.assertEquals(actualTitle, expectedTitle, "HomePage Title Mismatch");
    }
    @Test(priority = 4,groups = {"Sanity","Regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifySubscribeMessage(){
        WebElement messageField= driver.findElement(By.id("newsletter-email"));
        messageField.click();
        WebElement subscribeButton= driver.findElement(By.id("newsletter-subscribe-button"));
        subscribeButton.click();
        String actualMessage = driver.getTitle();
        String expectedMessage = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";
        Assert.assertEquals(actualMessage, expectedMessage, "Email Subscription failed");
    }
    @Test(priority = 3,enabled = true,groups = {"Smoke"})
    public void verifyButton(){
        Assert.assertTrue(true);
    }
    @Test(priority = 2,groups = {"Sanity","Regression"})
    public void verifyPanel(){
        Assert.assertTrue(true);
    }
}
