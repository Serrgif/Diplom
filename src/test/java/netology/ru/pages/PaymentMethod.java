package netology.ru.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentMethod {
    private SelenideElement heading = $$("h2").find(Condition.text("Путешествие дня"));
    private SelenideElement buyButton = $$("button").find(exactText("Купить"));
    private SelenideElement creditButton = $$("button").find(exactText("Купить в кредит"));

    public PaymentMethod() {
        heading.shouldBe(visible);
    }

    public PaymentBuyPage goToBuyPage() {
        buyButton.click();
        return new PaymentBuyPage();
    }

    public CreditBuyPage goToCreditPage() {
        creditButton.click();
        return new CreditBuyPage();
    }
}
