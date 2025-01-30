package com.example.hooks;

import com.example.utils.HelperClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public static void setUpDriver()
    {
        HelperClass.setUp();

    }

    @After
    public static void tearDownDriver(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            File srcScreenshotFile = ((TakesScreenshot)HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            String destinationPath = System.getProperty("user.dir") + "/screenshots/" + scenarioName + ".png";

            try
            {
                FileUtils.copyFile(srcScreenshotFile,new File(destinationPath));
            }catch(IOException e)
            {

            }
        }

        HelperClass.tearDown();
    }
}
