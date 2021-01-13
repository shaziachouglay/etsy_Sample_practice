package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import starter.navigation.NavigateTo;
import starter.search.SearchForItems;
import starter.viewitem.DisplayedItems;
import starter.viewitem.ItemDetailsPage;
import starter.viewitem.ListingCard;
import starter.viewitem.ViewItemDetails;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchByKeywordStepDefinitions {
    @Given("^(.*) is searching for product on Etsy$")
    public void sharonIsSearchingForProductOnEtsy(String actorName) {
        OnStage.theActorCalled(actorName).attemptsTo(
                NavigateTo.theEtsySearchPage()
        );
    }

    @When("^(.*) searches for '(.*)'$")
    public void sheSearchesForMasks(String actorName, String keyword) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SearchForItems.withKeyword(keyword)
        );
    }

    @Then("^she should only see products related to '(.*)'$")
    public void sheShouldOnlySeeProductsRelatedToMask(String keyword) {
        List<String> displayedDescriptions =
                OnStage.theActorInTheSpotlight().asksFor(DisplayedItems.descriptions());

        assertThat(displayedDescriptions).allMatch(
                description -> description.toLowerCase().contains(keyword.toLowerCase())
        );

    }

    @Given("^(.*) performed a search for '(.*)'$")
    public void sharonPerformedASearchForMask(String actorName, String keyword) {
        OnStage.theActorCalled(actorName).attemptsTo(NavigateTo.theEtsySearchPage(),
                SearchForItems.withKeyword(keyword));
    }

    @When("she views the details of listed item")
    public void sheViewsTheDetailsOfListedItem() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ViewItemDetails.forOneOfTheItems()
        );
    }

    @Then("the correct details for the listed item should be displayed")
    public void theCorrectDetailsForTheListedItemShouldBeDisplayed() {
        Actor actor = OnStage.theActorInTheSpotlight();
        ListingCard selectedItemDetails = actor.recall("SELECTED_TITLE");

        actor.should(seeThat(WebElementQuestion.the(ItemDetailsPage.ITEM_TITLE),
                WebElementStateMatchers.containsText(selectedItemDetails.getTitle())));
    }
}
