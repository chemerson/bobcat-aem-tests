package com.eyestests;

import com.applitools.eyes.*;
import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Random;

public class eyesconfig {

    public static Eyes set(){

        Eyes eyes;

        Random rand = new Random();
        Integer rnum = rand.nextInt(99999);

        EyesRunner runner = new VisualGridRunner(10);

        Configuration renderConfig = new Configuration();

        BatchInfo batchInfo = new BatchInfo("Bobcat Demo 5");
        batchInfo.setId("AEMBatch" + rnum);

        renderConfig

                // 15 browsers
                /*
                .addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_7, ScreenOrientation.PORTRAIT))
                .addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_11_Pro, ScreenOrientation.PORTRAIT))
                .addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_X, ScreenOrientation.PORTRAIT))

                .addBrowser(new ChromeEmulationInfo(DeviceName.Pixel_2, ScreenOrientation.LANDSCAPE))
                .addBrowser(new ChromeEmulationInfo(DeviceName.Galaxy_S5, ScreenOrientation.LANDSCAPE))

                .addBrowser(1200, 600, BrowserType.CHROME)
                .addBrowser(800, 600, BrowserType.CHROME)
                .addBrowser(600, 600, BrowserType.CHROME)
                .addBrowser(1200, 600, BrowserType.SAFARI)
                .addBrowser(1200, 600, BrowserType.SAFARI_ONE_VERSION_BACK)
                .addBrowser(1200, 600, BrowserType.SAFARI_TWO_VERSIONS_BACK)
                .addBrowser(1200, 600, BrowserType.FIREFOX)
                .addBrowser(1200, 600, BrowserType.IE_10)
                .addBrowser(1200, 600, BrowserType.IE_11)
                */

                .addBrowser(1200, 600, BrowserType.EDGE_CHROMIUM)

                .setParentBranchName("default")
                .setBranchName("AEM Bobcat 6")
                .setBaselineBranchName("AEM Bobcat 6")

                .setBatch(batchInfo)

                .setApiKey("vJxZ0vRcUghlZQIr5I3XaK2Z6R6qT897KFaJ102kDhv1Co110") //demo 1

                .setSendDom(true)
                .setViewportSize(new RectangleSize(1600, 900))

                .setAccessibilityValidation(
                        new AccessibilitySettings(AccessibilityLevel.AAA,
                                AccessibilityGuidelinesVersion.WCAG_2_1));

        eyes = new Eyes(runner);

        //eyes.setLogHandler(new StdoutLogHandler(true));
        eyes.setLogHandler(new FileLogger("eyes_bobcat.log",false,true));

        eyes.setConfiguration(renderConfig);

        eyes.addProperty("Bobcat", "Yes");  //Optional custom properties for grouping

        return eyes;

    }



    public void changePageSingle(RemoteWebDriver driver, String from, String to){

        String script = "" +
                "                                    var elements = window.document.querySelectorAll(\"body, body *\");\n" +
                "                                    var child;\n" +
                "                                    for(var i = 0; i < elements.length; i++) {\n" +
                "                                        child = elements[i].childNodes[0];\n" +
                "                                        if(elements[i].hasChildNodes() && child.nodeType == 3) {\n" +
                "                                           child.nodeValue = child.nodeValue.replace('" + from +"','" + to + "');" +
                "                                        }\n" +
                "                                    }\n";
        driver.executeScript(script);
    }

    public void addVerticalSpaceToPage(RemoteWebDriver driver){

        /*
        String script = "" +
                "                                    var elements = window.document.querySelectorAll(\"body, body *\");\n" +
                "                                    var child;\n" +
                "                                    for(var i = 0; i < elements.length; i++) {\n" +
                "                                        if(elements[i].nodeName == 'p') {\n" +
                "                                           elements[i].style.marginTop = '2px';" +
                "                                        }\n" +
                "                                    }\n";
        */

        String script = "var elements = document.querySelectorAll('h2'); var child;" +
                "for(var i = 0; i < elements.length; i++) {elements[i].style.marginTop = '10px'; }";


        driver.executeScript(script);

    }

}
