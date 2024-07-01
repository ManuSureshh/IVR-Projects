package org.vis.club.mahindra.api.model;

public class ResendCVResponse {

    public int status;
    public int responseCode;
    public String responseMessage;
    public String cvno;

    public int getStatus() {
	return status;
    }

    public int getResponseCode() {
	return responseCode;
    }

    public String getResponseMessage() {
	return responseMessage;
    }

    public String getCvno() {
	return cvno;
    }

    @Override
    public String toString() {
	return "ResendCVResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
		+ responseMessage + ", cvno=" + cvno + "]";
    }

}
