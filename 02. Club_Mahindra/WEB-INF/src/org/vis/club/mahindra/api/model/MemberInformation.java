package org.vis.club.mahindra.api.model;

import java.util.ArrayList;

public class MemberInformation {
    public int status;
    public int responseCode;
    public String responseMessage;
    public ArrayList<String> members;
    public int getStatus() {
        return status;
    }
    public int getResponseCode() {
        return responseCode;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
    public ArrayList<String> getMembers() {
        return members;
    }
    @Override
    public String toString() {
	return "MemberInformation [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
		+ responseMessage + ", members=" + members + "]";
    }
}
