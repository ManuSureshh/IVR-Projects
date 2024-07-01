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
<%!
String applicationName;
String PROPERTY_AXIS14 = "axis14";
String PROPERTY_AXIS2 = "axis2";
String propAxis14;
String propAxis2;
%> 

<%
applicationName = request.getParameter( PROPERTY_APP_NAME );
if (applicationName != null) {
	applicationName = cleanString(applicationName);
}
String valtype="Client Web Services (Optional)";

propAxis14 = request.getParameter( PROPERTY_AXIS14 );
if (propAxis14 != null) {
	propAxis14 = cleanString(propAxis14);
}

propAxis2 = request.getParameter( PROPERTY_AXIS2 );                        
if (propAxis2 != null) {
	propAxis2 = cleanString(propAxis2);
}
%> 
<%!
public String getWSURL( javax.servlet.http.HttpServletRequest request, boolean axis14, boolean axis2) {
	
	if(axis14 || axis2) {
		String url = request.getRequestURI() + '?' + PROPERTY_APP_NAME + "=" + applicationName;
		String name = "";
		
		if(axis14) {
			name += "Axis 1.4";
			url += "&" + PROPERTY_AXIS14 + "=true";
		}
		
		if(axis2) {
			if(name.length() > 0) {
				name += " and ";
			}
				
			name += "Axis 2";
			url+= "&" + PROPERTY_AXIS2 + "=true";
		}
		
		return "<a href=\"" +  url + "\">" +  name + "</a>";
	} else {
		return "Axis Not Required";
	}
}
%>

<%@ include file="validate-head.jsp" %>
    <br/><br/>
    In the table below find the row matching the web service connector your project is using and the column matching the version of the VP system your application logging is targeting.
    <br/>
     Then click the cell and a check for the Axis version(s) will be made. 
    <br/>
    <table border="1">
    	<tr><td>&nbsp;</td><td>No App Logging</td><td>Older than 5.1</td><td>5.1 or later</td></tr>
    	<tr><td>No Web Service Connector</td><td><%=getWSURL(request, false, false)%></td><td><%=getWSURL(request, true, false)%></td><td><%=getWSURL(request, false, true)%></td></tr>
    	<tr><td>Axis 1.4 Web Service Connector</td><td><%=getWSURL(request, true, false)%></td><td><%=getWSURL(request, true, false)%></td><td><%=getWSURL(request, true, true)%></td></tr>
    	<tr><td>Axis 2.0 Web Service Connector</td><td><%=getWSURL(request, false, true)%></td><td><%=getWSURL(request, true, true)%></td><td><%=getWSURL(request, false, true)%></td></tr>
    	<tr><td>Axis 1.4 and Axis 2.0 Web Service Connector</td><td><%=getWSURL(request, true, true)%></td><td><%=getWSURL(request, true, true)%></td><td><%=getWSURL(request, true, true)%></td></tr>
    <table/>
    
<% if(propAxis14 != null) { %>
	<br/>    
	<table border="0" width="100%" id="table1">
		<tr> 
            <td><b>Axis 1.4</b><hr/></td>
		</tr>
		<tr> 
            <td>
            <%
            probeClass(out, setColor("Warning ", WARN), "org.apache.axis.Version", 
            "axis.jar",
            "Apache-Axis",
            "Web Services will not work",
            "http://xml.apache.org/axis/");
            %>
            </td>
		</tr>
            
		<tr> 
            <td>
            <%
            probeClass(out, setColor("Warning ", WARN), "javax.xml.rpc.Service",
            "jaxrpc.jar",
            "JAX-RPC API",
            "Web Services will not work",
            "http://xml.apache.org/axis/");
            %>
            </td>
		</tr>
            
		<tr> 
            <td>
            <%
            probeClass(out, setColor("Warning ", WARN), "org.apache.commons.discovery.ResourceDiscover", 
            "commons-discovery.jar",
            "Apache-Axis",
            "Web Services will not work",
            "http://jakarta.apache.org/commons");
            %>
            </td>
		</tr>
            
		<tr> 
            <td>
            <%
            probeClass(out, setColor("Warning ", WARN), "org.apache.commons.logging.LogFactory", 
            "commons-logging-1.1.3.jar",
            "Apache-Axis",
            "Web Services will not work",
            "http://jakarta.apache.org/commons");
            %>
            </td>
		</tr>
            
		<tr> 
            <td>
            <%
            probeClass(out, setColor("Warning ", WARN), "javax.activation.DataSource", 
            "activation-1.1.jar",
            "Apache-Axis",
            "Web Services will not work",
            null);
            %>
            </td>
		</tr>
            
		<tr> 
            <td>
            <%
            probeClass(out, setColor("Warning ", WARN), "javax.xml.soap.SOAPBody", 
            "saaj.jar",
            "Apache-Axis",
            "Web Services will not work",
            "http://xml.apache.org/axis/");
            %>
            </td>
		</tr>

		<tr> 
            <td>
            <%
            probeClass(out, setColor("Warning ", WARN), "javax.wsdl.PortType", 
            "wsdl4j-1.6.2.jar",
            "Apache-Axis",
            "Web Services will not work",
            "http://xml.apache.org/axis/");
            %>
            </td>
		</tr>
	</table>
<% } %>
<% if(propAxis2 != null) { %>
	<br/>    
	<table border="0" width="100%" id="table1">
		<tr> 
			<td><b>Axis 2</b><hr/></td>
		</tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.commons.logging.LogFactory", "commons-logging-1.1.3.jar", "Apache-Axis", "Web Services will not work", "http://jakarta.apache.org/commons");%></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "javax.activation.URLDataSource", "activation-1.1.jar", "Apache-Axis2", "Web Services will not work", null);%></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axiom.soap.SOAPVersion","axiom-api-1.2.13.jar", "Apache-Axis2", "Web Services will not work", null);%></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axiom.soap.impl.dom.SOAPTextImpl", "axiom-dom-1.2.13.jar", "Apache-Axis2", "Web Services will not work",null);%></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axiom.om.impl.llom.OMTextImpl", "axiom-impl-1.2.13.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axis2.rpc.client.RPCServiceClient", "axis2-adb-1.6.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axis2.schema.XSD2Java", "axis2-adb-codegen-1.6.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axis2.wsdl.WSDL2Java", "axis2-codegen-1.6.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axis2.Version", "axis2-kernel-1.6.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axis2.saaj.TextImplEx", "axis2-saaj-1.6.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axis2.transport.http.TransportHeaders", "axis2-transport-http-1.6.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.axis2.transport.local.LocalTransportSender", "axis2-transport-local-1.6.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.commons.httpclient.Wire", "commons-httpclient-3.1.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "javax.xml.stream.util.XMLEventAllocator", "geronimo-stax-api_1.0_spec-1.0.1.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.http.StatusLine", "httpcore-4.0.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "javax.mail.URLName", "mail-1.4.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.neethi.Policy", "neethi-3.0.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.woden.ErrorInfo", "woden-api-1.0M9.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.woden.tool.converter.Convert", "woden-impl-dom-1.0M9.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "javax.wsdl.Import", "wsdl4j-1.6.2.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.ws.security.WSDocInfo", "wss4j-1.5.8.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.codehaus.stax2.DTDInfo", "wstx-asl-3.2.9.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "org.apache.ws.commons.schema.utils.XDOMUtil", "XmlSchema-1.4.7.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
		<tr><td><%probeClass(out, setColor("Warning ", WARN), "javax.xml.crypto.dom.DOMURIReference", "xmlsec-1.4.3.jar", "Apache-Axis2", "Web Services will not work", null); %></td></tr>
	</table>
<% } %>	
	
	</body>
</html>

