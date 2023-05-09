package resources.testdata;

import org.testng.annotations.DataProvider;


public class TestData {

    @DataProvider(name = "credentials")
    public Object[][] getData(){
        Object[][]data = new Object[][]{
                {"standard_user","secret_sauce"},
//                {"locked_out_user","secret_sauce"},
//                {"problem_user","secret_sauce"},
        };
        return data;
    }
}
