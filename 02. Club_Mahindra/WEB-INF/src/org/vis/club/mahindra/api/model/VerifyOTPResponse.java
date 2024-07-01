package org.vis.club.mahindra.api.model;

public class VerifyOTPResponse {
	public int status;
    public int responseCode;
    public String responseMessage;
    public int MemberID;
	public int getStatus() {
		return status;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public int getMemberID() {
		return MemberID;
	}
	@Override
	public String toString() {
		return "VerifyOTPResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
				+ responseMessage + ", MemberID=" + MemberID + "]";
	}
    
    

}
