package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppIbantTest {

    @Test
    void correctAuthorizationTest(){

        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);

        verificationPage.validVerify(verificationCode);
    }

    @Test
    void remittanceTest(){

        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);

        val privateOfficePage= verificationPage.validVerify(verificationCode);
        val transferPage = privateOfficePage.transferMoney("001");
        transferPage.transfer("100", DataHelper.senderCount());
    }

    @Test
    void checkCardBalanceTest(){

        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);

        val privateOfficePage= verificationPage.validVerify(verificationCode);

        int cardBalanceBeforeTransaction = privateOfficePage.checkCardBalance("001");
        int cardBalanceAfterTransactionExpected = cardBalanceBeforeTransaction + 100;

        val transferPage = privateOfficePage.transferMoney("001");
        transferPage.transfer("100", DataHelper.senderCount());

        int cardBalanceAfterTransactionActual = privateOfficePage.checkCardBalance("001");

        assertEquals(cardBalanceAfterTransactionExpected, cardBalanceAfterTransactionActual);
    }
}
