package com.cognifide.qa.bb.aem.tests.siteadmin;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.cognifide.qa.bb.aem.tests.AbstractAemAuthorTest;
import com.eyestests.eyesconfig;
import com.cognifide.qa.bb.aem.tests.pages.ProductionPage;
import com.cognifide.qa.bb.api.actions.ActionException;
import com.cognifide.qa.bb.junit5.guice.Modules;
import com.cognifide.qa.bb.modules.BobcatRunModule;
import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.google.inject.Inject;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Modules(BobcatRunModule.class)
@Epic("AEM 6.4 Base Tests")
@Feature("Production Website Test")
public class productionWebsite extends AbstractAemAuthorTest {

  @Inject
  private BobcatPageFactory bobcatPageFactory;

  @Inject
  private WebDriver webDriver;

  @Test
  @Story("Production test")
  @Description("Click on prod homepage link")
  public void createPageActionTest() throws ActionException {

    WebDriver driver = ((EventFiringWebDriver)webDriver).getWrappedDriver();

    Eyes eyes = new Eyes();
    eyes = eyesconfig.set(eyes);

    eyes.open(driver, "AEM", "Click on prod homepage link");

    ProductionPage prodPage = bobcatPageFactory.create("https://www.pnc.com", ProductionPage.class);
    assertTrue(prodPage.open().isDisplayed());

    eyes.check("Step 1", Target.window());

    //prodPage.clickIRA();

    //eyes.check("Step 2", Target.window());

    eyes.close();

  }

}
