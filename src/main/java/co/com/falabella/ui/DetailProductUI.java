package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetailProductUI {
    public static Target TXT_NAME_PRODUCT = Target.the("product name")
            .locatedBy("//h1[@class='jsx-1680787435 product-name fa--product-name false']");
    public static Target BTN_ADD_PRODUCT = Target.the("adding product")
            .located(By.id("add-to-cart-button"));
    public static Target BTN_QUANTITY = Target.the("adding quantity product")
            .locatedBy("//button[@class='jsx-152403661 increment btn-primary increment-desktop']");

    public static Target TXT_QUANTITY_PRODUCT = Target.the("quantity of products")
            .located(By.id("quantity-selector-increment-input"));

}
