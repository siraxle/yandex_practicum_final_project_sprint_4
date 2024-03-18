import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObjects.QaScooterMainPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScooterAccordionTest extends BaseTest {
    private String accordionText;
    private int elementNumber;

    public ScooterAccordionTest(int elementNumber, String accordionText) {
        this.elementNumber = elementNumber;
        this.accordionText = accordionText;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTexts() {
        return Arrays.asList(new Object[][]{
                {4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."}
        });
    }


    @Test
    public void textsTest() {
        QaScooterMainPage qaScooterMainPage = new QaScooterMainPage(driver);
        qaScooterMainPage.clickCookieBtnClose();
        qaScooterMainPage.scrollPageToEndOfList();
        qaScooterMainPage.clickOnAccordionElement(elementNumber-1);
        String actualText = qaScooterMainPage.getAnswerFromAccordionElement(elementNumber-1);
        assertEquals("Текст элемента аккордеона не соответствует ожидаемому", accordionText, actualText);
    }

}
