package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WiFiSettings;
import utils.AppiumDriverManager;

public class WiFiSettings_Testcase_02 extends AppiumDriverManager {

    @Test
    public void wifiSetting() {
        WiFiSettings wifi = new WiFiSettings(driver);
        wifi.preference.click();
        wifi.preferenceDependencies.click();
        wifi.checkBox.click();
        wifi.wifiSettings.click();
        wifi.wifiKey();
        wifi.okButton.click();

        Assert.assertEquals(wifi.popUpText,"WiFi settings");

    }


}
