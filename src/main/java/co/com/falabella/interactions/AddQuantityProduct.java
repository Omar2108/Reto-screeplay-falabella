package co.com.falabella.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static co.com.falabella.ui.DetailProductUI.BTN_QUANTITY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddQuantityProduct implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade btnquantity = BTN_QUANTITY.resolveFor(actor);

        for (int i = 1; i < 3; i++) {
            btnquantity.click();
        }
    }

    public static Performable click(){
        return instrumented(AddQuantityProduct.class);
    }
}
