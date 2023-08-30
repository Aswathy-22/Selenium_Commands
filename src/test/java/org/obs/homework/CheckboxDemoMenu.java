package org.obs.homework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class CheckboxDemoMenu extends Baseform {
    @Test
    public void checkboxDemoMenu() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement singleCheckBoxDemo = driver.findElement(By.xpath("//input[@id='gridCheck']"));
        singleCheckBoxDemo.click();
        boolean checkBoxClick = singleCheckBoxDemo.isSelected();
        Assert.assertTrue(checkBoxClick, "Check box not selected");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//label[@class='form-check-label' and contains(@for,'check-box')]"));
        multipleCheckBoxDemo("Check Box One", checkBoxList);
        multipleCheckBoxDemo("Check Box One", "Check Box Two", checkBoxList);
        multipleCheckBoxDemo("Check Box One", "Check Box Two", "Check Box Three", checkBoxList);
        multipleCheckBoxDemo("Check Box One", "Check Box Two", "Check Box Three", "Check Box Four", checkBoxList);
        WebElement selectAllButton = driver.findElement(By.id("button-two"));
        selectAllButton.click();
    }
     public void multipleCheckBoxDemo(String checkBoxValue,List<WebElement> checkBoxList){
         for(int i=0;i< checkBoxList.size();i++){
             WebElement elementInList=checkBoxList.get(i);
             String textElement=elementInList.getText();
             if(textElement.equals(checkBoxValue)){
                 elementInList.click();
             }
         }
     }
    public void multipleCheckBoxDemo(String checkBoxValueOne, String checkBoxValueTwo, List<WebElement> checkBoxList) {
        for (int i = 0; i < checkBoxList.size(); i++) {
            WebElement elementInList = checkBoxList.get(i);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueOne)) {
                elementInList.click();
            }
        }
        for (int j = 0; j < checkBoxList.size(); j++) {
            WebElement elementInList = checkBoxList.get(j);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueTwo)) {
                elementInList.click();
            }
        }
    }
    public void multipleCheckBoxDemo(String checkBoxValueOne, String checkBoxValueTwo, String checkBoxValueThree, List<WebElement> checkBoxList) {
        for (int i = 0; i < checkBoxList.size(); i++) {
            WebElement elementInList1 = checkBoxList.get(i);
            String textElement = elementInList1.getText();
            if (textElement.equals(checkBoxValueOne)) {
                elementInList1.click();
            }
        }
        for (int j = 0; j < checkBoxList.size(); j++) {
            WebElement elementInList = checkBoxList.get(j);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueTwo)) {
                elementInList.click();
            }
        }
        for (int k = 0; k < checkBoxList.size(); k++) {
            WebElement elementInList = checkBoxList.get(k);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueThree)) {
                elementInList.click();
            }
        }
    }
    public void multipleCheckBoxDemo(String checkBoxValueOne, String checkBoxValueTwo, String checkBoxValueThree, String checkBoxValueFour, List<WebElement> checkBoxList) {
        for (int i = 0; i < checkBoxList.size(); i++) {
            WebElement elementInList1 = checkBoxList.get(i);
            String textElement = elementInList1.getText();
            if (textElement.equals(checkBoxValueOne)) {
                elementInList1.click();
            }
        }
        for (int j = 0; j < checkBoxList.size(); j++) {
            WebElement elementInList = checkBoxList.get(j);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueTwo)) {
                elementInList.click();
            }
        }
        for (int k = 0; k < checkBoxList.size(); k++) {
            WebElement elementInList = checkBoxList.get(k);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueThree)) {
                elementInList.click();
            }
        }
        for (int l = 0; l < checkBoxList.size(); l++) {
            WebElement elementInList = checkBoxList.get(l);
            String textElement = elementInList.getText();
            if (textElement.equals(checkBoxValueFour)) {
                elementInList.click();
            }
        }
    }
}
