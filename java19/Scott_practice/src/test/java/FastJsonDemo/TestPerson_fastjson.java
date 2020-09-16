package FastJsonDemo;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestPerson_fastjson {

    private List<person> listOfPersons = new ArrayList<person>();

    @BeforeTest
    public void setUp() {
        listOfPersons.add(new person(15, "John Doe", new Date()));
        listOfPersons.add(new person(20, "Janette Doe", new Date()));
    }

    @Test
    public void whenJavaList_thanConvertToJsonCorrect() {
        String jsonOutput= JSON.toJSONString(listOfPersons);
        System.out.println(jsonOutput);
    }
}
