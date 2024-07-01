package org.vis.club.mahindra.api.model;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Offers {
	public int status;
	public int responseCode;
	public String responseMessage;
	@SerializedName("LoadMemberCampaignOffers")
	public ArrayList<LoadMemberCampaignOffer> loadMemberCampaignOffers;
	
	public Offers(int status, int responseCode, String responseMessage,
			ArrayList<LoadMemberCampaignOffer> loadMemberCampaignOffers) {
		super();
		this.status = status;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.loadMemberCampaignOffers = loadMemberCampaignOffers;
	}
	public Offers() {
		super();
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public ArrayList<LoadMemberCampaignOffer> getLoadMemberCampaignOffers() {
		return loadMemberCampaignOffers;
	}
	public void setLoadMemberCampaignOffers(ArrayList<LoadMemberCampaignOffer> loadMemberCampaignOffers) {
		this.loadMemberCampaignOffers = loadMemberCampaignOffers;
	}
	@Override
	public String toString() {
		return "Offers [status=" + status + ", responseCode=" + responseCode + ", responseMessage=" + responseMessage
				+ ", loadMemberCampaignOffers=" + loadMemberCampaignOffers + "]";
	}
}

