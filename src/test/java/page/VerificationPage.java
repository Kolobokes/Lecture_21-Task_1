package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import page.PrivateOfficePage;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField =$("[data-test-id=code] input");
    private SelenideElement verificationButton =$("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(Condition.visible);
    }

    public PrivateOfficePage validVerify(DataHelper.VerificationCode verificationCode){
        codeField.setValue(verificationCode.getCode());
        verificationButton.click();

        return new PrivateOfficePage();
    }

}
