import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTests {

    @Test
    void selenideSearchTests() {
        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиска
        $(byName("q")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(Condition.text("selenide.org"));
    }

    @Test
        void selenideSearchTest() {
            // Открыть yandex
            open("https://yandex.ru");

            // Ввести Selenide в поиска
            $(byName("text")).setValue("Selenide").pressEnter();

            // Проверить, что Selenide появился в результатах поиска
            $("html").shouldHave(Condition.text("selenide.org"));


        }
}

