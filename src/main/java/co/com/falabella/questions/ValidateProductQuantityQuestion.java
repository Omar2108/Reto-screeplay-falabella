package co.com.falabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.tasks.ProductDetailTask.quantityProduct;
import static co.com.falabella.ui.ProductsCartUI.TXT_QUANTITY_PRODUCT_CART;

public class ValidateProductQuantityQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        return quantityProduct.equals(TXT_QUANTITY_PRODUCT_CART.resolveFor(actor).getText());
    }

    public static Question<Boolean> from(){
        return new ValidateProductQuantityQuestion();
    }
}
