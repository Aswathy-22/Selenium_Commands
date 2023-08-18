package org.obs.sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample
{
    @Test
    public void verifyResult(){
        String expectedResult="Hello";
        String actualResult="HELLO";
        Assert.assertEquals(actualResult,expectedResult,"RESULT NOT MATCHED");
    }
    @Test
    public void verifyIntegerResult(){
        Integer expectedResult=100;
        Integer actualResult=500;
        Assert.assertEquals(actualResult,expectedResult,"RESULT NOT MATCHED");
    }
    @Test
    public void verifyBooleanTrue(){
        Boolean actualResult=true;
        Assert.assertTrue(actualResult,"RESULT NOT MATCHED");
    }
    @Test
    public void verifyBooleanFalse(){

        Assert.assertFalse(true,"RESULT NOT MATCHED");
    }

}
