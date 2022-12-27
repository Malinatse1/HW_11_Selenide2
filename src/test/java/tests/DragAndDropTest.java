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
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class DragAndDropTest {
    @Test
    @DisplayName("Проверка что прямоугольники поменялись местами")
    @Tag("Позитивный кейс")
    public void testCheckMoveRectangle() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу Drag&Drop", () ->
        {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });

        step("Перенесите прямоугольник А на место В", () -> {
            $("#column-a").dragAndDropTo($("#column-b"));
        });

        step ("Проверка что прямоугольники переместились",() -> {
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        });
    }
}
