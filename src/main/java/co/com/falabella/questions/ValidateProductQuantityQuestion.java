package co.com.falabella.questions;

import co.com.falabella.utils.ProductService;
import co.com.falabella.models.Products;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

import static co.com.falabella.ui.ProductsCartUI.TXT_QUANTITY_PRODUCT_CART;

public class ValidateProductQuantityQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        Products product = ProductService.getProductQuestion();
        Integer quantity = product.getProductQuantity();

        actor.remember("cart_quantity", Value.of(TXT_QUANTITY_PRODUCT_CART).asString());
       String quanti = actor.recall("cart_quantity");

        return quantity.toString().trim().equals(quanti);
    }

    public static Question<Boolean> from(){
        return new ValidateProductQuantityQuestion();
    }
}
