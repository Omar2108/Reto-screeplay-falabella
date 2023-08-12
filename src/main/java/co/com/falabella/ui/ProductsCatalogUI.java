package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsCatalogUI {

    public static Target LINK_PRODUCT = Target.the("details product")
            .locatedBy("//a[contains(@class,'pod-link')]");



}
