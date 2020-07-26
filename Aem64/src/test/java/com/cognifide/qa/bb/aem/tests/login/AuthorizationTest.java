package com.cognifide.qa.bb.aem.tests.login;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.eyestests.eyesconfig;
import com.cognifide.qa.bb.aem.core.api.AemActions;
import com.cognifide.qa.bb.aem.tests.pages.TestPage;
import com.cognifide.qa.bb.api.actions.ActionException;
import com.cognifide.qa.bb.api.actions.ActionsController;
import com.cognifide.qa.bb.junit5.guice.Modules;
import com.cognifide.qa.bb.modules.BobcatRunModule;
import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.google.inject.Inject;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Modules(BobcatRunModule.class)
@Epic("AEM 6.4 Base Tests")
@Feature("Login to AEM")
@Disabled
public class AuthorizationTest {

  @Inject
  private ActionsController controller;

  @Inject
  private BobcatPageFactory bobcatPageFactory;

  @Inject
  private WebDriver webDriver;

  @Test
  @Story("Login to AEM and open Test page")
  @Description("Login to author instance and open test page")
  public void loginTest() throws ActionException {

    WebDriver driver = ((EventFiringWebDriver)webDriver).getWrappedDriver();

    Eyes eyes = new Eyes();
    eyes = eyesconfig.set(eyes);

    eyes.open(driver, "AEM", "Login to AEM");

    TestPage testpage = bobcatPageFactory.create("/content/we-retail/us/en.html", TestPage.class);
    controller.execute(AemActions.LOG_IN);

    eyes.check("AEM Login Page", Target.window().fully());

    assertTrue(testpage.open().isDisplayed());

    eyes.check("AEM Test Page", Target.window().fully());

    eyes.close();
  }
}
