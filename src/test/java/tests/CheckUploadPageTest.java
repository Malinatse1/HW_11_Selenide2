package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class CheckUploadPageTest {
    @Test
    @DisplayName("Проверка что загрузилась нужная страница с заголовком 'Build like the best'")
    @Tag("Позитивный кейс")
    public void TestCheckTitle(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу Github",() ->
        {open("https://github.com/");
        });

        step ("Выбрать меню Solutions - Enterprize",() -> {
            $(byText("Solutions")).hover();
            $(linkText("Enterprise")).click();
            $(".application-main").shouldBe(visible, Duration.ofSeconds(30));
        });

        step ("Проверка что загрузилась нужная страница с заголовком 'Build like the best'",() -> {
            $(".application-main").shouldHave(text("Build like the best"));
        });
    }
}

