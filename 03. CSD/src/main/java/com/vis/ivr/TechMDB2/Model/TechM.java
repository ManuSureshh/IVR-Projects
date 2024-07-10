package com.vis.ivr.TechMDB2.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TechM 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date start_time;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date end_time;
	private String duration;
	private String ani;
	private String employeetype;
	private String employeeid;
	private String emailtrigger;
	private String smstrigger;
	private String accountunlock;
	private String passwordreset;
	private String exit_vdn;
	private String checkAccountUnlock_PasswordResetOptions;
	private String checkEmpOptions;
	public TechM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TechM(Integer id, Date start_time, Date end_time, String duration, String ani, String employeetype,
			String employeeid, String emailtrigger, String smstrigger, String accountunlock, String passwordreset,
			String exit_vdn, String checkAccountUnlock_PasswordResetOptions, String checkEmpOptions) {
		super();
		this.id = id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.duration = duration;
		this.ani = ani;
		this.employeetype = employeetype;
		this.employeeid = employeeid;
		this.emailtrigger = emailtrigger;
		this.smstrigger = smstrigger;
		this.accountunlock = accountunlock;
		this.passwordreset = passwordreset;
		this.exit_vdn = exit_vdn;
		this.checkAccountUnlock_PasswordResetOptions = checkAccountUnlock_PasswordResetOptions;
		this.checkEmpOptions = checkEmpOptions;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getEmployeetype() {
		return employeetype;
	}
	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmailtrigger() {
		return emailtrigger;
	}
	public void setEmailtrigger(String emailtrigger) {
		this.emailtrigger = emailtrigger;
	}
	public String getSmstrigger() {
		return smstrigger;
	}
	public void setSmstrigger(String smstrigger) {
		this.smstrigger = smstrigger;
	}
	public String getAccountunlock() {
		return accountunlock;
	}
	public void setAccountunlock(String accountunlock) {
		this.accountunlock = accountunlock;
	}
	public String getPasswordreset() {
		return passwordreset;
	}
	public void setPasswordreset(String passwordreset) {
		this.passwordreset = passwordreset;
	}
	public String getExit_vdn() {
		return exit_vdn;
	}
	public void setExit_vdn(String exit_vdn) {
		this.exit_vdn = exit_vdn;
	}
	public String getCheckAccountUnlock_PasswordResetOptions() {
		return checkAccountUnlock_PasswordResetOptions;
	}
	public void setCheckAccountUnlock_PasswordResetOptions(String checkAccountUnlock_PasswordResetOptions) {
		this.checkAccountUnlock_PasswordResetOptions = checkAccountUnlock_PasswordResetOptions;
	}
	public String getCheckEmpOptions() {
		return checkEmpOptions;
	}
	public void setCheckEmpOptions(String checkEmpOptions) {
		this.checkEmpOptions = checkEmpOptions;
	}
	@Override
	public String toString() {
		return "TechM [id=" + id + ", start_time=" + start_time + ", end_time=" + end_time + ", duration=" + duration
				+ ", ani=" + ani + ", employeetype=" + employeetype + ", employeeid=" + employeeid + ", emailtrigger="
				+ emailtrigger + ", smstrigger=" + smstrigger + ", accountunlock=" + accountunlock + ", passwordreset="
				+ passwordreset + ", exit_vdn=" + exit_vdn + ", checkAccountUnlock_PasswordResetOptions="
				+ checkAccountUnlock_PasswordResetOptions + ", checkEmpOptions=" + checkEmpOptions + "]";
	}
	
	
}