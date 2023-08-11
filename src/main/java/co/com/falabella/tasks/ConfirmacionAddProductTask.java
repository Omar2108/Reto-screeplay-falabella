package co.com.falabella.tasks;

import co.com.falabella.interactions.ClickConfirmation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmacionAddProductTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickConfirmation.click()
        );
    }
    public static ConfirmacionAddProductTask click(){
        return  instrumented(ConfirmacionAddProductTask.class);
    }
}
