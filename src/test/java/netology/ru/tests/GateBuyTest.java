package netology.ru.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import netology.ru.data.DataHelper;
import netology.ru.data.BDHelper;
import netology.ru.pages.PaymentMethod;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GateBuyTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080"); // Убедитесь, что это правильный URL
    }

    @AfterEach
    public void cleanBase() {
        BDHelper.clearBD();
    }

    @Story("Оплата по карте со статусом APPROVED")
    @Test
    void buyApprovedCard() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.approvedCard());
        payment.waitSuccessfullyMessage();
        assertEquals("APPROVED", BDHelper.getPaymentStatus());
    }

    @Story("Оплата по карте со статусом DECLINE")
    @Test
    void buyDeclineCard() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.approvedCard());
        payment.waitRejectedMessage();
        assertEquals("DECLINE", BDHelper.getPaymentStatus());
    }
}