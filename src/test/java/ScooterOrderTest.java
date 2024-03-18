import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObjects.ConfirmationPage;
import pageObjects.OrderAboutRentPage;
import pageObjects.OrderFioAddressPhonePage;
import pageObjects.QaScooterMainPage;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends BaseTest {

    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String phone;
    private String date;
    private String comment;
    private int buttonNumber;

    public ScooterOrderTest(String name, String surname, String address, String metroStation, String phone, String date, String comment, int buttonNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
        this.buttonNumber = buttonNumber;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> getInfoForOrders() {
        return Arrays.asList(new Object[][]{
                {"Роман", "Сергеев", "Шпалерная, 33", "Черкизовская", "89182736450", "25.04.2024", "Такой вот комментарий", 0},
                {"Евгений", "Ефремов", "Козлова, 41", "Красносельская", "89182666450", "28.04.2024", "Надеюсь я сдам с первого раза", 1}
        });
    }


    @Test
    public void fillOrderTest() {
        QaScooterMainPage qaScooterMainPage = new QaScooterMainPage(driver);
        qaScooterMainPage.clickCookieBtnClose();
        if (buttonNumber == 1) {
            qaScooterMainPage.scrollPageToEndOfList();
            qaScooterMainPage.clickOrderBtn(buttonNumber);
        } else {
            qaScooterMainPage.clickOrderBtn(buttonNumber);
        }
        OrderFioAddressPhonePage orderFioAddressPhonePage = new OrderFioAddressPhonePage(driver);
        orderFioAddressPhonePage.enterName(name);
        orderFioAddressPhonePage.enterSurname(surname);
        orderFioAddressPhonePage.enterAddress(address);
        orderFioAddressPhonePage.selectMetroStation(metroStation);
        orderFioAddressPhonePage.enterPhone(phone);
        orderFioAddressPhonePage.clickNextButton();
        OrderAboutRentPage orderAboutRentPage = new OrderAboutRentPage(driver);
        orderAboutRentPage.fillDateField(date);
        orderAboutRentPage.setRentalPeriod();
        orderAboutRentPage.selectRandomColorCheckbox();
        orderAboutRentPage.enterComment(comment);
        orderAboutRentPage.clickOrderButton();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.clickYesButton();
        String result = confirmationPage.getTextFromOrderModalHeader();
        assertTrue("Текст элемента не соответствует ожидаемому", result.trim().contains("Заказ оформлен"));
        //оставил, чтобы увидеть зеленый тест в chrome
        //assertTrue("Текст элемента не соответствует ожидаемому", result.trim().contains("Хотите оформить заказ?"));
    }
}
