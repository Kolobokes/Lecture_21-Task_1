package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import java.lang.reflect.Array;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PrivateOfficePage {
    private String cardInfo;
    private ElementsCollection replenishButtons = $$("[data-test-id=action-deposit]");
    private ElementsCollection cards = $$(".list__item");

    public int checkCardBalance(String cardNumber) {

        if (cardNumber == "001") {
            cardInfo = cards.get(0).text();
        }
        else if (cardNumber == "002") {
            cardInfo = cards.get(0).text();;
        }

        String balanceStart = "баланс: ";
        String balanceFinish = " р.";

        val start = cardInfo.indexOf(balanceStart);
        val finish = cardInfo.indexOf(balanceFinish);
        val value = cardInfo.substring(start + balanceStart.length(), finish);

        return Integer.parseInt(value);
    }

    public TransferPage transferMoney(String cardNumber){

        if (cardNumber == "001")
           replenishButtons.get(0).click();
        else if (cardNumber == "002")
            replenishButtons.get(1).click();

        return new TransferPage();
    }
}
