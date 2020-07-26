package com.applitools;

import com.applitools.eyes.*;
import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.*;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

public class eyesconfig {

    public static Eyes set(Eyes eyes){

        EyesRunner runner = new VisualGridRunner(10);
        Configuration renderConfig = new Configuration();

        renderConfig


                .addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_7, ScreenOrientation.PORTRAIT))
                .addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_11_Pro, ScreenOrientation.PORTRAIT))
                .addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_X, ScreenOrientation.PORTRAIT))

                .addBrowser(new ChromeEmulationInfo(DeviceName.Pixel_2, ScreenOrientation.LANDSCAPE))
                .addBrowser(new ChromeEmulationInfo(DeviceName.Galaxy_S5, ScreenOrientation.LANDSCAPE))

                .addBrowser(1200, 600, BrowserType.CHROME)
                .addBrowser(800, 600, BrowserType.CHROME)
                .addBrowser(600, 600, BrowserType.CHROME)
                .addBrowser(1200, 600, BrowserType.SAFARI)
                .addBrowser(1200, 600, BrowserType.FIREFOX)
                .addBrowser(1200, 600, BrowserType.IE_10)
                .addBrowser(1200, 600, BrowserType.IE_11)
                .addBrowser(1200, 600, BrowserType.EDGE_CHROMIUM)

                .setBatch(new BatchInfo("Bobcat Demo"))

                .setApiKey("vJxZ0vRcUghlZQIr5I3XaK2Z6R6qT897KFaJ102kDhv1Co110")

                .setSendDom(true)
                .setViewportSize(new RectangleSize(1600, 900))

                .setAccessibilityValidation(
                        new AccessibilitySettings(AccessibilityLevel.AAA,
                                AccessibilityGuidelinesVersion.WCAG_2_1));


        // Initialize the eyes SDK and set your private API key.
        eyes = new Eyes(runner);

       // eyes.setLogHandler(new StdoutLogHandler(true));

        //Pass in the run configuration to eyes
        eyes.setConfiguration(renderConfig);

        eyes.addProperty("Bobcat", "Yes");

        return eyes;

    }


}
