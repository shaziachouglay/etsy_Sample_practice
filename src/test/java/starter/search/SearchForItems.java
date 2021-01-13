package starter.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class SearchForItems {
    public static Performable withKeyword(String keyword) {
        return Task.where("{0} searches for "+keyword,
                Enter.theValue(keyword).into(SearchBar.SEARCH_FIELD)
        .thenHit(Keys.ENTER));

    }
}
