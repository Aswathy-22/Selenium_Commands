package org.obs.homework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class SelectInputMenu extends Baseform {
    @Test
    public void selectInputForm1() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colorField = driver.findElement(By.xpath("//select[@id='single-input-field']"));
        Select select = new Select(colorField);
       //select.selectByVisibleText("Red");
        select.selectByVisibleText("Yellow");
       //select.selectByVisibleText("Green");
        List<WebElement> dropDown = select.getOptions();
        int size = dropDown.size();
        System.out.println("The size is " + size);
        for (int i = 0; i < size; i++) {
            WebElement dropdownfield = dropDown.get(i);
            String colorName = dropdownfield.getText();
            System.out.println(colorName);
        }
    }
    @Test
    public void selectInputForm2() {
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colorField = driver.findElement(By.xpath("//select[@id='multi-select-field']"));
        Select select = new Select(colorField);
        boolean isMultiple = select.isMultiple();
        Assert.assertTrue(isMultiple, "Given dropdown is not a multiselect");
        select.selectByVisibleText("Red");
        //select.selectByVisibleText("Yellow");
        select.selectByVisibleText("Green");
        List<WebElement> dropDown = select.getAllSelectedOptions();
        WebElement getFirstSelectedButton=driver.findElement(By.xpath("//button[@id='button-first']"));
        getFirstSelectedButton.click();
        WebElement getAllSelectedButton= driver.findElement(By.xpath("//button[@id='button-all']"));
        getAllSelectedButton.click();
        for (int i = 0; i < dropDown.size(); i++) {
            WebElement selectedvalue = dropDown.get(i);
            String valueselected = selectedvalue.getText();
            System.out.println(valueselected);
        }
    }
}
