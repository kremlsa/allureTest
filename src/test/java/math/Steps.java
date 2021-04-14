package math;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Steps {

    @Step
    public static void checkSumStep(int num1, int num2, int expectedSum) {
        Assert.assertTrue( num1 + num2 == expectedSum);
    }

    @Step("Проверка разности числа {num1} и числа {num2}")
    public static void checkSubtractionStep(int num1, int num2, int expectedResult) {
        Assert.assertTrue(num1 - num2 == expectedResult);
    }

    @Step("Проверка эквивалентности строки {str1} строке {str2}")
    public static void checkStringEqualsStep(String str1, String str2) throws IOException {
        Assert.assertTrue( str1.equals(str2));
        getBytesAnnotationWithArgs("text.txt");
    }

    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    public static byte[] getBytesAnnotationWithArgs(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }
}
