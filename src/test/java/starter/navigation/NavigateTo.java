package starter.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.WebDriver;

public class NavigateTo {
    public static Performable theWikipediaHomePage() {
        return Task.where("{0} opens the Wikipedia home page",
                Open.browserOn().the(WikipediaHomePage.class));
    }


    public static Performable theEtsySearchPage() {
        return Task.where("{0} opens the etsy search page",
                Open.url("https://www.etsy.com/uk/"),
                Click.on(CookieDialog.ACCEPT_BUTTON));

    }

    public static Performable containingTheCardDetail() {
        return Task.where("{0} switches to the tab with the card details",
                actor -> actor.attemptsTo(Switch.toWindow(otherWindowVisibleTo(actor))));
    }

    private static String otherWindowVisibleTo(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String currentWindowHandle = driver.getWindowHandle();

        return driver.getWindowHandles().stream().filter(
                windowHandle -> !windowHandle.equals(currentWindowHandle))
                .findFirst().orElseThrow(NoBrowserTabWasFoundException::new);

    }
}

