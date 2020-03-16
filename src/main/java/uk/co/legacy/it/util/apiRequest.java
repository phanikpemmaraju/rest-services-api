package uk.co.legacy.it.util;

import java.util.List;

public class apiRequest {
    private String programName;
    private List<apiRequestParam> listOfRequestParams;


    public apiRequest(String programName, List<apiRequestParam> listOfRequestParams) {
        this.programName = programName;
        this.listOfRequestParams = listOfRequestParams;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<apiRequestParam> getListOfRequestParams() {
        return listOfRequestParams;
    }

    public void setListOfRequestParams(List<apiRequestParam> listOfRequestParams) {
        this.listOfRequestParams = listOfRequestParams;
    }
}
