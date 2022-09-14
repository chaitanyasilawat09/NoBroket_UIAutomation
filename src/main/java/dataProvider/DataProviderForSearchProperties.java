package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class DataProviderForSearchProperties {

    @DataProvider(name = "testDPMultipleData")
    public Object[][] MultipleData() {
        return new Object[][]{{"Mumbai","2 BHK", "3 BHK", "malad", "Malad East, Malkani", "Malad west, Sundar Ln"}};
    }
}
