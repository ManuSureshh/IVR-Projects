<html>
<%@ page import="java.io.InputStream,
				 java.io.IOException,
				 java.io.BufferedReader,
				 java.io.InputStreamReader,
                 com.avaya.sce.runtimecommon.*,
				 java.io.PrintWriter,
				 java.net.*,
				 java.util.Enumeration,
                 com.avaya.ade.common.utils.io.IO,
				 java.util.Properties,
                 java.lang.reflect.Method,
                 com.avaya.weblm.*,
				 java.util.StringTokenizer"
   session="false" %>
<%@ include file="validate-common.jsp" %>
<%
String applicationName = request.getParameter( PROPERTY_APP_NAME );
if (applicationName != null) {
	applicationName = cleanString(applicationName);
}
String valtype="Interaction Center (Optional)";
showConnectorInfo = true;
path = "<B><I>&lt;Eclipse home&gt;</I>/plugins/com.avaya.sce.ic.ui_<I>&lt;version number&gt;</I>/data</B>";
%> 
<%@ include file="validate-head.jsp" %>
	<table border="0" width="100%" id="table1">
		<tr>
			<td width="500" valign="top"><b>Interaction Center Connector</b><BR>
			    <I>(Required if application uses IC functions)<BR></I>
			    <SMALL>Check <%=SCERT.PRODUCT_NAME_SHORT%> documentation for IC Connector 
			    installation instructions.</SMALL>
            </td>
			<td>
            <%
            	URL srcURL = null;
    		    srcURL = new URL(request.getRequestURL().toString());
            	String ICResponse = "error";
            	//newer method is to print the version #.  If ICC doesn't support, fall back
            	//to the request id (old method). 
            	//NOTE: that we have different success messages depending on method
			    try {
            		String reqURL = "http://" + srcURL.getHost() + ":" + srcURL.getPort() + "/icconnector/ICVersionServer";            		
       			    URL urlRequestID = new URL( reqURL);
	    	        InputStream inputStream  =  (InputStream)urlRequestID.getContent();
       			    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	            	ICResponse = reader.readLine();
        		} catch(Exception e) {
        			//do nothing
		        }
        		//if we have an error try the old method of just looking for request id
		        if(!ICResponse.equals("error")) {
		        	String icVersion = request.getParameter( PROPERTY_ICC_VERSION );
		        	if (icVersion != null) {
		        		icVersion = cleanString(icVersion);
		        	}

					if(icVersion != null && icVersion.equals(ICResponse)){
						out.write( setColor("Found ", OKAY)+ "ICConnector servlet OK.  Running version:" + ICResponse +  ".  This version is compatible with the app.<br>");
					}
					else{
						if(icVersion != null){ 
				        	out.write( setColor("Warning ", WARN)+ "ICConnector servlet OK. Running version:" + ICResponse + ".  App expects ICConnector version:" + icVersion + ". NOTE: Newer versions of ICConnector are backward compatible.<br>");
						}
						else{
							out.write( setColor("Warning ", WARN)+ "ICConnector servlet OK. Running version:" + ICResponse + ".  App expects ICConnector version:unknown or not obtainable<br>");
						}
					}
			    } else {
			    	try {            		
		        		String reqURL = "http://" + srcURL.getHost() + ":" + srcURL.getPort() + "/icconnector/RequestID";
	       			    URL urlRequestID = new URL( reqURL);
		    	        InputStream inputStream  =  (InputStream)urlRequestID.getContent();
	       			    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		            	ICResponse = reader.readLine();
	        		} catch(Exception e) {
	        			//do nothing
			        }
			        if(ICResponse.equals("error")) {
				        out.write( setColor("Warning ", WARN)+ "ICConnector servlet is not setup or not running <br>");
				    } else {
			        	out.write( setColor("Found ", OKAY)+ "ICConnector servlet OK. <br>");
				    }
				}
            %>
            </td>
	  </tr>
	</table>
	</body>
</html>
