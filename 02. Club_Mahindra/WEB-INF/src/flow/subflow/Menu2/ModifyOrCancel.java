package flow.subflow.Menu2;

/**
 * This servlet is used to forward the request to the entry point of a
 * project callflow (subflow).
 * Last generated by Orchestration Designer at: 2023-MAR-29  12:30:13 PM
 */
public class ModifyOrCancel extends com.avaya.sce.runtime.Subflow {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2023-MAR-29  12:30:13 PM
	 */
	public ModifyOrCancel() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the name of the subflow that is being invoked.  This name is used for
	 * determining the URL mapping for the the entry point of the subflow..
	 *
	 * @return the name of the subflow
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:23 PM
	 */
	protected String getSubflowName() {
		return("ModifyOrCancel");
	}
	/**
	 * Returns the name of the mapping of sub flow exit points to the URL mappings
	 * of the servlets to return back to in the calling flow.
	 *
	 * @return map of sub flow exit points to servlets in the calling flow.
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:23 PM
	 */
	protected java.util.Map<String,String> getExitPoints() {
		java.util.Map<String, String> exitPoints;
		exitPoints = new java.util.HashMap<String, String>();
		exitPoints.put("ModifyOrCancel-exit", "Menu2-exit");
		exitPoints.put("ModifyOrCancel-CallTransfer", "Menu2-CallTransfer");
		exitPoints.put("ModifyOrCancel-Menu2Menu", "Menu2-UserMenu");
		return exitPoints;
	}
}