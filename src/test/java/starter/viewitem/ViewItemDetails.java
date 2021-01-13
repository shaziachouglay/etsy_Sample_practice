package starter.viewitem;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import starter.navigation.NavigateTo;

import java.util.List;

public class ViewItemDetails implements Performable {
    private final Target LISTING_CARD = Target.the("listing card with id {0}")
            .locatedBy("//a[@data-listing-id='{0}']");

    public static Performable forOneOfTheItems() {
        return new ViewItemDetails();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<ListingCard> listingCards = actor.asksFor(DisplayedListingCard.details());
        ListingCard selectedItem = randomItemFrom(listingCards);
        System.out.println("SELECTED ITEM"+selectedItem.getTitle());
        actor.remember("SELECTED_TITLE",selectedItem);
        actor.attemptsTo(Click.on(LISTING_CARD.of(selectedItem.getDataListingId())),
                NavigateTo.containingTheCardDetail());
    }

    private ListingCard randomItemFrom(List<ListingCard> itemDetails) {
        int maxItem = Math.min(10,itemDetails.size());
        int chosenTitle = (int) (Math.random() * maxItem);
        return itemDetails.get(chosenTitle);
    }
}
