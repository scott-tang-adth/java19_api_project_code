package homeworkday09;
import java.util.ArrayList;
import java.util.List;

public class ChinaPro {
    private String name;
    private List<Province> provinces=new ArrayList<>();//这里不能添加数据类型 fuck

    public ChinaPro(String name, List<Province> provinces) {
        this.name = name;
        this.provinces = provinces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    @Override
    public String toString() {
        return "ChinaPro{" +
                "name='" + name + '\'' +
                ", provinces=" + provinces +
                '}';
    }
}
