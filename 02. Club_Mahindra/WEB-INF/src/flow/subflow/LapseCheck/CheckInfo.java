package flow.subflow.LapseCheck;

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
 * Last generated by Orchestration Designer at: 2023-FEB-16  12:57:24 PM
 */
public class CheckInfo extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2023-FEB-16  12:57:24 PM
	 */
	public CheckInfo() {
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
		com.avaya.sce.runtime.BooleanOperation bo1 = new com.avaya.sce.runtime.BooleanOperation(com.avaya.sce.runtime.BooleanOperation.OR);
		com.avaya.sce.runtime.Expression be1 = new com.avaya.sce.runtime.Expression("expression1", "Inventory:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "1", false);
		bo1.addExpression(be1);
		com.avaya.sce.runtime.Expression be2 = new com.avaya.sce.runtime.Expression("expression2", "PreCheckIn:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "1", false);
		bo1.addExpression(be2);
		com.avaya.sce.runtime.Expression be3 = new com.avaya.sce.runtime.Expression("expression3", "BookingOpen:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "1", false);
		bo1.addExpression(be3);
		com.avaya.sce.runtime.BooleanOperation bo2 = new com.avaya.sce.runtime.BooleanOperation(com.avaya.sce.runtime.BooleanOperation.OR);
		com.avaya.sce.runtime.Expression be4 = new com.avaya.sce.runtime.Expression("expression4", "Comp:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOMATCH", false);
		bo2.addExpression(be4);
		com.avaya.sce.runtime.Expression be5 = new com.avaya.sce.runtime.Expression("expression5", "Comp:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOINPUT", false);
		bo2.addExpression(be5);
		com.avaya.sce.runtime.Expression be6 = new com.avaya.sce.runtime.Expression("expression6", "Inventory:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOMATCH", false);
		bo2.addExpression(be6);
		com.avaya.sce.runtime.Expression be7 = new com.avaya.sce.runtime.Expression("expression7", "Inventory:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOINPUT", false);
		bo2.addExpression(be7);
		com.avaya.sce.runtime.Expression be8 = new com.avaya.sce.runtime.Expression("expression8", "PreCheckIn:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOINPUT", false);
		bo2.addExpression(be8);
		com.avaya.sce.runtime.Expression be9 = new com.avaya.sce.runtime.Expression("expression9", "PreCheckIn:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOMATCH", false);
		bo2.addExpression(be9);
		com.avaya.sce.runtime.Expression be10 = new com.avaya.sce.runtime.Expression("expression10", "BookingOpen:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOINPUT", false);
		bo2.addExpression(be10);
		com.avaya.sce.runtime.Expression be11 = new com.avaya.sce.runtime.Expression("expression11", "BookingOpen:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NOMATCH", false);
		bo2.addExpression(be11);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Comp:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "1", false).setDebugId(291)).evaluate(mySession, bo1)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.Next("LapseCheck-LapseTransfer", "1").setDebugId(289));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition").setDebugId(295)).evaluate(mySession, bo2)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.Next("LapseCheck-Menu2", "NI/NM").setDebugId(296));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("LapseCheck-exit", "Default").setDebugId(294));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
