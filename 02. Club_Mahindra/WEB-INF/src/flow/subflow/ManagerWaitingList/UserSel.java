package flow.subflow.ManagerWaitingList;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: 2023-FEB-21  10:06:46 AM
 */
public class UserSel extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2023-FEB-21  10:06:46 AM
	 */
	public UserSel() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:22 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = null;
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:22 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2023-SEP-05  01:01:22 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "MnGWL:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "1", false).setDebugId(503)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ManagerWaitingList-WaitingList", "1").setDebugId(501));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "MnGWL:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "2", false).setDebugId(504)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ManagerWaitingList-WaitingListMod", "2").setDebugId(505));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "MnGWL:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "3", false).setDebugId(506)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ManagerWaitingList-WaitingListCancel", "3").setDebugId(507));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "MnGWL:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "8", false).setDebugId(508)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ManagerWaitingList-Menu2", "8").setDebugId(509));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "MnGWL:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "9", false).setDebugId(512)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ManagerWaitingList-MnGWLTransfer", "9").setDebugId(513));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ManagerWaitingList-MnGWLRetry", "NI/NM").setDebugId(515));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}