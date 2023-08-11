package co.com.falabella.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.tasks.ProductDetailTask.nameProduct;
import static co.com.falabella.ui.ProductsCartUI.TXT_NAME_PRODUCT_CART;

public class ValidateProductNameQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return nameProduct.equals(TXT_NAME_PRODUCT_CART.resolveFor(actor).getText());
    }

    public static Question<Boolean> from(){
        return new ValidateProductNameQuestion();
    }
}
