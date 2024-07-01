package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class HUSResendResponse {
    public int status;
    public int responseCode;
    public String responseMessage;
    @SerializedName("GetHolidayUsageSummary") 
    public Object getHolidayUsageSummary;
    
    public int getStatus() {
        return status;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
    public Object getGetHolidayUsageSummary() {
        return getHolidayUsageSummary;
    }
    @Override
    public String toString() {
	return "HUSResendResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
		+ responseMessage + ", getHolidayUsageSummary=" + getHolidayUsageSummary + "]";
    }
}
