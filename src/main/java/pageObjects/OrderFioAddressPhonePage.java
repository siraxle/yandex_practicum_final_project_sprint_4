package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFioAddressPhonePage {
    private WebDriver driver;
    //поле имя
    private By nameFld = By.xpath("//input[@placeholder='* Имя']");
    //поле фамилия
    private By surnameFld = By.xpath("//input[@placeholder='* Фамилия']");
    //поле адрес
    private By addressFld = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле метро
    private By subwayStationFld = By.xpath("//input[@placeholder='* Станция метро']");
    //поле телефон
    private By phoneFld = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка далее
    private By nextBtn = By.xpath("//button[text()='Далее']");

    public OrderFioAddressPhonePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        WebElement nameElmnt = driver.findElement(nameFld);
        nameElmnt.click();
        nameElmnt.clear();
        nameElmnt.sendKeys(name);
    }

    public void enterSurname(String surname) {
        WebElement surnameElmnt = driver.findElement(surnameFld);
        surnameElmnt.click();
        surnameElmnt.clear();
        surnameElmnt.sendKeys(surname);
    }

    public void enterAddress(String address) {
        WebElement addr = driver.findElement(addressFld);
        addr.click();
        addr.clear();
        addr.sendKeys(address);
    }

    public void selectMetroStation(String metroStationFromOrder) {
        WebElement subwayStation = driver.findElement(subwayStationFld);
        subwayStation.click();
        subwayStation.clear();
        subwayStation.sendKeys(metroStationFromOrder);
        subwayStation.sendKeys(Keys.DOWN, Keys.ENTER);
    }


    public void enterPhone(String phone) {
        WebElement phoneElmnt = driver.findElement(phoneFld);
        phoneElmnt.click();
        phoneElmnt.clear();
        phoneElmnt.sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextBtn).click();
    }

}
