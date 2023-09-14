package org.obs.testngbasics.com;

import org.obs.utility.Excelutility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name="userCredentials")
    public Object[][] userCredentials(){
        Object[][] data=new Object[3][2];
        data[0][0]="aswathyarabind@gmail.com";//valid id
        data[0][1]="addsd";//invalid pass
        data[1][0]="aswathy@gmail.com";//invalid id
        data[1][1]="marryGold257%";//valid pass
        data[2][0]="aswathyarind@gmail.com";//invalid
        data[2][1]="marryld257%";//invalid
        return  data;
    }
    @DataProvider(name="orangeHRMCredentials")
    public Object[][] orangeHRMCredentials() {
        Object[][] data=new Object[3][2];
        data[0][0]="aswathyarabind@gmail.com";//valid id
        data[0][1]="addsd";//invalid pass
        data[1][0]="aswathy@gmail.com";//invalid id
        data[1][1]="marryGold257%";//valid pass
        data[2][0]="aswathyarind@gmail.com";//inval
        data[2][1]="marryld257%";//invalid
        return  data;
    }
    @DataProvider(name="userCredentialsfromExcel")
    public Object[][] userCredentialsfromExcel(){
        Excelutility excel=new Excelutility();
       Object[][] data= excel.dataProviderRead("VerifyinvalidUserLogin");
       return data;
    }
}
