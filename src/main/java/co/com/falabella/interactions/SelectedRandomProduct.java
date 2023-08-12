package co.com.falabella.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.Random;

import static co.com.falabella.ui.ProductsCatalogUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectedRandomProduct implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listLink = LINK_PRODUCT.resolveAllFor(actor);

        Random random = new Random();
        int index = random.nextInt(listLink.size());

        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].scrollIntoView();", listLink.get(index));
        listLink.get(index).click();

    }

    public static Performable click(){
        return instrumented(SelectedRandomProduct.class);
    }
}
