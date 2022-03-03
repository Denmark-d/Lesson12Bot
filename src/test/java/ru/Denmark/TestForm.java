package ru.Denmark;

import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestForm extends TestBase {

    @Test
    @Owner("Daniia")
    @DisplayName("заполнение формы")
    @Tag("1.1")
    @Step("открываем страницу https://demoqa.com/automation-practice-form")
    void firstTest() {
        System.out.println("First Test");
        step("Открываем страницу", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        step("Проверяем наименование формы", () -> {
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));;
        });
        step("Заполняем форму", () -> {
            $("#firstName").setValue("Danny");
            $("#lastName").setValue("Dan");
            $("#userEmail").setValue("Danny@mail.ru");
            $("[for='gender-radio-2']").click();
            $("#userNumber").setValue("89371703123");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("1988");
            $(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("history").pressEnter();
            $("[for='hobbies-checkbox-1']").click();
            //$("#uploadPicture").uploadFromClasspath("custom/1 .png");
            $("#currentAddress").setValue("Наметкина");
            //$("#state").scrollTo().click();
            //$(".stateCity-wrapper").$(byText("Uttar Pradesh")).click();
            //$("#city").click();
            //$(".stateCity-wrapper").$(byText("Lucknow")).click();
            $("#submit").scrollTo().click();
            $(".table table-dark table-striped table-bordered table-hover").isDisplayed();
        });

        /*step("Проверяем заполненную форму", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Danny Dan"), text("Danny@mail.ru"));
            $(".table-responsive").shouldHave(text("8937170312"), text("29 July,1988"), text("history"),
                    text("Наметкина"), text("Uttar Pradesh Lucknow"));
        });*/

    }

    @Test
    @Owner("Daniia")
    @DisplayName("Проверка наименования на форме")
    @Tag("1.2")
    void checkRegFormName() {
        System.out.println("First Test");
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    @Test
    @Owner("Daniia")
    @Disabled
    @DisplayName("Игнорируем тест")
    @Tag("1.3")
    void checkRegFormName1() {
        System.out.println("First Test");
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }


}
