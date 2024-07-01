<html>
<%@ page import="java.io.InputStream,
				 java.io.IOException,
				 java.io.BufferedReader,
				 java.io.InputStreamReader,
				 java.io.PrintWriter,
                 com.avaya.sce.runtimecommon.*,
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

String valtype="CTI Computer Telephony (Optional)";
showConnectorInfo = true;
path = "<B><I>&lt;Eclipse home&gt;</I>/plugins/com.avaya.sce.cti.ui_<I>&lt;version number&gt;</I>/data</B>";
%> 
<%@ include file="validate-head.jsp" %>
	<table border="0" width="100%" id="table1">
	<tr>
		<td width="500" valign="top"><b>AES Connector</b><BR>
		    <I>(Required if application uses CTI functions)<BR></I>
		    <SMALL>Check <%=SCERT.PRODUCT_NAME_SHORT%> documentation for AES Connector 
		    installation instructions.</SMALL>
        </td>
		<td>
            <%
            	String ctiResponse = "error";
		try {
          	URL srcURL = null;
			srcURL = new URL(request.getRequestURL().toString());
			String reqURL = "http://" + srcURL.getHost() + ":" + srcURL.getPort() + "/aesconnector/CTIConnectorServer";
			URL urlRequestID = new URL( reqURL);
			InputStream inputStream = (InputStream)urlRequestID.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			ctiResponse = reader.readLine();
        	} catch(Exception e) {
        		//do nothing
		}
        if(ctiResponse.equals("error")) {
	        out.write( setColor("Warning ", WARN)+ "AESConnector servlet is not setup or not running <br>");
		} else {
			//old method
			if(ctiResponse.equals("OK")){
				out.write( setColor("Found ", OKAY)+ "AESConnector servlet OK.<br>");				
			}
			//new method
			else{
				String ctiVersion = request.getParameter( PROPERTY_CTI_VERSION );
				if (ctiVersion != null) {
					ctiVersion = cleanString(ctiVersion);
				}

				if(ctiVersion != null && ctiVersion.equals(ctiResponse)){
					out.write( setColor("Found ", OKAY)+ "AESConnector servlet OK.  Running version:" + ctiResponse +  ".  This version is compatible with the app.<br>");
				}
				else{
					if(ctiVersion != null ){ 
			        	out.write( setColor("Warning ", WARN)+ "AESConnector servlet OK. Running version:" + ctiResponse + ".  App expects AESConnector version:" + ctiVersion + ". NOTE: Newer versions of AESConnector are backward compatible.<br>");
					}
					else{
						out.write( setColor("Warning ", WARN)+ "AESConnector servlet OK. Running version:" + ctiResponse + ".  App expects AESConnector version:unknown or not obtainable<br>");
					}
				}
			}
		}
            %>
            </td>
	  </tr>
	</table>
	</body>
</html>
