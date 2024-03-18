package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private By yesBtn = By.xpath("//button[text()='Да']");

    private By orderModalHeader = By.xpath("//div[contains(@class, 'Order_ModalHeader')]");
    private WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYesButton(){
        driver.findElement(yesBtn).click();
    }

    public String getTextFromOrderModalHeader(){
        return driver.findElement(orderModalHeader).getText();
    }

}
