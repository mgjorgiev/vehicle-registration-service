package com.vehicle.dto.response;

import java.util.Map;

public class StatisticsResponse {

    private Map<String, Integer> result;

    public StatisticsResponse(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    public void setResult(Map<String, Integer> result) {
        this.result = result;
    }

}
