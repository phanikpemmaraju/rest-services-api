package uk.co.legacy.it.util;

/**
 *
 */
public class apiRequestParam {
    private String name;
    private String value;
    private apiRequestParamType paramType;
    private apiRequestParamDataType paramDataType;
    private int index;

    public apiRequestParam(String name, String value, apiRequestParamType paramType, apiRequestParamDataType paramDataType, int index ){
        this.name=name;
        this.value=value;
        this.paramType=paramType;
        this.paramDataType=paramDataType;
        this.index=index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public apiRequestParamType getParamType() {
        return paramType;
    }

    public void setParamType(apiRequestParamType paramType) {
        this.paramType = paramType;
    }

    public apiRequestParamDataType getParamDataType() {
        return paramDataType;
    }

    public void setParamDataType(apiRequestParamDataType paramDataType) {
        this.paramDataType = paramDataType;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
