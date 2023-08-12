package co.com.falabella.stepDefinitions;

import co.com.falabella.questions.ValidateProductNameQuestion;
import co.com.falabella.questions.ValidateProductQuantityQuestion;
import co.com.falabella.tasks.*;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AddProductoToCartStepDef {
    @CastMember
    Actor user;

    @Given("the user opens the falabella page and searches for a product")
    public void theUserOpensTheFalabellaPageAndSearchesForAProduct() {
        user.attemptsTo(
                OpenPage.open(),
                HomeTask.search()
        );
    }
    @When("the user adds the product to the shopping cart")
    public void theUserAddsTheProductToTheShoppingCart() {

        user.attemptsTo(
                ProductsCatalogTask.on(),
                ProductDetailTask.on(),
                ConfirmacionAddProductTask.click()
        );
    }
    @Then("The user will be able to see the product and the quantity selected in the shopping cart.")
    public void theUserWillBeAbleToSeeTheProductAndTheQuantitySelectedInTheShoppingCart() {

        user.should(
                seeThat(
                        ValidateProductNameQuestion.from(), Matchers.equalTo(true)
                ),
                seeThat(
                        ValidateProductQuantityQuestion.from(), Matchers.equalTo(true)
                )
        );
    }

}
