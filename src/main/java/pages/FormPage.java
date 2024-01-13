package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class FormPage extends AndroidActions {
    AndroidDriver driver;
    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement genderMale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement genderFemale;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countryDropdown;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopButton;

    @AndroidFindBy(xpath ="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Argentina\"]")
    private WebElement Argentina;

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender) {

        if(gender.contains("female")) {
            genderFemale.click();
        }else {
            genderMale.click();
        }
    }

    public void selectCountry() {
        countryDropdown.click();
       // scrollToText(countryName);
      // WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"'"));
        scrollForMobile(Argentina);
        //Argentina.click();
        System.out.println("Country Selected : ");
    }

    public ProductCatalogue submitForm() {
        letsShopButton.click();
        System.out.println("Lets Start. . .");
        return new ProductCatalogue(driver);
    }

}
