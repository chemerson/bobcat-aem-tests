package com.cognifide.qa.bb.aem.tests.siteadmin;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cognifide.qa.bb.RunWithJunit5;
import com.cognifide.qa.bb.aem.core.pages.AemPageManipulationException;
import com.cognifide.qa.bb.aem.core.pages.AemTestPageControler;
import com.cognifide.qa.bb.aem.core.pages.sling.SlingTestPageData;
import com.cognifide.qa.bb.aem.tests.AbstractAemAuthorTest;
import com.cognifide.qa.bb.aem.tests.GuiceModule;
import com.cognifide.qa.bb.aem.tests.pages.SitesPage;
import com.cognifide.qa.bb.aem.tests.pages.TestPage;
import com.cognifide.qa.bb.junit5.guice.Modules;
import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.google.inject.Inject;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

@RunWithJunit5
@Modules(GuiceModule.class)
@Epic("AEM 6.4 Base Tests")
@Feature("Site Admin Tests")
public class SiteAdminControllerTest extends AbstractAemAuthorTest {

  private final static String PAGE_TO_CREATE_NAME = "siteadmintestpage";

  private static final String FULL_PAGE_PATH = "/content/we-retail/us/en/" + PAGE_TO_CREATE_NAME;

  private static final String SITES_PAGE_PATH = "/sites.html/content/we-retail/us/en";

  @Inject
  private AemTestPageControler aemTestPageControler;

  @Inject
  private BobcatPageFactory bobcatPageFactory;

  @Test
  @Story("Create test page from sites.html")
  @Description("Create test page using create action from site admin")
  public void createPageActionTest() {
    SitesPage sitesPage = bobcatPageFactory.create(SITES_PAGE_PATH, SitesPage.class);
    sitesPage.open().createPage(PAGE_TO_CREATE_NAME);
    TestPage testPage = bobcatPageFactory.create(FULL_PAGE_PATH, TestPage.class);
    assertTrue(testPage.open().isDisplayed());
  }

  @AfterEach
  public void deleteTestPage() throws AemPageManipulationException {
    aemTestPageControler.deleteTestPage(new SlingTestPageData(FULL_PAGE_PATH, null));
  }
}
