package co.com.falabella.tasks;

import co.com.falabella.interactions.MessageClosed;
import co.com.falabella.utils.ProductService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.com.falabella.ui.HomeUI.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomeTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                MessageClosed.click(),
                Enter.theValue(ProductService.getSearchProduct()).into(TXT_SEARCH).thenHit(Keys.ENTER)
        );
    }

    public static HomeTask search(){
        return  instrumented(HomeTask.class);
    }
}
