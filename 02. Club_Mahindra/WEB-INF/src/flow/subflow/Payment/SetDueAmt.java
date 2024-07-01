package flow.subflow.Payment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.avaya.sce.runtimecommon.ITraceInfo;

import flow.IProjectVariables;

/**
 * A basic servlet which allows a user to define their code, generate
 * any output, and to select where to transition to next.
 * Last generated by Orchestration Designer at: 2022-DEC-01  05:37:24 PM
 */
public class SetDueAmt extends com.avaya.sce.runtime.BasicServlet {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2022-DEC-01  05:37:24 PM
	 */
	public SetDueAmt() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * This method allows for custom integration with other Java components.
	 * You may use Java for sophisticated logic or to integrate with custom
	 * connectors (i.e. JMS, custom web services, sockets, XML, JAXB, etc.)
	 *
	 * Any custom code added here should work as efficiently as possible to prevent delays.
	 * It's important to design your callflow so that the voice browser (Experienve Portal/IR)
	 * is not waiting too long for a response as this can lead to a poor caller experience.
	 * Additionally, if the response to the client voice browser exceeds the configured
	 * timeout, the platform may throw an "error.badfetch". 
	 *
	 * Using this method, you have access to all session variables through the 
	 * SCESession object.
	 *
	 * The code generator will *** NOT *** overwrite this method in the future.
	 * Last generated by Orchestration Designer at: 2022-DEC-01  05:37:24 PM
	 */
	public void servletImplementation(com.avaya.sce.runtimecommon.SCESession mySession) {

		String config = getServletContext().getInitParameter("Configuration");
		
		Properties properties;
		try {
			properties = loadPropertyFile(config);

			String asfDueAmount = mySession
					.getVariableField(IProjectVariables.MEMBER_DETAILS, IProjectVariables.MEMBER_DETAILS_FIELD_ASF__DUE)
					.getStringValue();

			String asf = properties.getProperty("ASF");

			if (asf != null && !asf.isEmpty()) {
				asfDueAmount = asf;
			}

			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Flow | ASF due: " + asfDueAmount);

			String emiDue = mySession
					.getVariableField(IProjectVariables.MEMBER_DETAILS, IProjectVariables.MEMBER_DETAILS_FIELD_EMI__DUE)
					.getStringValue();


			String emi = properties.getProperty("EMI");
			if (emi != null && !emi.isEmpty()) {
				emiDue = emi;
			}

			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Flow | EMI due: " + emiDue);

			if (asfDueAmount != null && Double.valueOf(asfDueAmount) >= 0) {
				
				String hindiProps = getServletContext().getInitParameter("HINDI_PROPERTIES");
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "HindiProps: " + hindiProps);
				String propLoc = mySession.getVariableField(IProjectVariables.MAIN, IProjectVariables.MAIN_FIELD_PROPERTY_LOCATION).getStringValue();
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "language location: " + 
						propLoc);
				
				String asfAnn="";
				boolean isHindiLang = propLoc.equalsIgnoreCase(hindiProps);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "ASF, isHindiLang : " + 
						isHindiLang);
				if (isHindiLang) {
					asfAnn="CMH3002_1.wav*SS:" + asfDueAmount + ":numbers*CMH20002.wav";	
				}else {
					asfAnn = "CMH3002_1.wav*SS:" + asfDueAmount + ":numbers*CMH3002_2.wav";

				}
				
				mySession.getVariableField(IProjectVariables.PAYMENT,
						IProjectVariables.PAYMENT_FIELD_ASFDUE_ANN)
						.setValue(asfAnn);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Flow | asfAnn: " + asfAnn);

//				mySession.getVariableField(IProjectVariables.PAYMENT, IProjectVariables.PAYMENT_FIELD_DUE_ANN).setValue(true);

			}
			
			if (emiDue != null && Double.valueOf(emiDue) >= 0) {
				
				String hindiProps = getServletContext().getInitParameter("HINDI_PROPERTIES");
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "HindiProps: " + hindiProps);
				String propLoc = mySession.getVariableField(IProjectVariables.MAIN, IProjectVariables.MAIN_FIELD_PROPERTY_LOCATION).getStringValue();
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "language location: " + 
						propLoc);
				
				String emiAnn = "";

				boolean isHindiLang = propLoc.equalsIgnoreCase(hindiProps);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "EMI, isHindiLang : " + 
						isHindiLang);
				if (isHindiLang) {
					emiAnn = "CMH3003_1.wav*SS:" + emiDue + ":numbers*CMH20002.wav";
				} else {
					emiAnn = "CMH3003_1.wav*SS:" + emiDue + ":numbers*cmh999.wav";

				}
				
//				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_EMI__ANN)
//						.setValue(emiAnn);
				
				mySession.getVariableField(IProjectVariables.PAYMENT,
						IProjectVariables.PAYMENT_FIELD_EMIDUE_ANN)
						.setValue(emiAnn);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Flow | emiAnn: " + emiAnn);

				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_EMI).setValue(true);
			}
		} catch (IOException e) {
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Payment Flow | Exception: " + e);
		}


	}
	
	/**
	 * @param config
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static Properties loadPropertyFile(String config) throws FileNotFoundException, IOException {
		FileReader reader = null;
		reader = new FileReader(config);
		Properties properties = new Properties();
		properties.load(reader);
		return properties;
	}
	/**
	 * Builds the list of branches that are defined for this servlet object.
	 * This list is built automatically by defining Goto nodes in the call flow editor.
	 * It is the programmer's responsibilty to provide at least one enabled Goto.<BR>
	 *
	 * The user should override updateBranches() to determine which Goto that the
	 * framework will activate.  If there is not at least one enabled Goto item, 
	 * the framework will throw a runtime exception.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.  To modify the list
	 * of branches for the flow item, override:
	 *     <code>updateBranches(Collection branches, SCESession mySession)</code>
	 *
	 * @return a Collection of <code>com.avaya.sce.runtime.Goto</code>
	 * objects that will be evaluated at runtime.  If there are no gotos
	 * defined in the Servlet node, then this returns null.
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:24 PM
	 */
	public java.util.Collection getBranches(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Goto aGoto = null;
		list = new java.util.ArrayList(1);

		aGoto = new com.avaya.sce.runtime.Goto("Payment-IsPayDue", 0, true, "Default");
		list.add(aGoto);

		return list;
	}
}
