package co.com.falabella.tasks;

import co.com.falabella.interactions.AceptCookies;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.Keys;
import co.com.falabella.utils.Data;

import static co.com.falabella.ui.HomeUI.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomeTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                AceptCookies.click(),
                Enter.theValue(Data.extractTo().get(0).get("Search")).into(TXT_SEARCH).thenHit(Keys.ENTER)
        );
    }

    public static HomeTask search(){
        return  instrumented(HomeTask.class);
    }
}
