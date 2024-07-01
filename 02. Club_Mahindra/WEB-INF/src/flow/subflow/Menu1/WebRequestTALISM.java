package flow.subflow.Menu1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.avaya.sce.runtimecommon.ITraceInfo;

import flow.IProjectVariables;

/**
 * A basic servlet which allows a user to define their code, generate
 * any output, and to select where to transition to next.
 * Last generated by Orchestration Designer at: 2022-NOV-25  02:55:46 PM
 */
public class WebRequestTALISM extends com.avaya.sce.runtime.BasicServlet {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2022-NOV-25  02:55:46 PM
	 */
	public WebRequestTALISM() {
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
	 * Last generated by Orchestration Designer at: 2022-NOV-25  02:55:46 PM
	 */
	public void servletImplementation(com.avaya.sce.runtimecommon.SCESession mySession) {

		String asfDueAmount = mySession.getVariableField(IProjectVariables.MEMBER_DETAILS,
				IProjectVariables.MEMBER_DETAILS_FIELD_ASF__DUE)
		.getStringValue();
		
		String config = getServletContext().getInitParameter("Configuration");

		try {
			Properties properties = loadPropertyFile(config);

			String asf = properties.getProperty("ASF");

			if (asf != null && !asf.isEmpty()) {
				asfDueAmount = asf;
			}

			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Menu2 | ASF due: " + asfDueAmount);

			String emiDue = mySession
					.getVariableField(IProjectVariables.MEMBER_DETAILS, IProjectVariables.MEMBER_DETAILS_FIELD_EMI__DUE)
					.getStringValue();

			String emi = properties.getProperty("EMI");
			if (emi != null && !emi.isEmpty()) {
				emiDue = emi;
			}

			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Menu2 | EMI due: " + emiDue);

			if (asfDueAmount != "" && asfDueAmount != null && Double.valueOf(asfDueAmount) > 0 && emiDue != ""
					&& emiDue != null && Double.valueOf(emiDue) >= 0) {
				String bothAnn = "CMH3001_1.wav*SS:" + asfDueAmount + ":currency*CMH3001_2.wav*SS:" + emiDue
						+ ":currency*CMH3001_3.wav";
				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_BOTH_ANN)
						.setValue(bothAnn);

				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Menu2 | bothAnn: " + bothAnn);

				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_EMI).setValue(true);
				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_ASF).setValue(true);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offer Flow Response | Both are due");
				return;
			} else if (asfDueAmount != "" && asfDueAmount != null && Double.valueOf(asfDueAmount) > 0) {
				String asfAnn = "CMH3002_1.wav*SS:" + asfDueAmount + ":currency*we_have_sent.wav";
				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_ASF__ANN)
						.setValue(asfAnn);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Menu2 | asfAnn: " + asfAnn);

				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_ASF).setValue(true);
				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_EMI)
						.setValue(false);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offer Flow Response | asf is due ");

			} else if (emiDue != "" && emiDue != null && Double.valueOf(emiDue) > 0) {
				String emiAnn = "CMH3003_1.wav*SS:" + emiDue + ":currency*CMH3003_2.wav";
				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_EMI__ANN)
						.setValue(emiAnn);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Menu2 | emiAnn: " + emiAnn);
				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_ASF)
						.setValue(false);
				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_EMI).setValue(true);
				mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Offer Flow Response | emi is due ");
			} else {

				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_EMI)
						.setValue(false);
				mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_ASF)
						.setValue(false);
			}
		} catch (IOException e) {
			mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, "Exception MENU1 " + e);
			mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_EMI).setValue(false);
			mySession.getVariableField(IProjectVariables.MENU_1, IProjectVariables.MENU_1_FIELD_ASF).setValue(false);

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
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:22 PM
	 */
	public java.util.Collection getBranches(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Goto aGoto = null;
		list = new java.util.ArrayList(1);

		aGoto = new com.avaya.sce.runtime.Goto("Menu1-BothAsfEMICheck", 0, true, "Default");
		list.add(aGoto);

		return list;
	}
}
