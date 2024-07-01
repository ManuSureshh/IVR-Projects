package org.vis.club.mahindra.api.model;

import com.google.gson.annotations.SerializedName;

public class BookingProbability {
    @SerializedName("MemberId") 
    public String memberId;
    @SerializedName("MembershipId") 
    public String membershipId;
    @SerializedName("CVNo") 
    public String cVNo;
    @SerializedName("CheckIn") 
    public String checkIn;
    @SerializedName("CheckOut") 
    public String checkOut;
    @SerializedName("ResortName") 
    public String resortName;
    @SerializedName("ReservationStatus") 
    public String reservationStatus;
    
    

    public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}

	public void setcVNo(String cVNo) {
		this.cVNo = cVNo;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public void setResortName(String resortName) {
		this.resortName = resortName;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getMemberId() {
	return memberId;
    }

    public String getMembershipId() {
	return membershipId;
    }

    public String getcVNo() {
	return cVNo;
    }

    public String getCheckIn() {
	return checkIn;
    }

    public String getCheckOut() {
	return checkOut;
    }

    public String getResortName() {
	return resortName;
    }

    public String getReservationStatus() {
	return reservationStatus;
    }

    @Override
    public String toString() {
	return "BookingProbability [memberId=" + memberId + ", membershipId=" + membershipId + ", cVNo=" + cVNo
		+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", resortName=" + resortName
		+ ", reservationStatus=" + reservationStatus + "]";
    }

}
