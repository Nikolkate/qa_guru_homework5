import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @Test
    void registrationFormTests() {

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Kate");

        $("#lastName").setValue("Eremeeva");

        $("#userEmail").setValue("test.test.ru");

        $(by("for", "gender-radio-2")).click();;

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();//поискать инфу с календарем
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--021").click();


        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        sleep(1000);

        $(by("for", "hobbies-checkbox-1")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/photo_2020-04-30_18-23-07.jpg")); //как выбрать файл

        $("#currentAddress").scrollTo().setValue("St.Petersburg");

        $(byText("Select State")).click();
        $(byText("Rajasthan")).click();

        $(byText("Select City")).click();
        $(byText("Jaipur")).click();

        $("#submit").click();

        $("#firstName").shouldHave(value("Kate"));
        $("#firstName").shouldHave(value("Kate"));
    }
}
