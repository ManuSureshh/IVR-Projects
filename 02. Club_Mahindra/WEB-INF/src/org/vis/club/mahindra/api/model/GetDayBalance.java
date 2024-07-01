package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class GetDayBalance {

    @SerializedName(value = "MemberId")
    public String memberId;
    @SerializedName(value = "ContractId")
    public String contractId;
    @SerializedName(value = "RegularNights")
    public String regularNights;
    @SerializedName(value = "RCPBalance")
    public String rCPBalance;

    public String getMemberId() {
	return memberId;
    }

    public String getContractId() {
	return contractId;
    }

    public String getRegularNights() {
	return regularNights;
    }

    public String getrCPBalance() {
	return rCPBalance;
    }

    @Override
    public String toString() {
	return "Getdaybalance [memberId=" + memberId + ", contractId=" + contractId + ", regularNights=" + regularNights
		+ ", rCPBalance=" + rCPBalance + "]";
    }
}
