package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class OrderAboutRentPage {
    private WebDriver driver;
    //когда привезти самокат
    private By whenBringScooterFld = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //срок аренды
    private By rentalPeriodFld = By.className("Dropdown-control");
    private By selectPeriod = By.xpath("//div[@class='Dropdown-option']");
    //цвет самоката
    private By colorCheckbox = By.xpath("//input[@type='checkbox']");
    //комментарий для курьера
    private By commentFld = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //кнопка заказать
    private By orderBtn = By.xpath("//div[contains(@class, 'Order_Buttons')]//button[text()='Заказать']");



    public OrderAboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDateField(String date) {
        WebElement dateField = driver.findElement(whenBringScooterFld);
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date, Keys.ENTER);
    }


    public void setRentalPeriod() {
        WebElement periodField = driver.findElement(rentalPeriodFld);
        periodField.click();
        driver.findElement(selectPeriod).click();
    }

    public void selectRandomColorCheckbox() {
        List<WebElement> checkboxes = driver.findElements(colorCheckbox);
        if (checkboxes.size() > 0) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(checkboxes.size());
            WebElement checkbox = checkboxes.get(randomIndex);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void enterComment(String comment) {
        WebElement commentField = driver.findElement(commentFld);
        commentField.click();
        commentField.clear();
        commentField.sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderBtn).click();
    }

}
