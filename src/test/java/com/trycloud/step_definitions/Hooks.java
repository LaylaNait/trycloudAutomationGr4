package com.trycloud.step_definitions;

import com.trycloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()) {
            WebDriver driver = Driver.getDriver();
            byte[]bytes =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }
        Driver.closeDriver();
    }
}
