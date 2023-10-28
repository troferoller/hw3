


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class homework {
    @BeforeAll
    static void configs(){
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("troferoller").pressEnter();
        $("[id=lastName]").setValue("uh?").pressEnter();
        $("[id=userEmail]").setValue("gavgav@dsas.com").pressEnter();
        $("[id=userNumber]").setValue("8765432101").pressEnter();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[for=gender-radio-1]").click();
        $("[id=currentAddress]").setValue("novogireevo").pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Noida").pressEnter();
        $("[id=submit]").click();
        }
    }