package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;


public class HomeUI {
    public static Target TXT_SEARCH = Target.the("search of product")
            .locatedBy("//input[@class='SearchBar-module_searchBar__Input__1kPKS']");

    public static Target BTN_COOKIES = Target.the("acept cookies")
            .locatedBy("//button[@id='testId-accept-cookies-btn']");
}
