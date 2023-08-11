package co.com.falabella.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;

import static co.com.falabella.ui.DetailProductUI.BTN_ADD_PRODUCT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickAddCart implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElementFacade linkProduct = BTN_ADD_PRODUCT.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor)BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].click()", linkProduct );
    }

    public static Performable click(){
        return instrumented(ClickAddCart.class);
    }
}
