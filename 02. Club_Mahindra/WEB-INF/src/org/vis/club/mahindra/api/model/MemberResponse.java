package org.vis.club.mahindra.api.model;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class MemberResponse {
    public int status;
    public int responseCode;
    public String responseMessage;
    @SerializedName("Members")
    public ArrayList<Member> members;

    public int getStatus() {
	return status;
    }

    public int getResponseCode() {
	return responseCode;
    }

    public String getResponseMessage() {
	return responseMessage;
    }

    public ArrayList<Member> getMembers() {
	return members;
    }

    @Override
    public String toString() {
	return "MemberResponse [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
		+ responseMessage + ", members=" + members + "]";
    }
}
