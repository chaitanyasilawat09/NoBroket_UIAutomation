import dataProvider.DataProviderForSearchProperties;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FindPropertiesTest extends BaseTest {

    HomePage homePage;

    @Test(dataProvider = "testDPMultipleData", dataProviderClass = DataProviderForSearchProperties.class)
    public void findProperty(String city,String flat_1, String flat_2, String searchArea, String selectArea_1,String selectArea_2){
        homePage = new HomePage(driver);
        homePage.getBuyButton().click();
        homePage.getCityDropDown().click();
        String cityName = homePage.selectCity(city);
        homePage.getApartmentTypeDropDown().click();
        homePage.selectValueFromDropDown(flat_1);
        homePage.selectValueFromDropDown(flat_2);

        assertThat(cityName,is(city));

        homePage.selectArea(searchArea,selectArea_1);
        homePage.selectArea(searchArea,selectArea_2);
        homePage.getSearchButton().click();
        WebElement property = homePage.selectProperty(4);
        homePage.mouseHover(property);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        assertThat(homePage.getDescriptionHeading().getText(),is("Description"));
        assertThat(homePage.getDescriptionValue().getText(),notNullValue());
    }


}
