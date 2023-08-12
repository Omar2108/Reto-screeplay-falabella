package co.com.falabella.tasks;

import co.com.falabella.interactions.AddQuantityProduct;
import co.com.falabella.interactions.ClickAddCart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


import static co.com.falabella.ui.DetailProductUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ProductDetailTask implements Task {

    public static String nameProduct;
    public static String quantityProduct;
    @Override
    public <T extends Actor> void performAs(T actor) {

        nameProduct= TXT_NAME_PRODUCT.resolveFor(actor).getText();
        quantityProduct= TXT_QUANTITY_PRODUCT.resolveFor(actor).getText();

        actor.attemptsTo(
                AddQuantityProduct.click(),
                ClickAddCart.click()
        );

    }

    public static ProductDetailTask on(){
        return  instrumented(ProductDetailTask.class);
    }
}
