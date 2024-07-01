package org.vis.club.mahindra.api.model;

import java.util.List;

public class OtpSendingResponse {
    public int status;
    public int responseCode;
    public String responseMessage;
    public List<String> Members;

    public int getStatus() {
	return status;
    }

    public int getResponseCode() {
	return responseCode;
    }

    public String getResponseMessage() {
	return responseMessage;
    }

    public List<String> getMembers() {
	return Members;
    }

    @Override
    public String toString() {
	return "OtpSendingResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
		+ responseMessage + ", Members=" + Members + "]";
    }

}
