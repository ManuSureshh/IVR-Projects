package org.vis.club.mahindra.api.model;

public class CancelBookingResponse {
	public int status;
    public int responseCode;
    public String responseMessage;
	public int getStatus() {
		return status;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	@Override
	public String toString() {
		return "CancelBookingResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
				+ responseMessage + "]";
	}
    
    
}
