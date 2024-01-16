package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class WiFiSettings extends AndroidActions {

    private AndroidDriver driver; // Corrected the driver type to WebElement

    public WiFiSettings(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(accessibility = "Preference")
    public WebElement preference;

    @AndroidFindBy(accessibility = "3. Preference dependencies")
    public WebElement preferenceDependencies;

    @AndroidFindBy(id = "android:id/checkbox")
    public WebElement checkBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/title\").text(\"WiFi settings\")")
    public WebElement wifiSettings; // Corrected the annotation for resource-id and text

    @AndroidFindBy(id = "android:id/edit")
    private WebElement wifiSettingsTextField;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement okButton;

    @AndroidFindBy(id = "android:id/alertTitle")
    public WebElement popUp;

    public String popUpText = popUp.getText();

    public void wifiKey() {
        wifiSettingsTextField.sendKeys("DannyZwiFi");
    }
}
