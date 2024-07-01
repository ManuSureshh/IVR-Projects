package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class WLCancelMemberInfo {
	@SerializedName("MemberId")
	public String memberID;

	@SerializedName("MemberShipId")
	public String memberShipID;

	public WLCancelMemberInfo(String memberID, String memberShipID) {
		super();
		this.memberID = memberID;
		this.memberShipID = memberShipID;
	}

	public WLCancelMemberInfo() {
		super();
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberShipID() {
		return memberShipID;
	}

	public void setMemberShipID(String memberShipID) {
		this.memberShipID = memberShipID;
	}

	@Override
	public String toString() {
		return "WLCancelMemberInfo [memberID=" + memberID + ", memberShipID=" + memberShipID + "]";
	}
}
