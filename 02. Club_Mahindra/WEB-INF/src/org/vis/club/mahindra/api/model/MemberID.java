package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class MemberID {
	@SerializedName("MemberId")
	public String memberID;

	public MemberID(String memberID) {
		super();
		this.memberID = memberID;
	}

	public MemberID() {
		super();
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	@Override
	public String toString() {
		return "MemberID [memberID=" + memberID + "]";
	}	

}
