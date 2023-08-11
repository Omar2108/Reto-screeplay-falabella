package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsCartUI {

    public static Target TXT_NAME_PRODUCT_CART = Target.the("name product cart")
            .locatedBy("//a[@class='chakra-link css-qpfo7l']");

    public static Target TXT_QUANTITY_PRODUCT_CART = Target.the("queantity of product in cart")
            .locatedBy("//input[@class='chakra-input css-1k2vvg6']");
}
