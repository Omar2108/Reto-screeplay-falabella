package co.com.falabella.tasks;

import co.com.falabella.interactions.SelectedRandomProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProductsCatalogTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SelectedRandomProduct.click()
        );
    }

    public static ProductsCatalogTask on(){
        return instrumented(ProductsCatalogTask.class);
    }
}
