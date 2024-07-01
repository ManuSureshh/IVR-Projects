package org.vis.club.mahindra.api.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ReCreditDetailsResponse {
    public int status;
    public int responseCode;
    public String responseMessage;
    @SerializedName("GetreCreditDayRes")
    public List<GetreCreditDayRes> getreCreditDayRes;

    public int getStatus() {
	return status;
    }

    public int getResponseCode() {
	return responseCode;
    }

    public String getResponseMessage() {
	return responseMessage;
    }

    public List<GetreCreditDayRes> getGetreCreditDayRes() {
	return getreCreditDayRes;
    }

    @Override
    public String toString() {
	return "ReCreditDetailsResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
		+ responseMessage + ", getreCreditDayRes=" + getreCreditDayRes + "]";
    }
}
