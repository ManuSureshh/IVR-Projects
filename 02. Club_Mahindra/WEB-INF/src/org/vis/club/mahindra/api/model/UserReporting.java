package org.vis.club.mahindra.api.model;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class UserReporting {

	@SerializedName("ucid")
	public String ucid;
	@SerializedName("mobile_number")
	public String mobile_number;
	@SerializedName("register_user")
	public String register_user;
	@SerializedName("premier_member")
	public String premier_member;
	@SerializedName("retry_fail")
	public String retry_fail;
	@SerializedName("otp_verified")
	public String otp_verified;
	@SerializedName("start_time")
	public Date start_time;
	@SerializedName("end_time")
	public Date end_time;
	
	public UserReporting(String ucid, String mobile_number, String register_user, String premier_member,
			String retry_fail, String otp_verified, Date start_time, Date end_time) {
		super();
		this.ucid = ucid;
		this.mobile_number = mobile_number;
		this.register_user = register_user;
		this.premier_member = premier_member;
		this.retry_fail = retry_fail;
		this.otp_verified = otp_verified;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public UserReporting() {
		super();
	}
	public String getUcid() {
		return ucid;
	}
	public void setUcid(String ucid) {
		this.ucid = ucid;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getRegister_user() {
		return register_user;
	}
	public void setRegister_user(String register_user) {
		this.register_user = register_user;
	}
	public String getPremier_member() {
		return premier_member;
	}
	public void setPremier_member(String premier_member) {
		this.premier_member = premier_member;
	}
	public String getRetry_fail() {
		return retry_fail;
	}
	public void setRetry_fail(String retry_fail) {
		this.retry_fail = retry_fail;
	}
	public String getOtp_verified() {
		return otp_verified;
	}
	public void setOtp_verified(String otp_verified) {
		this.otp_verified = otp_verified;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	@Override
	public String toString() {
		return "UserReporting [ucid=" + ucid + ", mobile_number=" + mobile_number + ", register_user=" + register_user
				+ ", premier_member=" + premier_member + ", retry_fail=" + retry_fail + ", otp_verified=" + otp_verified
				+ ", start_time=" + start_time + ", end_time=" + end_time + "]";
	}
}
