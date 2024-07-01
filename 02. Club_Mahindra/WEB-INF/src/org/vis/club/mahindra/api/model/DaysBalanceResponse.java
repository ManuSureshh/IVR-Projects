package org.vis.club.mahindra.api.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DaysBalanceResponse {
    public int status;
    public int responseCode;
    public String responseMessage;
    
    @SerializedName(value = "getdaybalance")
    public List<GetDayBalance> getdaybalance;

    public int getStatus() {
	return status;
    }

    public int getResponseCode() {
	return responseCode;
    }

    public String getResponseMessage() {
	return responseMessage;
    }

    public List<GetDayBalance> getGetdaybalance() {
        return getdaybalance;
    }

    @Override
    public String toString() {
	return "DaysBalanceResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
		+ responseMessage + ", getdaybalance=" + getdaybalance + "]";
    }
}
