import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTest {

    private final static String REPOSITORY = "Nikolkate/java_pft";
    private final static String USER = "Nikolkate";
    private final static int ISSUE_NUMBER = 04;

    @Test
    public void searchIssue(){

        BaseSteps steps = new BaseSteps();

        steps.openMainPage();
        steps.findRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToIssue();
        steps.checkIssueNumber(ISSUE_NUMBER);
        steps.checkUserName(USER);
    }

    public static class BaseSteps {

        @Step("Открываем главную репозитория")
        public void openMainPage() {
            open("https://github.com");
        }

        @Step("Ищем репозиторий ${name}")
        public void findRepository(final String name) {

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(name);
            $(".header-search-input").submit();
        }

        @Step("Переходим в репозиторий ${name}")
        public void goToRepository(final String name) {
            $(By.linkText(name)).click();
        }

        @Step("Переходим в раздел Issues")
        public void goToIssue(){
            $(withText("Issues")).click();
        }

        @Step("Проверяем наличие юзера ${number}")
        public void checkIssueNumber(final int number) {
            $(withText("#" + number)).should(Condition.exist);
        }

        @Step("Переходим в раздел Issues ${user_name}")
        public void checkUserName(final String user_name) {
            $(withText(user_name)).should(Condition.exist);
        }
    }
}
