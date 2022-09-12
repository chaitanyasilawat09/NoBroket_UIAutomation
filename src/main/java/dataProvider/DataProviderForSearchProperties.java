package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class DataProviderForSearchProperties {

    @DataProvider(name = "testDPMultipleData")
    public Object[][] MultipleData() {

//        return new Object[][]{{"Mumbai"}};
//        String city,String flat_1,String flat_2,String searchArea,String selectArea_1,String selectArea_2
        return new Object[][]{{"Mumbai","2 BHK", "3 BHK", "malad", "Malad East, Malkani", "Malad west, Sundar Ln"}};
    }


    @Test(dataProvider = "testDPMultipleData")
    public void MultipleDataTest(String name, String name2) {
        System.out.println("Name :-" + name + ",  Name :-" + name2);

    }


    @DataProvider(name = "dp")
    public Object[][] dataProviderS() {

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Ram", "Sita");
        map.put("Shiv", "Shakti");
        map.put("Krishna", "Radha");

        return new Object[][]{
                new Object[]{map}};
    }

    @Test(dataProvider = "dp", dataProviderClass = DataProviderForSearchProperties.class)
    public void test2(LinkedHashMap<String, String> testData) {
        System.out.println(testData.get("Shiv"));
        System.out.println(testData.get("Ram"));
        System.out.println(testData.get("Krishna"));
    }
}
