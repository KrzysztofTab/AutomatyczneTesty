package page.objects.fish.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.objects.driver.manager.DriverManager;

public class FishListPage {

    @FindBy(css = "tr:nth-child(2) a")
    private WebElement angelfishIdLink;

    public FishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnAngelfishId() {
        angelfishIdLink.click();
    }
}