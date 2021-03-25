import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement senderCountField = $("[data-test-id=from] input");
    private SelenideElement recipientCountField = $("[data-test-id=to] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public PrivateOfficePage transfer(String count){
        amountField.setValue(count);
        senderCountField.setValue("5559000000000001");
        transferButton.click();

        return new PrivateOfficePage();
    }

}
