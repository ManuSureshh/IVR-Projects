package org.vis.club.mahindra.api.model;

import java.util.List;

public class WaitListCancellationResponse {
    public int status;
    public int responseCode;
    public String responseMessage;
    public List<String> GetWaitListCancellationDetails;

    public int getStatus() {
	return status;
    }

    public int getResponseCode() {
	return responseCode;
    }

    public String getResponseMessage() {
	return responseMessage;
    }

    public List<String> getGetWaitListCancellationDetails() {
	return GetWaitListCancellationDetails;
    }

    @Override
    public String toString() {
	return "WaitListCancellationResponse [status=" + status + ", responseCode=" + responseCode
		+ ", responseMessage=" + responseMessage + ", GetWaitListCancellationDetails="
		+ GetWaitListCancellationDetails + "]";
    }

}
