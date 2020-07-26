package com.cognifide.qa.bb.aem.tests.pages;

import com.cognifide.qa.bb.page.Page;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.cognifide.qa.bb.wait.BobcatWait;

@PageObject
public class ProductionPage extends Page<ProductionPage> {

  @Inject
  private BobcatWait bobcatWait;

  private String title = "PERSONAL BANKING | PNC";

  public String getTitle() {
    return title;
  }

  @FindBy(css="#mostViewedTout-container > div > div.tout-5.most-viewed-tout.swiper-slide.swiper-no-swiping > div > a")
  private WebElement iraLink;

  public void clickIRA() {
    iraLink.click();
  }

  public boolean isDisplayed() {
    return bobcatWait.isConditionMet(ExpectedConditions.titleIs(getTitle()));
  }
}
