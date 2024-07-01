package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class MemberInformationReq {
	
	@SerializedName("MemberId")
	public String memberID;
	
	@SerializedName("MembershipId")
	public String memberShipID;

	public MemberInformationReq(String memberID, String memberShipID) {
		super();
		this.memberID = memberID;
		this.memberShipID = memberShipID;
	}

	public MemberInformationReq() {
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
		return "MemberInformationReq [memberID=" + memberID + ", memberShipID=" + memberShipID + "]";
	}
}
