package netology.ru.pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import netology.ru.data.Card;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentBuyPage {

    private SelenideElement PaymentHeader = $$("h3").find(exactText("Оплата по карте"));

    private SelenideElement cardNumberInput = $(byText("Номер карты")).parent().$("[class=\"input__control\"]");

    private SelenideElement monthInput= $(byText("Месяц")).parent().$("[class=\"input__control\"]");
    private SelenideElement yearInput = $(byText("Год")).parent().$("[class=\"input__control\"]");

    private SelenideElement cardOwnerinput = $(byText("Владелец")).parent().$("[class=\"input__control\"]");

    private SelenideElement cvvInput = $(byText("CVC/CVV")).parent().$("[class=\"input__control\"]");

    private SelenideElement successfullyMessage = $(byText("Операция одобрена Банком.")).parent().$("[class=\"notification__content\"]");
    private SelenideElement rejectedMessage = $(byText("Ошибка! Банк отказал в проведении операции.")).parent().$("[class=\"notification__content\"]");
    private SelenideElement invalidFormatError = $(byText("Неверный формат"));

    private SelenideElement cardExpirationDateError = $(byText("Неверно указан срок действия карты"));
    private SelenideElement cardExpiredError = $(byText("Истёк срок действия карты"));

    private ElementsCollection invalidFormat4Error = $$(byText("Неверный формат"));
    private SelenideElement requiredInputError = $(byText("Поле обязательно для заполнения"));

    private SelenideElement cancelMessage = $$("[class=\"icon-button__text\"]").first();

    private SelenideElement continueButton = $$("button").find(exactText("Продолжить"));

    public PaymentBuyPage() {
        PaymentHeader.shouldBe(visible);
    }

    public void inputData(Card card) {
        cardNumberInput.setValue(card.getNumberCard());
        monthInput.setValue(card.getMonth());
        yearInput.setValue(card.getYear());
        cardOwnerinput.setValue(card.getOwner());
        cvvInput.setValue(card.getCvv());
        continueButton.click();
    }

    public void waitSuccessfullyMessage() {
        successfullyMessage.shouldBe(visible, Duration.ofSeconds(10));
        cancelMessage.click();
    }

    public void waitRejectedMessage() {
        rejectedMessage.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void waitNotificationWrongFormat() {
        invalidFormatError.shouldBe(visible, Duration.ofSeconds(7));
    }

    public void waitNotificationExpirationDateError() {
        cardExpirationDateError.shouldBe(visible, Duration.ofSeconds(7));
    }

    public void waitNotificationExpiredError() {
        cardExpiredError.shouldBe(visible, Duration.ofSeconds(7));
    }

    public void waitNotificationWrongFormat4Fields() {
        invalidFormat4Error.shouldHave(size(4));
        requiredInputError.shouldBe(visible, Duration.ofSeconds(7));
    }
    public void waitNotificationWrongField1() {
        invalidFormat4Error.first().shouldBe(visible, Duration.ofSeconds(7));
    }
    public void waitNotificationWrongField2() {
        requiredInputError.shouldBe(visible, Duration.ofSeconds(7));
    }
}