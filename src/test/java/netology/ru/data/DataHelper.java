package netology.ru.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    public static String getShiftedMonth(){
        int shift = (int) (Math.random() * 10);
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getShiftedYear(int yearCount){
        return LocalDate.now().plusYears(yearCount).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static Card approvedCard() {
        return new Card(
                "4444444444444441",
                "08",
                "25",
                "IVAN IVANOV",
                "999");
    }

    public static Card declinedCard() {
        return new Card(
                "4444444444444442",
                "08",
                "25",
                "IVAN IVANOV",
                "999");
    }

    public static Card getEmptyCard() {
        return new Card("",
                "",
                "",
                "",
                "");
    }

    public static Card getNoneCard() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444444", month, year, owner, cvv);
    }

    public static Card getCardMonth1Symbol() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = faker.number().digit();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardMonthOver12() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", "14", year, owner, cvv);
    }

    public static Card getCardMonth00() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", "00", year, owner, cvv);
    }

    public static Card getCardYear1Symbol() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = faker.number().digit();
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardYearOver5() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(6);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardYearUnder() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(-1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardYear00() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, "00", owner, cvv);
    }

    public static Card getCardCvv1Symbol() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(1);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardCvv2Symbols() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(2);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardOwner1Word() {
        Faker faker = new Faker();
        String owner = faker.name().firstName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardOwnerRu() {
        Faker faker = new Faker(new Locale("ru"));
        String owner = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardOwnerNums() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " " + faker.number().digit();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, owner, cvv);
    }

    public static Card getCardOwnerSymbols() {
        Faker faker = new Faker();
        String owner = faker.name().firstName() + " %$ * &";
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, owner, cvv);
    }



}
