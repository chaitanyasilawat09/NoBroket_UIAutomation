package pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class HomePage extends BasePage{

    @FindBy(xpath = "(//div[contains(text(),'Buy')])[1]")
    private WebElement buyButton;

    @FindBy(xpath = "(//div[contains(@class,'nb-select__dropdown-indicator')])[1]")
    private WebElement cityDropDown;

    @FindBy(xpath = "(//div[contains(@class,'nb-select__dropdown-indicator')])[2]")
    private WebElement apartmentTypeDropDown;

     @FindBy(xpath = "//div[contains(@class,'nb-select__single-value')]")
    private WebElement selectedCityName;

     @FindBy(id = "listPageSearchLocality")
    private WebElement searchArea;

     @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(text(),'Description')]")
    private WebElement descriptionHeading;

    @FindBy(id = "description")
    private WebElement descriptionValue;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);    }

    public String selectValueFromDropDown(String cityName){
        List<WebElement> element = driver.findElements(By.xpath("(//div[contains(@class,'nb-select__menu')])[1]/div/div"));
        for (WebElement e : element){
            System.out.println( e.getText());
            if (e.getText().contains(cityName)) {
                e.click();
                break;
            }
        }
        return selectedCityName.getText();
    }

    public void selectArea(String searchArea, String selectArea){
        getSearchArea().clear();
        getSearchArea().sendKeys(searchArea);
        sleeps(5000);
        List<WebElement> element = driver.findElements(By.xpath("(//div[contains(@class,'autocomplete-dropdown-container')])[1]/div"));

        for (WebElement e : element) {
            if (e.getText().contains(selectArea)) {
                e.click();
                sleeps(5000);
                break;
            }
        }
    }


    public void sleeps(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String selectCity(String cityName){
        List<WebElement> element = driver.findElements(By.xpath("(//div[contains(@class,'nb-select__menu')])[1]/div/div"));
        for (WebElement e : element){
            System.out.println( e.getText());
            if (e.getText().contains(cityName)) {
                e.click();
                break;
            }
        }
        return selectedCityName.getText();
    }

    public WebElement selectProperty(int propertyIndex){
        WebElement property = driver.findElement(By.xpath("(//h2/span)["+propertyIndex+"]"));
        property.isDisplayed();
        property.isEnabled();
        return property;
    }
}
