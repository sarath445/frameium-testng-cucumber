package StepDef.OrangeHRMTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTestData {
    //@Test(dataProvider = "logintestdata")

    @DataProvider(name = "logintestdatas3",parallel = true)
    //dataprovider method.
    public Object[][] loginprovider(){
        //using return type of 2 dimensional array.
        Object[][] data = new Object[2][2];
        data[0][0] = "Admin";
        data[0][1] = "admin123";
        data[1][0] = "Admin";
        data[1][1] = "test123";
        return data;
    }

    @Test(dataProvider = "dp2")
    public void TestPractise(Object[] o) {
        for (Object object : o) {
            System.out.println(object);
        }
       System.out.println("...");
    }

    @DataProvider(name = "dp2")
    //using single dimesional array of return type.
//    public Object[]dp1(){
//        //defining and initialization.
//        Object[] data = new Object[]{
//                "sarath",
//                "sreejith",
//                7,
//                4
//        };
//        return data;
//    }
    public Object[][]dp2(){
        Object[][] data = new Object[][]{
                {"adani", 543},
                {"paytm", 235, "mobikwik"},
                {"grse", 673,"swiggy",550}
        };
        return data;
    }
    @Test(dataProvider = "dp3")
    public void Testpractse1(Object[] o){
        System.out.println(o[0] +" "+ o[1]);
    }

    @DataProvider(name = "dp3", indices = {1})
    public Iterator<Object[]> dp3(){                //Return type-iterator & Object is datatype.
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"finn", 74});
        data.add(new Object[]{"constas", 85});
        return data.iterator();
    }

}

