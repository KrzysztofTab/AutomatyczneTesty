package page.objects.fishObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.objects.driver.manager.DriverManager;
import page.objects.waits.WaitForElement;

public class LoginPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    @FindBy(css = "area[alt='Fish']")
    private WebElement btnFishImage;

    public LoginPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }


    public FooterPage clickOnLoginButton() {

        signOnButton.click();
        logger.info("Clicked on Login Button");
        return new FooterPage();
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        logger.info("Returned warning message was: {}", warningText);
        return warningText;
    }

    public FishListPage clickOnFishImageButton() {
        WaitForElement.waitUntilElementIsVisible(btnFishImage);
        btnFishImage.click();
        logger.info("Clicked on fish image");
        return new FishListPage();
    }
}
