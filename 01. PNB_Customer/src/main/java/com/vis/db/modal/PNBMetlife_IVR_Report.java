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

@Table(name="PNBMetlife_IVR_Report")
public class PNBMetlife_IVR_Report {
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
    private String Language_Selected;
    private String IP_Mobile_Number;
    private String IP_Alternate_Contact_Number;
    @Override
	public String toString() {
		return "PNBMetlife_IVR_Report [ID=" + ID + ", UCID=" + UCID + ", Session_ID=" + Session_ID + ", startTime="
				+ startTime + ", endTime=" + endTime + ", Call_Duration=" + Call_Duration + ", ANI=" + ANI + ", DNIS="
				+ DNIS + ", Language_Selected=" + Language_Selected + ", IP_Mobile_Number=" + IP_Mobile_Number
				+ ", IP_Alternate_Contact_Number=" + IP_Alternate_Contact_Number + ", IP_Policy_Number="
				+ IP_Policy_Number + ", IP_Application_Number=" + IP_Application_Number + ", Policy_Verified="
				+ Policy_Verified + ", Policy_Validation_Tries=" + Policy_Validation_Tries + ", Customer_Type="
				+ Customer_Type + ", Main_Menu=" + Main_Menu + ", Level2_Menu=" + Level2_Menu + ", Level3_Menu="
				+ Level3_Menu + ", Level1_Option5_Menu=" + Level1_Option5_Menu + ", Level3_Option3_Menu="
				+ Level3_Option3_Menu + ", Mobile_Number_Updation_Menu=" + Mobile_Number_Updation_Menu
				+ ", Document_Copy_Request_Menu=" + Document_Copy_Request_Menu + ", Courier_Request=" + Courier_Request
				+ ", SMS_Triggered=" + SMS_Triggered + ", Email_Triggered=" + Email_Triggered + ", Voice_Mail="
				+ Voice_Mail + ", UUI_Info=" + UUI_Info + ", Dissconnect_Node=" + Dissconnect_Node + ", Transfer_VDN="
				+ Transfer_VDN + ", Exit_Reason=" + Exit_Reason + ", Traverse_Path=" + Traverse_Path
				+ ", Webservice_Response=" + Webservice_Response + "]";
	}

	public PNBMetlife_IVR_Report() {
		super();
	}

	public PNBMetlife_IVR_Report(Long iD, String uCID, String session_ID, Date startTime, Date endTime,
			String call_Duration, String aNI, String dNIS, String language_Selected, String iP_Mobile_Number,
			String iP_Alternate_Contact_Number, String iP_Policy_Number, String iP_Application_Number,
			String policy_Verified, String policy_Validation_Tries, String customer_Type, String main_Menu,
			String level2_Menu, String level3_Menu, String level1_Option5_Menu, String level3_Option3_Menu,
			String mobile_Number_Updation_Menu, String document_Copy_Request_Menu, String courier_Request,
			String sMS_Triggered, String email_Triggered, String voice_Mail, String uUI_Info, String dissconnect_Node,
			String transfer_VDN, String exit_Reason, String traverse_Path, String webservice_Response) {
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
		IP_Mobile_Number = iP_Mobile_Number;
		IP_Alternate_Contact_Number = iP_Alternate_Contact_Number;
		IP_Policy_Number = iP_Policy_Number;
		IP_Application_Number = iP_Application_Number;
		Policy_Verified = policy_Verified;
		Policy_Validation_Tries = policy_Validation_Tries;
		Customer_Type = customer_Type;
		Main_Menu = main_Menu;
		Level2_Menu = level2_Menu;
		Level3_Menu = level3_Menu;
		Level1_Option5_Menu = level1_Option5_Menu;
		Level3_Option3_Menu = level3_Option3_Menu;
		Mobile_Number_Updation_Menu = mobile_Number_Updation_Menu;
		Document_Copy_Request_Menu = document_Copy_Request_Menu;
		Courier_Request = courier_Request;
		SMS_Triggered = sMS_Triggered;
		Email_Triggered = email_Triggered;
		Voice_Mail = voice_Mail;
		UUI_Info = uUI_Info;
		Dissconnect_Node = dissconnect_Node;
		Transfer_VDN = transfer_VDN;
		Exit_Reason = exit_Reason;
		Traverse_Path = traverse_Path;
		Webservice_Response = webservice_Response;
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

	public String getLanguage_Selected() {
		return Language_Selected;
	}

	public void setLanguage_Selected(String language_Selected) {
		Language_Selected = language_Selected;
	}

	public String getIP_Mobile_Number() {
		return IP_Mobile_Number;
	}

	public void setIP_Mobile_Number(String iP_Mobile_Number) {
		IP_Mobile_Number = iP_Mobile_Number;
	}

	public String getIP_Alternate_Contact_Number() {
		return IP_Alternate_Contact_Number;
	}

	public void setIP_Alternate_Contact_Number(String iP_Alternate_Contact_Number) {
		IP_Alternate_Contact_Number = iP_Alternate_Contact_Number;
	}

	public String getIP_Policy_Number() {
		return IP_Policy_Number;
	}

	public void setIP_Policy_Number(String iP_Policy_Number) {
		IP_Policy_Number = iP_Policy_Number;
	}

	public String getIP_Application_Number() {
		return IP_Application_Number;
	}

	public void setIP_Application_Number(String iP_Application_Number) {
		IP_Application_Number = iP_Application_Number;
	}

	public String getPolicy_Verified() {
		return Policy_Verified;
	}

	public void setPolicy_Verified(String policy_Verified) {
		Policy_Verified = policy_Verified;
	}

	public String getPolicy_Validation_Tries() {
		return Policy_Validation_Tries;
	}

	public void setPolicy_Validation_Tries(String policy_Validation_Tries) {
		Policy_Validation_Tries = policy_Validation_Tries;
	}

	public String getCustomer_Type() {
		return Customer_Type;
	}

	public void setCustomer_Type(String customer_Type) {
		Customer_Type = customer_Type;
	}

	public String getMain_Menu() {
		return Main_Menu;
	}

	public void setMain_Menu(String main_Menu) {
		Main_Menu = main_Menu;
	}

	public String getLevel2_Menu() {
		return Level2_Menu;
	}

	public void setLevel2_Menu(String level2_Menu) {
		Level2_Menu = level2_Menu;
	}

	public String getLevel3_Menu() {
		return Level3_Menu;
	}

	public void setLevel3_Menu(String level3_Menu) {
		Level3_Menu = level3_Menu;
	}

	public String getLevel1_Option5_Menu() {
		return Level1_Option5_Menu;
	}

	public void setLevel1_Option5_Menu(String level1_Option5_Menu) {
		Level1_Option5_Menu = level1_Option5_Menu;
	}

	public String getLevel3_Option3_Menu() {
		return Level3_Option3_Menu;
	}

	public void setLevel3_Option3_Menu(String level3_Option3_Menu) {
		Level3_Option3_Menu = level3_Option3_Menu;
	}

	public String getMobile_Number_Updation_Menu() {
		return Mobile_Number_Updation_Menu;
	}

	public void setMobile_Number_Updation_Menu(String mobile_Number_Updation_Menu) {
		Mobile_Number_Updation_Menu = mobile_Number_Updation_Menu;
	}

	public String getDocument_Copy_Request_Menu() {
		return Document_Copy_Request_Menu;
	}

	public void setDocument_Copy_Request_Menu(String document_Copy_Request_Menu) {
		Document_Copy_Request_Menu = document_Copy_Request_Menu;
	}

	public String getCourier_Request() {
		return Courier_Request;
	}

	public void setCourier_Request(String courier_Request) {
		Courier_Request = courier_Request;
	}

	public String getSMS_Triggered() {
		return SMS_Triggered;
	}

	public void setSMS_Triggered(String sMS_Triggered) {
		SMS_Triggered = sMS_Triggered;
	}

	public String getEmail_Triggered() {
		return Email_Triggered;
	}

	public void setEmail_Triggered(String email_Triggered) {
		Email_Triggered = email_Triggered;
	}

	public String getVoice_Mail() {
		return Voice_Mail;
	}

	public void setVoice_Mail(String voice_Mail) {
		Voice_Mail = voice_Mail;
	}

	public String getUUI_Info() {
		return UUI_Info;
	}

	public void setUUI_Info(String uUI_Info) {
		UUI_Info = uUI_Info;
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

	public String getTraverse_Path() {
		return Traverse_Path;
	}

	public void setTraverse_Path(String traverse_Path) {
		Traverse_Path = traverse_Path;
	}

	public String getWebservice_Response() {
		return Webservice_Response;
	}

	public void setWebservice_Response(String webservice_Response) {
		Webservice_Response = webservice_Response;
	}

	private String IP_Policy_Number;
    private String IP_Application_Number;
    private String Policy_Verified;
    private String Policy_Validation_Tries;
    private String Customer_Type;
    private String Main_Menu;
    private String Level2_Menu;
    private String Level3_Menu;
    private String Level1_Option5_Menu;
    private String Level3_Option3_Menu;
    private String Mobile_Number_Updation_Menu;
    private String Document_Copy_Request_Menu;
    private String Courier_Request;
    private String SMS_Triggered;
    private String Email_Triggered;
    private String Voice_Mail;
    private String UUI_Info;
    private String Dissconnect_Node;
    private String Transfer_VDN;
    private String Exit_Reason;
    private String Traverse_Path;
    private String Webservice_Response;
   

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


