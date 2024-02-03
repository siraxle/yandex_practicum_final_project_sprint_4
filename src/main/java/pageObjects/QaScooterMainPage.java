package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QaScooterMainPage {

    private WebDriver driver;
    //кнопка заказать
//    private By orderBtn = By.className("Button_Button__ra12g");
    private By orderBtn = By.xpath("//button[text()='Заказать']");

    private By cookieCloseBtn = By.xpath("//button[text() = 'да все привыкли']");

    private By accordionElement = By.xpath("//div[contains(@id, 'accordion__heading')]");

    public QaScooterMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderBtn(int elementNumber){
        driver.findElements(orderBtn).get(elementNumber).click();
    }

    private List<WebElement> getAccordionElements(){
        return driver.findElements(accordionElement);
    }

    public void clickOnAccordionElement(int elementNumber){
        List<WebElement> accordionElements = getAccordionElements();
        WebElement elementToClick = accordionElements.get(elementNumber);
        elementToClick.click();
    }

    public String getAnswerFromAccordionElement(int elementNumber) {
        List<WebElement> accordionElements = getAccordionElements();
        WebElement element = accordionElements.get(elementNumber);
        WebElement textElement = element.findElement(By.xpath("./../following-sibling::div/p"));
        return textElement.getText();
    }

    public void clickCookieBtnClose(){
        driver.findElement(cookieCloseBtn).click();
    }

    public void scrollPageToEndOfList() {
        List<WebElement> accordionElements = getAccordionElements();
        WebElement lastQuestionArrow = accordionElements.get(accordionElements.size()-1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }

}
