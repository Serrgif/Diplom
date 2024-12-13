package netology.ru.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import netology.ru.data.DataHelper;
import netology.ru.data.BDHelper;
import netology.ru.pages.PaymentMethod;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
@Feature("Оплата тура по карте")
public class PaymentBuyTest {
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

    @Story("Пустые поля при оплате")
    @Test
    void buyNotificationEmpty() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getEmptyCard());
        payment.waitNotificationWrongFormat4Fields();
        assertEquals("0", BDHelper.getOrderCount());
    }

    @Story("Оплата по несуществующей в БД карте")
    @Test
    void buyCardNotInDB() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getNoneCard());
        payment.waitRejectedMessage();
        assertEquals("0", BDHelper.getOrderCount());
    }

    @Story("Некорректный ввод месяца (1 символ)")
    @Test
    void buy1SymbolMonth() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardMonth1Symbol());
        payment.waitNotificationWrongFormat();
        assertEquals("0", BDHelper.getOrderCount());
    }
    @Story("Некорректный ввод месяца (> 12)")
    @Test
    void buyOver12Month() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthOver12());
        payment.waitNotificationExpirationDateError();
        assertEquals("0", BDHelper.getOrderCount());
    }
    @Story("Некорректный ввод месяца (00)")
    @Test
    void buy00Month() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardMonth00());
        payment.waitNotificationExpirationDateError();
        assertEquals("0", BDHelper.getOrderCount());
    }

    @Story("Некорректный ввод года (00)")
    @Test
    void buyYear00() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardYear00());
        payment.waitNotificationExpiredError();
        assertEquals("0", BDHelper.getOrderCount());
    }

    @Story("Некорректный ввод года (1 цифра)")
    @Test
    void buyYear1Symbol() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardYear1Symbol());
        payment.waitNotificationWrongFormat();
        assertEquals("0", BDHelper.getOrderCount());
    }

    @Story("Некорректный ввод года (меньше текущего)")
    @Test
    void buyYearUnder() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardYearUnder());
        payment.waitNotificationExpiredError();
        assertEquals("0", BDHelper.getOrderCount());
    }
    @Story("Некорректный ввод года (больше текущего более чем на 5)")
    @Test
    void buyYearOver5() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardYearOver5());
        payment.waitNotificationExpirationDateError();
        assertEquals("0", BDHelper.getOrderCount());
    }

    @Story("Некорректный ввод CVV (1 цифра)")
    @Test
    void buyCvv1Symbol() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardCvv1Symbol());
        payment.waitNotificationWrongFormat();
        assertEquals("0", BDHelper.getOrderCount());
    }
    @Story("Некорректный ввод CVV (2 цифры)")
    @Test
    void buyCvv2Symbols() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardCvv2Symbols());
        payment.waitNotificationWrongFormat();
        assertEquals("0", BDHelper.getOrderCount());
    }
    @Story("Некорректный ввод Владельца (1 слово)")
    @Test
    void buyOwner1Word() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardOwner1Word());
        payment.waitNotificationWrongFormat();
        assertEquals("0", BDHelper.getOrderCount());
    }
    @Story("Некорректный ввод Владельца (русские буквы)")
    @Test
    void buyOwnerRu() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardOwnerRu());
        payment.waitNotificationWrongFormat();
        assertEquals("0", BDHelper.getOrderCount());
    }
    @Story("Некорректный ввод Владельца (цифрами)")
    @Test
    void buyOwnerNums() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardOwnerNums());
        payment.waitNotificationWrongFormat();
        assertEquals("0", BDHelper.getOrderCount());
    }
    @Story("Некорректный ввод Владельца (недопустимые символы)")
    @Test
    void buyOwnerSpecialSymbols() {
        val startPage = new PaymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardOwnerSymbols());
        payment.waitNotificationWrongFormat();
        assertEquals("0", BDHelper.getOrderCount());
    }



}