package starter.navigation;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CookieDialog {
    public static final Target ACCEPT_BUTTON = Target.the("accept the cookies")
            .locatedBy("//button[contains(.,'Accept')]");
}
