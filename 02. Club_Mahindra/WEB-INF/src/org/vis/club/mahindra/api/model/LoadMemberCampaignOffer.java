package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class LoadMemberCampaignOffer{
    @SerializedName("OfferName") 
    public String offerName;
    @SerializedName("ValidFrom") 
    public String validFrom;
    @SerializedName("ValidTo") 
    public String validTo;
	
    public LoadMemberCampaignOffer(String offerName, String validFrom, String validTo) {
		super();
		this.offerName = offerName;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}
	public LoadMemberCampaignOffer() {
		super();
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	@Override
	public String toString() {
		return "LoadMemberCampaignOffer [offerName=" + offerName + ", validFrom=" + validFrom + ", validTo=" + validTo
				+ "]";
	}
}


