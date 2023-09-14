package org.obs.homework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class RadioButtonsDemoMenu extends Baseform{
    @Test
    public void verifyRadioButtonMenu() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        List<WebElement> genderList = driver.findElements(By.xpath("//input[@name='inlineRadioOptions']//following-sibling::label"));
        genderSelect("Female", genderList);
        WebElement showSelectedValueButton = driver.findElement(By.id("button-one"));
        showSelectedValueButton.click();
        boolean isDisplayed= showSelectedValueButton.isDisplayed();
        Assert.assertTrue(isDisplayed,"Button not displayed");

        List<WebElement> patientGenderList = driver.findElements(By.xpath("//input[@name='student-gender']//following-sibling::label"));
        patientGenderSelect("Female", patientGenderList);
        List<WebElement> patientAgeGroupList = driver.findElements(By.xpath("//input[@name='student-age']/following-sibling::label"));
        patientAgeGroup("45 to 60", patientAgeGroupList);
        WebElement getResultsButton = driver.findElement(By.id("button-two"));
        getResultsButton.click();
    }
    public void genderSelect(String gender, List<WebElement> genderList) {
        for (int i = 0; i < genderList.size(); i++) {
            WebElement genderElement = genderList.get(i);
            String genderText = genderElement.getText();
            if (genderText.equals(gender)) {
                genderElement.click();
            }
        }
    }
    public void patientGenderSelect(String patenintGender, List<WebElement> patientGenderList) {
        for (int j = 0; j < patientGenderList.size(); j++) {
            WebElement genderElement = patientGenderList.get(j);
            String genderText = genderElement.getText();
            if (genderText.equals(patenintGender)) {
                genderElement.click();
            }
        }
    }
        public void patientAgeGroup(String age, List < WebElement > patientAgeGroupList){
            for (int k = 0; k < patientAgeGroupList.size(); k++) {
                WebElement ageElement = patientAgeGroupList.get(k);
                String ageElementText = ageElement.getText();
                if (ageElementText.equals(age)) {
                    ageElement.click();
                }
            }
        }
    }