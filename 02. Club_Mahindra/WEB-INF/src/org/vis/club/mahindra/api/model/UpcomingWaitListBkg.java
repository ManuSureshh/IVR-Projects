package org.vis.club.mahindra.api.model;

import java.util.List;

public class UpcomingWaitListBkg {

    public int status;
    public int responseCode;
    public String responseMessage;
    public List<WaitListProbability> getWaitListProbability;
    
    public void setStatus(int status) {
		this.status = status;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public void setGetWaitListProbability(List<WaitListProbability> getWaitListProbability) {
		this.getWaitListProbability = getWaitListProbability;
	}

	public int getStatus() {
	return status;
    }

    public int getResponseCode() {
	return responseCode;
    }

    public String getResponseMessage() {
	return responseMessage;
    }

    public List<WaitListProbability> getGetWaitListProbability() {
	return getWaitListProbability;
    }

    @Override
    public String toString() {
	return "UpcomingWaitListBkg [status=" + status + ", responseCode=" + responseCode + ", responseMessage="
		+ responseMessage + ", getWaitListProbability=" + getWaitListProbability + "]";
    }

}
