import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Array;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PrivateOfficePage {
    private SelenideElement replenishButtons = $$("[data-test-id=action-deposit]");

    public SelenideElement successfulAuthorization(){

        SelenideElement listOfCards = $(withText("Ваши карты"));

        return listOfCards;
    }

    public int cardBalance(String cardNumber) {
        SelenideElement cardInfo =$(withText("cardNumber"));
        cardInfo.text();

        return 1;

    }
}
