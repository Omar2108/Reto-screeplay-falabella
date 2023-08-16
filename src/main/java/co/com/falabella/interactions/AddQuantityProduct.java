package co.com.falabella.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.Random;

import static co.com.falabella.ui.DetailProductUI.BTN_QUANTITY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddQuantityProduct implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade btnquantity = BTN_QUANTITY.resolveFor(actor);

        Random random = new Random();
        int index = random.nextInt(3);
        for (int i = 1; i < index; i++) {
            btnquantity.click();
        }
    }

    public static Performable click(){
        return instrumented(AddQuantityProduct.class);
    }
}
