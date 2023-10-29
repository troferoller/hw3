


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void configs(){
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

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
        $x("//td[text()='Student Name']/following::td[text()='troferoller uh?']").shouldBe(visible);
        $x("//td[text()='Student Email']/following::td[text()='gavgav@dsas.com']").shouldBe(visible);
        $x("//td[text()='Gender']/following::td[text()='Male']").shouldBe(visible);
        $x("//td[text()='Mobile']/following::td[text()='8765432101']").shouldBe(visible);
        $x("//td[text()='Date of Birth']/following::td[text()='28 September,2010']").shouldBe(visible);
        $x("//td[text()='Subjects']/following::td[text()='English']").shouldBe(visible);
        $x("//td[text()='Hobbies']/following::td[text()='Music']").shouldBe(visible);
        $x("//td[text()='Picture']/following::td[text()='1.jpg']").shouldBe(visible);
        $x("//td[text()='Address']/following::td[text()='first place to see']").shouldBe(visible);
        $x("//td[text()='State and City']/following::td[text()='NCR Noida']").shouldBe(visible);
        }
    }