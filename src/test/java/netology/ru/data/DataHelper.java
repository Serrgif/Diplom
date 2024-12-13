package netology.ru.data;

public class DataHelper {

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

}
