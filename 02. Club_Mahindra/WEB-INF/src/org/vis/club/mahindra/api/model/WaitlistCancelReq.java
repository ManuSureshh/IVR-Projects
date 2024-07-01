package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class WaitlistCancelReq {
	
	@SerializedName("CVNo")
	public String cvvNo;

	@SerializedName("CanReasonID")
	public String canReasonID;

	public WaitlistCancelReq(String cvvNo, String canReasonID) {
		super();
		this.cvvNo = cvvNo;
		this.canReasonID = canReasonID;
	}

	public WaitlistCancelReq() {
		super();
	}

	public String getCvvNo() {
		return cvvNo;
	}

	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}

	public String getCanReasonID() {
		return canReasonID;
	}

	public void setCanReasonID(String canReasonID) {
		this.canReasonID = canReasonID;
	}

	@Override
	public String toString() {
		return "WaitlistCancelReq [cvvNo=" + cvvNo + ", canReasonID=" + canReasonID + "]";
	}

}
