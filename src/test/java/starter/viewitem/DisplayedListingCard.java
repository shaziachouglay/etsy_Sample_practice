package starter.viewitem;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.List;

public class DisplayedListingCard {
    public static Question<List<ListingCard>> details() {
        return Question.about("displayed item details")
                .answeredBy(
                        actor -> BrowseTheWeb.as(actor)
                        .findAll(By.cssSelector("a.organic-impression"))
                        .map(element-> new ListingCard(element.getAttribute("title"),
                                element.getAttribute("data-listing-id")))
                );
    }
}
