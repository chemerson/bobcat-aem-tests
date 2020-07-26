package com.cognifide.qa.bb.aem.tests;

import com.cognifide.qa.bb.aem.tests.pageobjects.TextComponent;
import com.cognifide.qa.bb.aem.tests.pageobjects.TextComponentImpl;
import com.cognifide.qa.bb.provider.selenium.webdriver.modifiers.webdriver.WebDriverModifier;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * Your Guice module.
 * <p/>
 * The two modules that are installed here are probably the minimum that you'll want to have in your
 * project.
 * <p/>
 * CoreModule -- all core functionality, like scope PageObjects or FrameSwitcher. ReporterModule --
 * reporting functionality, including reporting rule and HTML report.
 */
public class GuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TextComponent.class).to(TextComponentImpl.class);

    Multibinder<WebDriverModifier> webDriverModifiers = Multibinder.newSetBinder(binder(), WebDriverModifier.class);

  }
}
