package org.obs.seleniumcommands;

import org.obs.utility.RandomDataGeneration;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BasicCommands extends Base {
    @Test
    public void verifyPageTitle() {
        driver.get("https://demowebshop.tricentis.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Web Shop";
        Assert.assertEquals(actualTitle, expectedTitle, "Invalid Browser");
    }
    @Test
    public void verifyUserLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));
        login.click();
        String emailId="aswathyarabind@gmail.com";
        String password="marry%";
        WebElement emailfield = driver.findElement(By.id("Email"));
        emailfield.sendKeys(emailId);
        WebElement passwordfield = driver.findElement(By.name("Password"));
        passwordfield.sendKeys(password);
        WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginbutton.click();
        WebElement userAccountEmail= driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualEmail=userAccountEmail.getText();
        Assert.assertEquals(actualEmail,emailId,"User Login failed");
    }
    @Test
    public void verifyRegisterLogin() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        String fName= RandomDataGeneration.getFirstname();
        String lName=RandomDataGeneration.getLastname();
        String emailId=fName+"."+lName+"@obsqura.com";
        String password=fName+"@"+lName;
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
        WebElement userAccountEmail= driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualEmail=userAccountEmail.getText();
        Assert.assertEquals(actualEmail,emailId,"User Login failed");
    }
    @Test
    public void verifyDifferentWebelementCommands(){
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        String valueAttributeValue=registerButton.getAttribute("value");
        String typeAttributeValue=registerButton.getAttribute("type");
        String classAttributeValue=registerButton.getAttribute("class");
        System.out.println(valueAttributeValue);
        System.out.println(typeAttributeValue);
        System.out.println(classAttributeValue);
        String tagName=registerButton.getTagName();
        System.out.println(tagName);
    }
    @Test
    public void verifyRegisterButtonDisplayedorNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        boolean displayStatus=registerButton.isDisplayed();
        System.out.println(displayStatus);
        Assert.assertTrue(displayStatus,"Register Button Not displayed");
    }
    @Test
    public void verifyRegisterButtonEnabledorNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        boolean enableStatus=registerButton.isEnabled();
        System.out.println(enableStatus);
        Assert.assertTrue(enableStatus,"Register Button Not Enabled");
    }
    @Test
    public void VerifyGenderSelectedorNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement gender = driver.findElement(By.id("gender-female"));
        boolean selectStatus=gender.isSelected();
        System.out.println("Before click "+selectStatus);
        Assert.assertFalse(selectStatus,"Gender selected");
        gender.click();
        boolean selectStatus1=gender.isSelected();
        System.out.println("After click "+selectStatus1);
        Assert.assertTrue(selectStatus1,"Gender not selected");
    }
    @Test
    public void VerifyFormSubmit() {
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
        WebElement submitform = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        //submitform.click();
        submitform.submit();
     }
    @Test
    public void VerifyNavigationCommands(){
        //driver.get("https://demowebshop.tricentis.com/");
        driver.navigate().to("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement firstName=driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Aswathy");
        WebElement lastName=driver.findElement(By.id("LastName"));
        lastName.sendKeys("S S");
        WebElement emailId=driver.findElement(By.id("Email"));
        emailId.sendKeys("asw@gmail.com");
        driver.navigate().refresh();
        driver.navigate().to("https://demowebshop.tricentis.com/cart");
    }
    @Test
    public void VerifygetCssValue(){
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.name("submit"));
        String color= element.getCssValue("background-color");
        System.out.println("Color is : "+color);
        String font= element.getCssValue("font-size");
        System.out.println("Font is : "+font);

    }
    @Test
    public void VerifygetLocation(){
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.name("submit"));
        Point point = element.getLocation();
        System.out.println("X cordinate : " + point.x);
        System.out.println("Y cordinate : " + point.y);
    }
    @Test
    public void VerifygetSize(){
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.name("submit"));
        Dimension dimensions = element.getSize();
        System.out.println("Height :"+dimensions.height);
        System.out.println("Width  :"+dimensions.width);
    }
    @Test // code for checking selected gender - male or female
    public void verifySelectGender(){
        driver.get("http://demowebshop.tricentis.com/register");
        List<WebElement> genders=driver.findElements(By.name("Gender"));
        selectGender("female",genders);
    }
    public void selectGender(String gender,List<WebElement> genders) {
        for (int i = 0; i < genders.size(); i++) {
            WebElement gen = genders.get(i);
            String idAttributeValue = gen.getAttribute("id");
            System.out.println(idAttributeValue);
            if (idAttributeValue.contains(gender)) {
                gen.click();
                break;
            }
        }
    }
    @Test
    public void verifyPanelSelection(){
        driver.get("https://demo.guru99.com/test/newtours/");
        List<WebElement> panelselect=driver.findElements(By.xpath("//table/tbody//tr[contains(@class,'mouse')]//a"));
        selectPanel("Car Rentals",panelselect);
    }
    public void selectPanel(String panelName, List<WebElement> panelselect) {
        for(int i=0;i<panelselect.size();i++) {
            WebElement pan = panelselect.get(i);
            String textAttribute=pan.getText();
            System.out.println(textAttribute);
            if (textAttribute.equals(panelName)) {
                pan.click();
                break;
            } else if (textAttribute.equals(panelName)) {
                pan.click();
                break;
            } else if (textAttribute.equals(panelName)) {
                pan.click();
                break;
            } else if (textAttribute.equals(panelName)) {
                pan.click();
                break;
            } else if (textAttribute.equals(panelName)) {
                pan.click();
                break;
            } else if (textAttribute.equals(panelName)) {
                pan.click();
                break;
            } else if (textAttribute.equals(panelName)) {
                pan.click();
                break;
            } else {
                System.out.println("INVALID");
            }
        }
    }
    @Test
    public void verifyDiffBtwFindelemetandFindelements(){
        driver.get("https://demo.guru99.com/test/newtours/");
        //WebElement panelselect=driver.findElement(By.xpath("//table/tbody//tr[contains(@class,'mouse123')]//a"));
        List<WebElement> panels=driver.findElements(By.xpath("//table/tbody//tr[contains(@class,'mouse123')]//a"));
        System.out.println(panels.size());
    }
    @Test
    public void verifySimpleAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement clickmeButton= driver.findElement(By.id("alertButton"));
        clickmeButton.click();
        Alert alert=driver.switchTo().alert(); //switching to alert
        String alertText=alert.getText();
        System.out.println(alertText);
        alert.accept();
    }
    @Test
    public void verifyConfirmationAlertOKButton() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickmeButton = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
        clickmeButton.click();
        Thread.sleep(10000);
        Alert alert=driver.switchTo().alert(); //switching to alert
        String alertText=alert.getText();
        System.out.println(alertText);
        alert.accept();
    }
    @Test
    public void verifyConfirmationAlertCancelButton() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickmeButton = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
        clickmeButton.click();
        Thread.sleep(10000);
        Alert alert=driver.switchTo().alert(); //switching to alert
        String alertText=alert.getText();
        System.out.println(alertText);
        alert.dismiss();
    }
    @Test
    public void verifyPromptAlert() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickmeButton= driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        clickmeButton.click();
        Thread.sleep(10000);
        Alert alert=driver.switchTo().alert(); //switching to alert
        String alertText=alert.getText();
        System.out.println(alertText);
        alert.sendKeys("Aswathy");
        alert.accept();
    }
}
