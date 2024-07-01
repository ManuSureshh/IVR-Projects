package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class MemberDetailInformation {

	@SerializedName("MobileNumber")
	public String mobileNumber;
	
	public MemberDetailInformation() {
		super();
	}

	public MemberDetailInformation(String mobileNumber) {
		super();
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "MemberDetailInformation [mobileNumber=" + mobileNumber + "]";
	}
}
