package com.vis.db.modal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="JK_IVR_Report")

public class JK_IVR_Report {

	@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;

	private String UCID;
    private String Session_ID;
    @Column(name = "Start_Time")
    private Date startTime;
    @Column(name = "End_Time")
    private Date endTime;
    private String Call_Duration;
    private String ANI;
    private String DNIS;
    private String Language;
    private String Traverse_Path;
    private String Dissconnect_Node;
    private String Transfer_VDN;
    private String UUI_Info;
    private String Exit_Reason;
    


public JK_IVR_Report() {
		super();
	}

public JK_IVR_Report(Long iD, String uCID, String session_ID, Date startTime, Date endTime, String call_Duration,
			String aNI, String dNIS, String language, String traverse_Path, String dissconnect_Node,
			String transfer_VDN, String uUI_Info, String exit_Reason) {
		super();
		ID = iD;
		UCID = uCID;
		Session_ID = session_ID;
		this.startTime = startTime;
		this.endTime = endTime;
		Call_Duration = call_Duration;
		ANI = aNI;
		DNIS = dNIS;
		Language = language;
		Traverse_Path = traverse_Path;
		Dissconnect_Node = dissconnect_Node;
		Transfer_VDN = transfer_VDN;
		UUI_Info = uUI_Info;
		Exit_Reason = exit_Reason;
	}

@Override
	public String toString() {
		return "JK_IVR_Report [ID=" + ID + ", UCID=" + UCID + ", Session_ID=" + Session_ID + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", Call_Duration=" + Call_Duration + ", ANI=" + ANI + ", DNIS=" + DNIS
				+ ", Language=" + Language + ", Traverse_Path=" + Traverse_Path + ", Dissconnect_Node="
				+ Dissconnect_Node + ", Transfer_VDN=" + Transfer_VDN + ", UUI_Info=" + UUI_Info + ", Exit_Reason="
				+ Exit_Reason + "]";
	}

public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getUCID() {
		return UCID;
	}

	public void setUCID(String uCID) {
		UCID = uCID;
	}

	public String getSession_ID() {
		return Session_ID;
	}

	public void setSession_ID(String session_ID) {
		Session_ID = session_ID;
	}

	public String getCall_Duration() {
		return Call_Duration;
	}

	public void setCall_Duration(String call_Duration) {
		Call_Duration = call_Duration;
	}

	public String getANI() {
		return ANI;
	}

	public void setANI(String aNI) {
		ANI = aNI;
	}

	public String getDNIS() {
		return DNIS;
	}

	public void setDNIS(String dNIS) {
		DNIS = dNIS;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getTraverse_Path() {
		return Traverse_Path;
	}

	public void setTraverse_Path(String traverse_Path) {
		Traverse_Path = traverse_Path;
	}

	public String getDissconnect_Node() {
		return Dissconnect_Node;
	}

	public void setDissconnect_Node(String dissconnect_Node) {
		Dissconnect_Node = dissconnect_Node;
	}

	public String getTransfer_VDN() {
		return Transfer_VDN;
	}

	public void setTransfer_VDN(String transfer_VDN) {
		Transfer_VDN = transfer_VDN;
	}

	public String getUUI_Info() {
		return UUI_Info;
	}

	public void setUUI_Info(String uUI_Info) {
		UUI_Info = uUI_Info;
	}

	public String getExit_Reason() {
		return Exit_Reason;
	}

	public void setExit_Reason(String exit_Reason) {
		Exit_Reason = exit_Reason;
	}

public Date getStartTime() {
    return startTime;
}

public void setStartTime(String startTime) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    try {
        this.startTime = dateFormat.parse(startTime);
    } catch (ParseException e) {
        e.printStackTrace();
    }
}

public Date getEndTime() {
    return endTime;
}

public void setEndTime(String endTime) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    try {
        this.endTime = dateFormat.parse(endTime);
    } catch (ParseException e) {
        e.printStackTrace();
    }
}

@PrePersist
public void onPrePersist() {
    this.startTime = new Date();
    this.endTime = new Date();
}

@PreUpdate
public void onPreUpdate() {
    this.endTime = new Date();
}
}

