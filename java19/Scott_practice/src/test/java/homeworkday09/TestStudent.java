package homeworkday09;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

public class TestStudent {

    public static void main(String[] args) {
        String json ="{\"name\": \"张三\", \"age\": \"18\", \"score\":\"100\"}";
        Student student = JSONObject.parseObject(json, Student.class);
        //将结果还原下
        String jsonStudent=JSONObject.toJSONString(student);
        System.out.println(jsonStudent);
        System.out.println(student);
        String json2 =" [{\"name\": \"张三\", \"age\": \"18\", \"score\":\"100\"},{\"name\": \"李四\", \"age\": \"16\", \"score\":\"100\"}]";
        //字符串是数组
        List<Student> students = JSONObject.parseArray(json2,Student.class);
        //这里面已经有数据了直接输出就行了
        System.out.println(students);
        //还原字符串
        String s = JSONObject.toJSONString(students);
        System.out.println(s);
    }
}
