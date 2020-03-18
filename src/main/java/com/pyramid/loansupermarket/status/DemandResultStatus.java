package com.pyramid.loansupermarket.status;

import com.pyramid.loansupermarket.model.Demand;

public class DemandResultStatus {

    private Integer statusCode;
    private String message;
    private Demand demand;

    public Demand getDemand() {
        return demand;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
