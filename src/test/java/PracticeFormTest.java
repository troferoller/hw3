


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void configs(){
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //Выключение рекламы
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //Тело программы
        $("[id=firstName]").setValue("troferoller").pressEnter();
        $("[id=lastName]").setValue("uh?").pressEnter();
        $("[id=userEmail]").setValue("gavgav@dsas.com").pressEnter();
        $("[id=userNumber]").setValue("8765432101").pressEnter();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=subjectsInput]").setValue("History").pressEnter();
        $("[for=gender-radio-1]").click();
        $("[id=currentAddress]").setValue("first place to see");
        $("[for=hobbies-checkbox-3]").click();
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Noida").pressEnter();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2010");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
        $("[id=submit]").click();
        //Проверка
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("troferoller uh?"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("gavgav@dsas.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8765432101"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("8 September,2010"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English, History"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("first place to see"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
        }
    }