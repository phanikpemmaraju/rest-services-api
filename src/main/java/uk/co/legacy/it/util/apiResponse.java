package uk.co.legacy.it.util;

import java.util.List;

public class apiResponse {
    private List<apiRequestParam> listOfResponseParams;

    public apiResponse(List<apiRequestParam> listOfResponseParams) {
        this.listOfResponseParams = listOfResponseParams;
    }

    public List<apiRequestParam> getListOfResponseParams() {
        return listOfResponseParams;
    }

    public void setListOfResponseParams(List<apiRequestParam> listOfResponseParams) {
        this.listOfResponseParams = listOfResponseParams;
    }
}
