package org.obs.seleniumcommands;
import org.obs.utility.RandomDataGeneration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
        String emailId = "aswathyarabind@gmail.com";
        String password = "marry%";
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
    public void verifyRegisterLogin() {
        driver.get("https://demowebshop.tricentis.com/register");
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
    public void verifyDifferentWebelementCommands() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        String valueAttributeValue = registerButton.getAttribute("value");
        String typeAttributeValue = registerButton.getAttribute("type");
        String classAttributeValue = registerButton.getAttribute("class");
        System.out.println(valueAttributeValue);
        System.out.println(typeAttributeValue);
        System.out.println(classAttributeValue);
        String tagName = registerButton.getTagName();
        System.out.println(tagName);
    }

    @Test
    public void verifyRegisterButtonDisplayedorNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        boolean displayStatus = registerButton.isDisplayed();
        System.out.println(displayStatus);
        Assert.assertTrue(displayStatus, "Register Button Not displayed");
    }

    @Test
    public void verifyRegisterButtonEnabledorNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        boolean enableStatus = registerButton.isEnabled();
        System.out.println(enableStatus);
        Assert.assertTrue(enableStatus, "Register Button Not Enabled");
    }
    @Test
    public void VerifyGenderSelectedorNot() {
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement gender = driver.findElement(By.id("gender-female"));
        boolean selectStatus = gender.isSelected();
        System.out.println("Before click " + selectStatus);
        Assert.assertFalse(selectStatus, "Gender selected");
        gender.click();
        boolean selectStatus1 = gender.isSelected();
        System.out.println("After click " + selectStatus1);
        Assert.assertTrue(selectStatus1, "Gender not selected");
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
    public void VerifyNavigationCommands() {
        //driver.get("https://demowebshop.tricentis.com/");
        driver.navigate().to("https://demowebshop.tricentis.com/");
        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Aswathy");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("S S");
        WebElement emailId = driver.findElement(By.id("Email"));
        emailId.sendKeys("asw@gmail.com");
        driver.navigate().refresh();
        driver.navigate().to("https://demowebshop.tricentis.com/cart");
    }

    @Test
    public void VerifygetCssValue() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.name("submit"));
        String color = element.getCssValue("background-color");
        System.out.println("Color is : " + color);
        String font = element.getCssValue("font-size");
        System.out.println("Font is : " + font);

    }

    @Test
    public void VerifygetLocation() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.name("submit"));
        Point point = element.getLocation();
        System.out.println("X cordinate : " + point.x);
        System.out.println("Y cordinate : " + point.y);
    }

    @Test
    public void VerifygetSize() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.name("submit"));
        Dimension dimensions = element.getSize();
        System.out.println("Height :" + dimensions.height);
        System.out.println("Width  :" + dimensions.width);
    }

    @Test // code for checking selected gender - male or female
    public void verifySelectGender() {
        driver.get("http://demowebshop.tricentis.com/register");
        List<WebElement> genders = driver.findElements(By.name("Gender"));
        selectGender("female", genders);
    }

    public void selectGender(String gender, List<WebElement> genders) {
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
    public void verifyPanelSelection() {
        driver.get("https://demo.guru99.com/test/newtours/");
        List<WebElement> panelselect = driver.findElements(By.xpath("//table/tbody//tr[contains(@class,'mouse')]//a"));
        selectPanel("Car Rentals", panelselect);
    }

    public void selectPanel(String panelName, List<WebElement> panelselect) {
        for (int i = 0; i < panelselect.size(); i++) {
            WebElement pan = panelselect.get(i);
            String textAttribute = pan.getText();
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
    public void verifyDiffBtwFindelemetandFindelements() {
        driver.get("https://demo.guru99.com/test/newtours/");
        //WebElement panelselect=driver.findElement(By.xpath("//table/tbody//tr[contains(@class,'mouse123')]//a"));
        List<WebElement> panels = driver.findElements(By.xpath("//table/tbody//tr[contains(@class,'mouse123')]//a"));
        System.out.println(panels.size());
    }

    @Test
    public void verifySimpleAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickmeButton = driver.findElement(By.id("alertButton"));
        clickmeButton.click();
        Alert alert = driver.switchTo().alert(); //switching to alert
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }

    @Test
    public void verifyConfirmationAlertOKButton() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickmeButton = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
        clickmeButton.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert(); //switching to alert
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }

    @Test
    public void verifyConfirmationAlertCancelButton() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickmeButton = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
        clickmeButton.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert(); //switching to alert
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.dismiss();
    }

    @Test
    public void verifyPromptAlert() throws InterruptedException {
        driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
        WebElement clickmeButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        clickmeButton.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert(); //switching to alert
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.sendKeys("Aswathy");
        alert.accept();
    }
    @Test
    public void verifyUserEdit() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
        passWord.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']]"));
        loginButton.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        List<WebElement> menuselect = driver.findElements(By.xpath("//span[contains(@class,'oxd-text oxd-text--span oxd-main-menu-item--name')]"));
        menuPanel("Admin", menuselect);
        List<WebElement> userDetails = driver.findElements(By.xpath("//div[@class='oxd-table-card']//div//div/following-sibling::div//div"));
        userDetails("David.Morris", userDetails);
    }
    public void menuPanel(String opt, List<WebElement> menuselect) {
        for (int i = 0; i < menuselect.size(); i++) {
            WebElement option = menuselect.get(i);
            String optionText = option.getText();
            System.out.println(optionText);
            if (optionText.equals(opt)) {
                option.click();
                break;
            }
        }
    }
    public void userDetails(String userData, List<WebElement> userDetails) {
        for (int j = 0; j < userDetails.size(); j++) {
            WebElement useDetails = userDetails.get(j);
            String useDetailsText = useDetails.getText();
            System.out.println(useDetailsText);
            if (useDetailsText.equals(userData)) {
            }
        }
    }

    @Test
    public void verifyMultipleWindowHandling() {
        driver.get("https://demo.guru99.com/popup.php");
        String parentWindow = driver.getWindowHandle();//will get parent id
        System.out.println("parent id is " + parentWindow);
        WebElement clickmeButton = driver.findElement(By.xpath("/html/body/p/a"));
        clickmeButton.click();
        Set<String> handles = driver.getWindowHandles();//containes parent and child window id's
        Iterator<String> newSet = handles.iterator();
        while (newSet.hasNext()) {
            String childid = newSet.next();
            if (!parentWindow.equals(childid)) {
                System.out.println("Child id is " + childid);
                driver.switchTo().window(childid);
                WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
                email.sendKeys("aswathy@gmail.com");
                WebElement clickButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
                clickButton.click();
                driver.close();// will close current focus page
            }
        }
        driver.switchTo().window(parentWindow);//switching to parent page
    }

    @Test
    public void validateCountryDropdownValues() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");//Give the navigation of the page where you want to select value for dropdown
        WebElement countryField = driver.findElement(By.xpath("//select[@name='country']"));//locate webelement
        Select select = new Select(countryField); //create select class object for dropdown field and web element passed
        //select.selectByVisibleText("INDIA");//calling a country using object
        //select.selectByValue("INDIA");//value attribute should be there
        select.selectByIndex(10);//will get country name of corresponding index
        List<WebElement> dropDown = select.getOptions();//to get all the values inside dropdown
        //getting the list of options in the dropdown using getOptions() and stored inside list
        int size = dropDown.size();
        System.out.println("The size is " + size);
        //For looping around the values in the field, we will use the size of the getOptions() returned value of the WebElement list (since it would be the maximum value) and iterate and save the values as we get from the field in String format.
        for (int i = 0; i < size; i++) {
            WebElement dropdownfield = dropDown.get(i);//using get each value in the list is stored in a webelement
            String countryName = dropdownfield.getText();//we need text component only, so using getText option we will get text
            System.out.println(countryName);
        }
    }
    @Test
    public void verifySelect() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryDropdown);
        List<WebElement> dropDownValue = select.getOptions();
        int size = dropDownValue.size();
        String countryToselect = "AUSTRIA";
        selectCountry(countryToselect, dropDownValue, select);
        WebElement selectedvalue = select.getFirstSelectedOption();
        String actualselectedvalue = selectedvalue.getText();
        Assert.assertEquals(actualselectedvalue, countryToselect, "NOT SELECTED");
    }
    public void selectCountry(String country, List<WebElement> dropDownValue, Select select) {
        boolean countryFound = false;
        for (int i = 0; i < dropDownValue.size(); i++) {
            WebElement dropvalue = dropDownValue.get(i);
            String countryName = dropvalue.getText();
            if (countryName.equals(country)) {
                System.out.println("GIVEN COUNTRY EXISTS INSIDE DROPDOWN...!");
                select.selectByValue(country);
                countryFound = true;
                break;
            }
        }
        if (!countryFound) {
            throw new RuntimeException("GIVEN COUNTRY DOESNOT EXISTS INSIDE DROPDOWN...!");
        }
    }

    @Test
    public void validateDeselectAll() {
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='second']"));
        Select select = new Select(dropDown);
        boolean isMultiple = select.isMultiple();
        Assert.assertTrue(isMultiple, "Given dropdown is not a multiselect");
        select.selectByVisibleText("Pizza");
        select.selectByVisibleText("Burger");
        List<WebElement> selectedoptions = select.getAllSelectedOptions();
        for (int i = 0; i < selectedoptions.size(); i++) {
            WebElement selectedvalue = selectedoptions.get(i);
            String valueselected = selectedvalue.getText();
            System.out.println(valueselected);
        }
        //select.deselectAll();
        //select.deselectByVisibleText("Pizza");
    }
    @Test
    public void verifyBootStrapDropDown() {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='menu1']"));
        submitButton.click();
        List<WebElement>dropdownList=driver.findElements(By.xpath("//ul//li//a[@role='menuitem']"));
        dropdownmenu("CSS",dropdownList);
    }
    public void dropdownmenu(String valueToSelect, List<WebElement> dropdownList) {
        for(int i=0;i<dropdownList.size();i++)
        {
            WebElement dropDownValue=dropdownList.get(i);
            String valueText=dropDownValue.getText();
            if(valueText.equals(valueToSelect)){
                dropDownValue.click();
            }
        }
    }
    @Test
    public void verifyFileUploader(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFileButton.sendKeys("C:\\selenium\\image.jpg");
        WebElement uploadButton= driver.findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();
        WebElement uploadMessage=driver.findElement(By.xpath("//div[@id='content']//div//h3"));
        String actualMessage=uploadMessage.getText();
        String expectedMessage="File Uploaded!";
        Assert.assertEquals(actualMessage,expectedMessage,"File Not Uploaded");
    }
    @Test
    public void verifyRightClick(){
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickButton= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        rightClickButton.click();
        Actions action=new Actions(driver);
        action.contextClick(rightClickButton).build().perform();//command to perform rightclick
        List<WebElement>menuLists=driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']//li//span"));
        String expectedText[]={"Edit","Cut","Copy","Paste","Delete","Quit"};
        for(int i=0;i< menuLists.size();i++){
            WebElement menu= menuLists.get(i);
            String actualText=menu.getText();
            Assert.assertEquals(actualText,expectedText[i],"Text not found");
        }
    }
    @Test
    public void verifyDoubleClick(){
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickButton= driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        doubleClickButton.click();
        Actions action=new Actions(driver);
        action.doubleClick(doubleClickButton).build().perform();
        Alert alert=driver.switchTo().alert();
        String actualAlertText= alert.getText();
        String expectedAlertText="You double clicked me.. Thank You..";
        alert.accept();
        Assert.assertEquals(actualAlertText,expectedAlertText,"No Alert Message");
    }
    @Test
    public void verifyMovetoElementandClickandHold(){
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        WebElement letterA= driver.findElement(By.xpath("//ul[@id='sortable']//li[@name='A']"));
        WebElement letterC= driver.findElement(By.xpath("//ul[@id='sortable']//li[@name='C']"));
        Actions action=new Actions(driver);
        action.moveToElement(letterA);
        action.clickAndHold();
        action.moveToElement(letterC);
        action.release().build().perform();
    }
    @Test
    public void verifyDragandDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement dragMe= driver.findElement(By.id("draggable"));
        WebElement dragHere= driver.findElement(By.id("droppable"));
        Actions action=new Actions(driver);
        action.dragAndDrop(dragMe,dragHere).build().perform();
    }
    @Test
    public void verifyDragandDropbyOffset() {
        driver.get("https://demoqa.com/dragabble");
        WebElement dragMe=driver.findElement(By.id("dragBox"));
        Actions action=new Actions(driver);
        action.dragAndDropBy(dragMe,100,100).build().perform();
    }
    @Test
    public void verifyMovetoElement() {
        driver.get("https://demoqa.com/menu/");
        Actions action=new Actions(driver);
        WebElement mainItem2=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        action.moveToElement(mainItem2).build().perform();
        WebElement subList=driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        action.moveToElement(subList).build().perform();
        WebElement subListItem1=driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        action.moveToElement(subListItem1).build().perform();
    }
    @Test
    public void verifyProgressBar10() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar10=driver.findElement(By.xpath("//div[@class='range']//input[@name='range']"));
        Actions action=new Actions(driver);
        action.moveToElement(progressBar10).clickAndHold().moveToElement(progressBar10,83,0).release().build().perform();
    }
    @Test
    public void verifyFrames(){
        driver.get("https://demoqa.com/frames");
       driver.switchTo().frame("frame1");
        //WebElement firstFrame= driver.findElement(By.id("frame1")); //using Webelement
        //driver.switchTo().frame(firstFrame);
        //driver.switchTo().frame(1); //using Index
        WebElement frame1= driver.findElement(By.id("sampleHeading")); //using id
        String frame= frame1.getText();
        System.out.println(frame);
       // driver.switchTo().parentFrame();//switch back to parent frame
        driver.switchTo().defaultContent();
    }
    @Test
    public void verifyProgressBar20() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar20=driver.findElement(By.xpath("//div[@class='range range-primary']//input[@name='range']"));
        Actions action=new Actions(driver);
        action.moveToElement(progressBar20).clickAndHold().moveToElement(progressBar20,83,0).release().build().perform();
    }
    @Test
    public void verifyProgressBar30() {
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar30=driver.findElement(By.xpath("//div[@class='range range-success']//input[@name='range']"));
        Actions action=new Actions(driver);
        action.moveToElement(progressBar30).clickAndHold().moveToElement(progressBar30,83,0).release().build().perform();
    }
    @Test
    public void verifyProgressBar40(){
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar40=driver.findElement(By.xpath("//div[@class='range range-info']//input[@name='range']"));
        Actions action=new Actions(driver);
        action.moveToElement(progressBar40).clickAndHold().moveToElement(progressBar40,83,0).release().build().perform();
    }
    @Test
    public void verifyProgressBar50(){
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar50=driver.findElement(By.xpath("//div[@class='range range-warning']//input[@name='range']"));
        Actions action=new Actions(driver);
        action.moveToElement(progressBar50).clickAndHold().moveToElement(progressBar50,83,0).release().build().perform();
    }
    @Test
    public void verifyProgressBar60(){
        driver.get("https://selenium.obsqurazone.com/range-sliders.php");
        WebElement progressBar60=driver.findElement(By.xpath("//div[@class='range range-danger']//input[@name='range']"));
        Actions action=new Actions(driver);
        action.moveToElement(progressBar60).clickAndHold().moveToElement(progressBar60,83,0).release().build().perform();
    }
    @Test
    public void verifyDraggableItemsList() {
        driver.get("https://selenium.obsqurazone.com/drag-drop.php");
        WebElement draggable1= driver.findElement(By.xpath("//div[@id='todrag']//span[text()='Draggable n°1']"));
        WebElement draggable2= driver.findElement(By.xpath("//div[@id='todrag']//span[text()='Draggable n°2']"));
        WebElement draggable3= driver.findElement(By.xpath("//div[@id='todrag']//span[text()='Draggable n°3']"));
        WebElement draggable4= driver.findElement(By.xpath("//div[@id='todrag']//span[text()='Draggable n°4']"));
        WebElement dragZone=driver.findElement(By.id("mydropzone"));
        Actions action=new Actions(driver);
        action.dragAndDrop(draggable1,dragZone).build().perform();
        action.dragAndDrop(draggable2,dragZone).build().perform();
        action.dragAndDrop(draggable3,dragZone).build().perform();
        action.dragAndDrop(draggable4,dragZone).build().perform();
    }
}
