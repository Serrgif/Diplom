package netology.ru.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String numberCard;
    private String month;
    private String year;
    private String owner;
    private String cvv;
}
