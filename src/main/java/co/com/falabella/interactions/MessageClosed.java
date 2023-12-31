package co.com.falabella.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

import static co.com.falabella.ui.HomeUI.BTN_COOKIES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MessageClosed implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].click()", BTN_COOKIES.resolveFor(actor));

        js.executeScript("document.getElementsByClassName('airship-html-prompt-shadow')[0].shadowRoot.querySelector('button').click()");
    }

    public static Performable click(){
        return instrumented(MessageClosed.class);
    }
}
