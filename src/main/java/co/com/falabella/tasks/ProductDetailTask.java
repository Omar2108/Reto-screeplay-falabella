package co.com.falabella.tasks;

import co.com.falabella.interactions.AddQuantityProduct;
import co.com.falabella.interactions.ClickAddCart;
import co.com.falabella.utils.ProductService;
import co.com.falabella.models.Products;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Value;


import static co.com.falabella.ui.DetailProductUI.TXT_NAME_PRODUCT;
import static co.com.falabella.ui.DetailProductUI.TXT_QUANTITY_PRODUCT;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ProductDetailTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                AddQuantityProduct.click()
        );

        actor.remember("quantity", Value.of(TXT_QUANTITY_PRODUCT).asInteger());

        String name = TXT_NAME_PRODUCT.resolveFor(actor).getText();
        int quantity = actor.recall("quantity");

        Products product = Products.builder()
                .productName(name)
                .productQuantity(quantity)
                .build();

        ProductService.saveProduct(product);
        ProductService.saveProductQuestion(product);

        actor.attemptsTo(
                ClickAddCart.click()
        );



    }

    public static ProductDetailTask on(){
        return  instrumented(ProductDetailTask.class);
    }
}
