package flow.subflow.Offer;

/**
 * Class that represents a call to a reusable application.
 * Last generated by Orchestration Designer at: 2023-FEB-15  02:54:20 PM
 */
public class OfferTransfer extends com.avaya.sce.runtime.Invoke {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2023-FEB-15  02:54:20 PM
	 */
	public OfferTransfer() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		setNeedsDefaultDisconnectHandler(false);
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns a collection of Parameters that has information about the
	 * parameters to pass to the reusable module.  If it has
	 * no inputs, then an empty list is returned
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:24 PM
	 */
	public java.util.Collection getInputParams(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Parameter param = null;

		throw new com.avaya.sce.runtimecommon.SCERuntimeException("Module \"MITDM\" was not accessable in the development environment at code generation time. Unable to determine the input parameters for the dialog.");
	}
	/**
	 * Returns a collection of strings that are the names of the output parameters
	 * of the reusable application being invoked.  If it has no outputs, then an
	 * empty list is returned
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:24 PM
	 */
	public java.util.Collection getOutputParams(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;

		throw new com.avaya.sce.runtimecommon.SCERuntimeException("Module \"MITDM\" was not accessable in the development environment at code generation time. Unable to determine the output parameters for the dialog.");
	}
	/**
	 * Returns the name of the next form in the application
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:24 PM
	 */
	public String getNext() {
		return("Offer-CallTransfer");
	}
	/**
	 * Returns the entry point URL to the application being invoked.
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:24 PM
	 */
	public String getWebAppEntryPoint(com.avaya.sce.runtimecommon.SCESession mySession) {
		throw new com.avaya.sce.runtimecommon.SCERuntimeException("Module \"MITDM\" was not accessable in the development environment at code generation time. Unable to determine the entry point for the dialog.");
	}
	/**
	 * This method is generated automatically and should not be manually edited.
	 * To manually edit the event handlers for the node, override:
	 *    void updateEvents(Collection events, SCESession mySession)
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:24 PM
	 * @return a collection of Events
	 */
	public java.util.Collection getEvents(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list;
		com.avaya.sce.runtime.Event event;
		list = new java.util.ArrayList();
		java.util.List eventPromptNames = null;
		String ___tempPromptName = null;
		return(list);
	}
	
	
	
}
