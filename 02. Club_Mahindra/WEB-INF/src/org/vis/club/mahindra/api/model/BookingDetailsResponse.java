package org.vis.club.mahindra.api.model;

import java.util.ArrayList;

public class BookingDetailsResponse {
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

	@Override
	public String toString() {
		return "BookingDetailsResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
				+ responseMessage + "]";
	}

}
