package homeworkday16.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author by Scott
 * @date 2020/6/14.
 */
public class CaseInfo2 {
    //Url	Type	Desc	Params
    @Excel(name="Url")
    private String url;
    @Excel(name="Type")
    private String type;
    @Excel(name="Desc")
    private String desc;
    @Excel(name="Params")
    private String pram;

    public CaseInfo2() {
    }

    public CaseInfo2( String url, String type, String desc, String pram ) {
        this.url = url;
        this.type = type;
        this.desc = desc;
        this.pram = pram;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc( String desc ) {
        this.desc = desc;
    }

    public String getPram() {
        return pram;
    }

    public void setPram( String pram ) {
        this.pram = pram;
    }

    @Override
    public String toString() {
        return "CaseInfo2{" +
                "url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", pram='" + pram + '\'' +
                '}';
    }
}
