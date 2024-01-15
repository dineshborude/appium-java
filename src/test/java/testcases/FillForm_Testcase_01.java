package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.AppiumDriverManager;

public class FillForm_Testcase_01 extends AppiumDriverManager {

    @Test
    public void fillFormNegativeTest() {

        FormPage formPage = new FormPage(driver);
        formPage.setGender("male");
        formPage.selectCountry();
        formPage.submitForm();

        formPage.validateToastMessage();



    }

    @Test
    public void fillFormTest() {

        FormPage formPage = new FormPage(driver);
        formPage.setNameField("Danny");
        formPage.setGender("male");
        formPage.selectCountry();
        formPage.submitForm();
    }
}
