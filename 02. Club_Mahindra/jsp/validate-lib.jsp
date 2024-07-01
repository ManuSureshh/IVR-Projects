<html>
<%@ page import="java.io.InputStream,
				 java.io.IOException,
				 java.io.BufferedReader,
				 java.io.InputStreamReader,
				 java.io.PrintWriter,
				 java.net.*,
                 com.avaya.sce.runtimecommon.*,
				 java.util.Enumeration,
				 java.util.Properties,
                 com.avaya.ade.common.utils.io.IO,
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
String valtype="Libraries";
%> 
<%@ include file="validate-head.jsp" %>
	<P><B>NOTE:</B> These required libraries must be manually installed and are avaliable from the <b>runtimesupport.zip</b>, which is provided with <%=SCERT.PRODUCT_NAME_SHORT%>.  This .zip file is located in the directory <B><I>&lt;Eclipse home&gt;</I>/plugins/com.avaya.sce.core_<I>&lt;version number&gt;</I></B>, where <I>&lt;Eclipse home&gt;</I> is the directory in which you installed the Eclipse and <%=SCERT.PRODUCT_NAME_SHORT%> software, and <I>&lt;version number&gt;</I> is the version number of the <%=SCERT.PRODUCT_NAME_SHORT%> release.<BR>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Please refer to the <%=SCERT.PRODUCT_NAME_SHORT%> documentation, Chapter 13 <i>&quot;Application Deployment&quot;</i> in the section titled <i>&quot;Preparing the application server to run <%=SCERT.PRODUCT_NAME_SHORT%> applications&quot;</i>, for instructions on how to install these libraries.
	</P>
	
	<table border="0" width="100%" id="table1">
		<tr>
			<td width="150" valign="top">Logging:</td>
			<td>
            <%
            probeClass( out, setColor("Error ", ERROR), "org.apache.log4j.Layout",
            "log4j-1.2.15.jar",
            "Log4j",
            "Application may not run",
            "http://jakarta.apache.org/log4j");
            %>
            </td>
		</tr>
		<tr>
			<td width="150" valign="top">Logging <Experience Portal>:</td>
			<td>
            <%
            probeClass( out, setColor("Error ", ERROR), "com.avaya.vp.applog.client.ReportWriter",
            "VPAppLogClient_7.2.3.jar",
            "Experience Portal Logging Client",
            "Application may not run",
            "http://support.avaya.com");
            %>
            </td>
		</tr>
		<tr>
			<td width="150" valign="top">Licensing:</td>
			<td>
            <%
            probeClass( out, setColor("Error ", ERROR), "com.avaya.weblm.LicensedProduct",
            "weblm.jar",
            "Avaya Web License Manager",
            "Application may not run",
            "http://support.avaya.comx");
            %>
            </td>
		</tr>
		<tr>
			<td width="150" valign="top">Encoding:</td>
			<td>
            <%
            probeClass( out, setColor("Warning ", WARN), "org.apache.commons.codec.binary.Base64",
            "commons-codec-1.3.jar",
            "Encoding",
            "Application may not run",
            "http://jakarta.apache.org/commons");
            %>
            </td>
		</tr>
	</table>
	</body>
</html>
