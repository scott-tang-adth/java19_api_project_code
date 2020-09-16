package homeworkday16.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class CaseInfo {
    //私有属性，get、set、空参构造必须有。
    //CaseId(用例编号)	Name(接口名)	Url(接口地址)
    // Type(接口提交类型)	Desc(用例描述)
    // Params(参数)	Content-Type
    @Excel(name = "CaseId(用例编号)")
    private int id;
    @Excel(name = "Name(接口名)")
    private String name;
    @Excel(name = "Url(接口地址)")
    private String url;
    @Excel(name = "Type(接口提交类型)")
    private String method;
    //不映射Desc 不写字段
    @Excel(name = "Params(参数)")
    private String params;
    @Excel(name = "Content-Type")
    private String contentType;
    public CaseInfo() {
    }

    public CaseInfo( int id, String name, String url, String method, String params, String contentType ) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.method = method;
        this.params = params;
        this.contentType = contentType;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod( String method ) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams( String params ) {
        this.params = params;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType( String contentType ) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "CaseInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
