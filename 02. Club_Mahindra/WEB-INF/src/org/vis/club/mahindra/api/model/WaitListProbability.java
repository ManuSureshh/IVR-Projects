package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class WaitListProbability {
    @SerializedName("MemberId") 
    public String memberId;
    @SerializedName("MembershipId") 
    public String membershipId;
    @SerializedName("WLNo") 
    public String wLNo;
    @SerializedName("ResortName") 
    public String resortName;
    @SerializedName("CheckInDate") 
    public String checkInDate;
    @SerializedName("CheckOutDate") 
    public String checkOutDate;
    @SerializedName("ReservationStatus") 
    public String reservationStatus;
    @SerializedName("WLPredictionStatus") 
    public String wLPredictionStatus;
    public String getMemberId() {
        return memberId;
    }
    public String getMembershipId() {
        return membershipId;
    }
    public String getwLNo() {
        return wLNo;
    }
    public String getResortName() {
        return resortName;
    }
    public String getCheckInDate() {
        return checkInDate;
    }
    public String getCheckOutDate() {
        return checkOutDate;
    }
    public String getReservationStatus() {
        return reservationStatus;
    }
    public String getwLPredictionStatus() {
        return wLPredictionStatus;
    }
    
    public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
	public void setwLNo(String wLNo) {
		this.wLNo = wLNo;
	}
	public void setResortName(String resortName) {
		this.resortName = resortName;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public void setwLPredictionStatus(String wLPredictionStatus) {
		this.wLPredictionStatus = wLPredictionStatus;
	}
	@Override
    public String toString() {
	return "WaitListProbability [memberId=" + memberId + ", membershipId=" + membershipId + ", wLNo=" + wLNo
		+ ", resortName=" + resortName + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
		+ ", reservationStatus=" + reservationStatus + ", wLPredictionStatus=" + wLPredictionStatus + "]";
    }
}
