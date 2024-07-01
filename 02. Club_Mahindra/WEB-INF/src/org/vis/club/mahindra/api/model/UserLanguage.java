package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class UserLanguage {

	@SerializedName("mobileNumber")
	public String mobileNumber;

	@SerializedName("language")
	public String language;
	
	public UserLanguage() {
		super();
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "UserLanguage [mobileNumber=" + mobileNumber + ", language=" + language + "]";
	}
}
