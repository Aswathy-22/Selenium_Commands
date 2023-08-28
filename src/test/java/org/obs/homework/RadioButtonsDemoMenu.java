package org.obs.homework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class RadioButtonsDemoMenu extends Baseform{
    @Test
    public void radioButtonMenu() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        List<WebElement> genders = driver.findElements(By.xpath("//input[@name='inlineRadioOptions']/following-sibling::label"));
        String genderToSelect="Female";
        selectGender(genderToSelect,genders);
    }
    public void selectGender(String gender, List<WebElement> genders) {
        for (int i = 0; i < genders.size(); i++) {
            WebElement gen = genders.get(i);
            String genderValue = gen.getText();
            if (genderValue.equals(gender)) {
                gen.click();
            }
        }
        WebElement showSelectedValueButton= driver.findElement(By.xpath("//button[@id='button-one']"));
        showSelectedValueButton.click();
    }
    @Test
    public void groupRadioButton(){
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        List<WebElement>patientGender=driver.findElements(By.xpath("//input[@name='student-gender']"));
        List<WebElement>patientAgegroup=driver.findElements(By.xpath("//input[@name='student-age']"));
        selectGroupRadioButton("Female","45 to 60",patientGender,patientAgegroup);
        WebElement selectGen= driver.findElement(By.xpath("//input[@id='inlineRadio21']"));
        String actualGender= selectGen.getText();
        Assert.assertTrue(actualGender.contains("Female"),"Selected gender should be Female");
        WebElement selectAge= driver.findElement(By.xpath("//input[@id='inlineRadio24']"));
        String actualAgeSelected=selectAge.getText();
    }
    public void selectGroupRadioButton(String gender, String ageGroup, List<WebElement> patientGender, List<WebElement> patientAgegroup) {
       selectRadioButton(gender,patientGender);
       selectRadioButton(ageGroup,patientAgegroup);
    }
    public void selectRadioButton(String menu, List<WebElement> radiobutton) {
        for (WebElement Button: radiobutton) {
            String actualmenu=Button.getText();
            if(actualmenu.equals(menu)){
                Button.click();
            }
        }
    }
}
