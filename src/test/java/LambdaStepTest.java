import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

    private final static String REPOSITORY = "Nikolkate/java_pft";
    private final static String USER = "Nikolkate";
    private final static int ISSUE_NUMBER = 04;

    @Test
    public void searchIssue(){

        step("Открываем главную репозитория", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Проверям наличие номера " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
        step("Проверяем наличие юзера " + USER, () -> {
            $(withText(USER)).should(Condition.exist);
        });
    }
}
