package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class Member {
    @SerializedName("MemberId") 
    public String memberId;
    @SerializedName("MemberShipId") 
    public String memberShipId;
    @SerializedName("ContractId") 
    public String contractId;
    @SerializedName("MemberName") 
    public String memberName;
    @SerializedName("ProductName") 
    public String productName;
    @SerializedName("MemberType") 
    public String memberType;
    @SerializedName("MemberDOB") 
    public String memberDOB;
    @SerializedName("WhatsAppOpted") 
    public String whatsAppOpted;
    @SerializedName("AppDownloaded") 
    public String appDownloaded;
    @SerializedName("ASF_Due")
    public String asfDue;
    @SerializedName("EMI_Due")
    public String emiDue;
    @SerializedName("Balance_HFRP_Points")
    public String balanceHFRP;
    @SerializedName("ERCV_Balance")
    public String ercvBalance;
    @SerializedName("ComplimentaryNights")
    public String complimentaryNights;

	public String getMemberId() {
		return memberId;
	}

	public String getMemberShipId() {
		return memberShipId;
	}

	public String getContractId() {
		return contractId;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getProductName() {
		return productName;
	}

	public String getMemberType() {
		return memberType;
	}

	public String getMemberDOB() {
		return memberDOB;
	}

	public String getWhatsAppOpted() {
		return whatsAppOpted;
	}

	public String getAppDownloaded() {
		return appDownloaded;
	}

	public String getAsfDue() {
		return asfDue;
	}

	public String getEmiDue() {
		return emiDue;
	}

	public String getBalanceHFRP() {
		return balanceHFRP;
	}

	public String getErcvBalance() {
		return ercvBalance;
	}

	public String getComplimentaryNights() {
		return complimentaryNights;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberShipId=" + memberShipId + ", contractId=" + contractId
				+ ", memberName=" + memberName + ", productName=" + productName + ", memberType=" + memberType
				+ ", memberDOB=" + memberDOB + ", whatsAppOpted=" + whatsAppOpted + ", appDownloaded=" + appDownloaded
				+ ", asfDue=" + asfDue + ", emiDue=" + emiDue + ", balanceHFRP=" + balanceHFRP + ", ercvBalance="
				+ ercvBalance + ", complimentaryNights=" + complimentaryNights + "]";
	}	
}