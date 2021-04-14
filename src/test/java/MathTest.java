import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import static math.Steps.*;

public class MathTest {
    @Test
    public void simpleTest2() {
        checkSumStep(3, 2, 5);
        checkSumStep(5, 4, 9);
    }

    @Test
    public void simpleTest3() {
        checkSubtractionStep(5, 2, 3);
    }

    @Test
    @Description(value = "Тест проверяет эквивалентность единицы единице")
    public void simpleTest7_1() {
        Assert.assertTrue(1 == 1);
    }

    @Epic(value = "Математика")
    @Feature(value = "Простые математические операции")
    @Story(value = "Сложение")
    @Test
    public void sumTest() {
        checkSumStep(5, 4, 9);
    }

    @Epic(value = "Математика")
    @Feature(value = "Простые математические операции")
    @Story(value = "Вычитание")
    @Test
    public void subTest() {
        checkSubtractionStep(8, 2, 6);
    }

    @Epics(value = {@Epic(value = "Математика"), @Epic(value = "Геометрия")})
    @Features(value = {@Feature(value = "Тригонометрия"), @Feature(value = "Простые математические операции")})
    @Stories(value = {@Story(value = "Синус"), @Story(value = "Синусоида")})
    @Test
    public void checkSinTest() {
        checkSumStep(5, 4, 9);
    }

    @Test
    @Flaky
    public void testDemoFlaky() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomNum == 0) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    @Issue(value = "FGY-4627")
    @TmsLinks({@TmsLink(value = "TL-135"), @TmsLink(value = "TL-158")})
    public void simpleTest15() {
        Assert.assertTrue(1 == 1);
    }

    @Test
    @TmsLink(value = "TL-678")
    public void simpleTest18() {
        Assert.assertTrue(1 == 1);
    }

    @Test
    @Link(name = "Ссылка", url = "http://yandex.ru")
    public void checkSubtractionWithLinkTest() {
        checkSubtractionStep(15, 5, 10);
    }

    @Test
    @Links(value = {@Link(name = "Ссылка1", url = "http://sberbank.ru"),
            @Link(name = "Ссылка2", url = "http://yandex.ru")})
    public void checkSubtractionWithLinksTest() {
        checkSubtractionStep(14, 5, 9);
    }

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    public void testDemoSeverity() {
        checkSubtractionStep(6, 1, 5);
    }

    @Test
    public void testJson() {
        try {
            checkStringEqualsStep("test", "test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
