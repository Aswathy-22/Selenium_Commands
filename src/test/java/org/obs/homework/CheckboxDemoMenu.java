package org.obs.homework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;
public class CheckboxDemoMenu extends Baseform {
    @Test
    public void checkboxDemoMenu() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement checkboxClick = driver.findElement(By.xpath("//input[@id='gridCheck']"));
        checkboxClick.click();
    }

    @Test
    public void multipleCheckboxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement checkboxClick = driver.findElement(By.xpath("//input[@id='gridCheck']"));
        Select select = new Select(checkboxClick);
        List<WebElement> checkboxValue = select.getOptions();
        WebElement selectAllButton = driver.findElement(By.xpath("//input[@id='button-two']"));
        selectAllButton.click();
    }
}
