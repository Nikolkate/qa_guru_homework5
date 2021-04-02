import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    private final static String REPOSITORY = "Nikolkate/java_pft";
    private final static String USER = "Nikolkate";
    private final static int ISSUE_NUMBER = 04;

    @Test
    public void testGitHub() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issue")).click();
        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        $(withText(USER)).should(Condition.exist);

    }
}
