package starter.search;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBar {
    public static final Target SEARCH_FIELD = Target.the("search field")
            .locatedBy("//input[@name='search_query']");
}
