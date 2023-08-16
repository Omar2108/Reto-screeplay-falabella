package co.com.falabella.questions;

import co.com.falabella.utils.ProductService;
import co.com.falabella.models.Products;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.ui.ProductsCartUI.TXT_NAME_PRODUCT_CART;

public class ValidateProductNameQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        Products product = ProductService.getProductQuestion();
        String nameProduct = product.getProductName();

        String name = TXT_NAME_PRODUCT_CART.resolveFor(actor).getText().trim();

        return nameProduct.trim().equals(name);
    }

    public static Question<Boolean> from(){
        return new ValidateProductNameQuestion();
    }
}
