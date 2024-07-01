package org.vis.club.mahindra.api.model;

import java.util.ArrayList;

public class UpcomingBookingDetailsResponse {

    public int status;
    public int responseCode;
    public String responseMessage;
    public ArrayList<BookingProbability> getBookingProbability;
    
    public int getStatus() {
        return status;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
    public ArrayList<BookingProbability> getGetBookingProbability() {
        return getBookingProbability;
    }
    
    public void setStatus(int status) {
		this.status = status;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public void setGetBookingProbability(ArrayList<BookingProbability> getBookingProbability) {
		this.getBookingProbability = getBookingProbability;
	}
	@Override
    public String toString() {
	return "UpcomingBookingDetailsResponse [status=" + status + ", responseCode=" + responseCode
		+ ", responseMessage=" + responseMessage + ", getBookingProbability=" + getBookingProbability + "]";
    }    
}
