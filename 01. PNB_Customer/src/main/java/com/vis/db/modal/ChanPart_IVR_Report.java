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
@Table( name="ChanPart_IVR_Report")


public class ChanPart_IVR_Report {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	    private int ID;
        private String UCID;
	    private String Session_ID;
	    @Column(name = "Start_Time")
	    private Date startTime;
	    @Column(name = "End_Time")
	    private Date endTime;
	    private String Call_Duration;
	    private String ANI;
	    private String DNIS;
	    private String Language_Selected;
	    private String Main_Menu;
	    private String PNB_Menu;
	    private String KBL_Menu;
	    private String JKB_Menu;
	    private String MAP_Menu;
	    private String Option_2_Menu;
	    private String IP_Mobile_Number;
	    private String WebService_Response;
	    private String SMS_Triggered;
	    private String Voice_Mail;
	    private String Traverse_Path;
	    private String Dissconnect_Node;
	    private String Transfer_VDN;
	    private String Exit_Reason;
	    private String UUI_Info;


@Override
		public String toString() {
			return "ChanPart_IVR_Report [ID=" + ID + ", UCID=" + UCID + ", Session_ID=" + Session_ID + ", startTime="
					+ startTime + ", endTime=" + endTime + ", Call_Duration=" + Call_Duration + ", ANI=" + ANI
					+ ", DNIS=" + DNIS + ", Language_Selected=" + Language_Selected + ", Main_Menu=" + Main_Menu
					+ ", PNB_Menu=" + PNB_Menu + ", KBL_Menu=" + KBL_Menu + ", JKB_Menu=" + JKB_Menu + ", MAP_Menu="
					+ MAP_Menu + ", Option_2_Menu=" + Option_2_Menu + ", IP_Mobile_Number=" + IP_Mobile_Number
					+ ", WebService_Response=" + WebService_Response + ", SMS_Triggered=" + SMS_Triggered
					+ ", Voice_Mail=" + Voice_Mail + ", Traverse_Path=" + Traverse_Path + ", Dissconnect_Node="
					+ Dissconnect_Node + ", Transfer_VDN=" + Transfer_VDN + ", Exit_Reason=" + Exit_Reason
					+ ", UUI_Info=" + UUI_Info + "]";
		}

public ChanPart_IVR_Report() {
			super();
		}

public ChanPart_IVR_Report(int iD, String uCID, String session_ID, Date startTime, Date endTime,
				String call_Duration, String aNI, String dNIS, String language_Selected, String main_Menu,
				String pNB_Menu, String kBL_Menu, String jKB_Menu, String mAP_Menu, String option_2_Menu,
				String iP_Mobile_Number, String webService_Response, String sMS_Triggered, String voice_Mail,
				String traverse_Path, String dissconnect_Node, String transfer_VDN, String exit_Reason,
				String uUI_Info) {
			super();
			ID = iD;
			UCID = uCID;
			Session_ID = session_ID;
			this.startTime = startTime;
			this.endTime = endTime;
			Call_Duration = call_Duration;
			ANI = aNI;
			DNIS = dNIS;
			Language_Selected = language_Selected;
			Main_Menu = main_Menu;
			PNB_Menu = pNB_Menu;
			KBL_Menu = kBL_Menu;
			JKB_Menu = jKB_Menu;
			MAP_Menu = mAP_Menu;
			Option_2_Menu = option_2_Menu;
			IP_Mobile_Number = iP_Mobile_Number;
			WebService_Response = webService_Response;
			SMS_Triggered = sMS_Triggered;
			Voice_Mail = voice_Mail;
			Traverse_Path = traverse_Path;
			Dissconnect_Node = dissconnect_Node;
			Transfer_VDN = transfer_VDN;
			Exit_Reason = exit_Reason;
			UUI_Info = uUI_Info;
		}

public int getID() {
			return ID;
		}

		public void setID(int iD) {
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

		public String getLanguage_Selected() {
			return Language_Selected;
		}

		public void setLanguage_Selected(String language_Selected) {
			Language_Selected = language_Selected;
		}

		public String getMain_Menu() {
			return Main_Menu;
		}

		public void setMain_Menu(String main_Menu) {
			Main_Menu = main_Menu;
		}

		public String getPNB_Menu() {
			return PNB_Menu;
		}

		public void setPNB_Menu(String pNB_Menu) {
			PNB_Menu = pNB_Menu;
		}

		public String getKBL_Menu() {
			return KBL_Menu;
		}

		public void setKBL_Menu(String kBL_Menu) {
			KBL_Menu = kBL_Menu;
		}

		public String getJKB_Menu() {
			return JKB_Menu;
		}

		public void setJKB_Menu(String jKB_Menu) {
			JKB_Menu = jKB_Menu;
		}

		public String getMAP_Menu() {
			return MAP_Menu;
		}

		public void setMAP_Menu(String mAP_Menu) {
			MAP_Menu = mAP_Menu;
		}

		public String getOption_2_Menu() {
			return Option_2_Menu;
		}

		public void setOption_2_Menu(String option_2_Menu) {
			Option_2_Menu = option_2_Menu;
		}

		public String getIP_Mobile_Number() {
			return IP_Mobile_Number;
		}

		public void setIP_Mobile_Number(String iP_Mobile_Number) {
			IP_Mobile_Number = iP_Mobile_Number;
		}

		public String getWebService_Response() {
			return WebService_Response;
		}

		public void setWebService_Response(String webService_Response) {
			WebService_Response = webService_Response;
		}

		public String getSMS_Triggered() {
			return SMS_Triggered;
		}

		public void setSMS_Triggered(String sMS_Triggered) {
			SMS_Triggered = sMS_Triggered;
		}

		public String getVoice_Mail() {
			return Voice_Mail;
		}

		public void setVoice_Mail(String voice_Mail) {
			Voice_Mail = voice_Mail;
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

		public String getExit_Reason() {
			return Exit_Reason;
		}

		public void setExit_Reason(String exit_Reason) {
			Exit_Reason = exit_Reason;
		}

		public String getUUI_Info() {
			return UUI_Info;
		}

		public void setUUI_Info(String uUI_Info) {
			UUI_Info = uUI_Info;
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


