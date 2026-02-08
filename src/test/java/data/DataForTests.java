package data;

import org.testng.annotations.DataProvider;

public class DataForTests {

    @DataProvider(name = "post_data")
    public static Object[][] post_data() {
        return new Object[][] {
                {"Graham", "QA", 1},
                {"Disha", "Testing", 2},
                {"Karan", "Automation", 3}
        };
    }
    @DataProvider(name = "delete_data")
    public Object[] delete_data() {
        return new Object[] {
                3,4
        };
    }
}
