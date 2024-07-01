<html>
<%@ page import="java.io.*,
				 java.net.*,
				 java.util.*,
				 com.avaya.sce.runtimecommon.*,
                 java.lang.reflect.Method,
                 com.avaya.ade.common.utils.io.IO,
				 com.avaya.sce.runtime.*,
				 com.avaya.sce.runtime.perf.*"
   session="false" %>
<%@ include file="validate-common.jsp" %>   
<%  
	
	//Determine the counter type and title
 	String counterType = request.getParameter("type");
	if (counterType == null) {
		counterType = "";
	} else {
		counterType = cleanString(counterType);
	}
	
	String counterTableTitle = Performance.getDescriptionFromType(counterType);
	if (counterTableTitle == null) {
		counterTableTitle = "";
	}
	
	//End determine counter type and title
    String applicationName = request.getParameter( "appName" );
    if(applicationName==null){
        applicationName="";
    } else {
    	applicationName = cleanString(applicationName);
	}
    
    String enable = (String)request.getParameter( "Enable" );
    String disable = (String)request.getParameter( "Disable" );
    String reset = (String)request.getParameter( "Reset" );
    
    if ( (enable != null) && (enable.equals("Enable")==true) ) {  
        Performance.setEnabled( true );
    } else {
    	enable = "";
    }
    if ( (disable != null) && (disable.equals("Disable")==true) ) {
        Performance.setEnabled( false );
    } else {
    	disable = "";	
    }
    if ( (reset != null) && (reset.equals("Reset")==true) ) {
        Performance.clearAll();
    } else {
    	reset = "";
    }
%>
 
	<head>
		<title><%=applicationName%> Counter: <%=counterTableTitle%></title>
	</head>
	<body bgcolor='#ffffff'>
    <form method="post" action="performance.jsp">
	<h1><%=applicationName%> Performance Monitoring</h1>
	
	<p>

	<table border="0" width="100%" id="table3">
<%
		Collection <String>types = Performance.getCounterTypes();
		int colCount = 0;
		for (String type : types ) {
			if (colCount == 0 ) {
				out.println("<tr>");				
			}
%>		
			<td><a href="?type=<%=type%>"><%=Performance.getDescriptionFromType(type)%></a></td>
<%			
			if (colCount == 3 ) {
				out.println("</tr>");				
			}
			colCount = (colCount + 1)% 4;
		}
%>
	</table>
	<hr>
    <h3><%=counterTableTitle%></h3>
    <table border="0" width="100%" id="table2">
        <tr>
        <td><b>Name</b></td>
        <td><b>Average</b></td>
        <td><b>Min </b></td>
        <td><b>Max </b></td>
        <td><b>Standard Deviation</b></td>
        <td><b>Total Samples</b></td>
        </tr>
<%
	HashMap<String, ICounter> servletBucket = Performance.getCounterType( counterType);
	if (servletBucket != null ) {
		for (Iterator iterator = servletBucket.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			ICounter counter = servletBucket.get(key);
%>
	    	<tr>
	            <td><%=key%></td>
	            <td><%=counter.getAverage()%></td>
	            <td><%=counter.getMin()%></td>
	            <td><%=counter.getMax()%></td>
	            <td><%=counter.getStandardDeviation()%></td>           
	            <td><%=counter.getTotalSamples()%></td>
	        </tr>
<%
		}
	}
%>
    </table>   
<%
if ( Performance.isEnabled()== true ) {
%>
    <input name="Disable" type="submit" value="Disable"/>
<%
} else {
%>
    <input name="Enable" type="submit" value="Enable"/>
<%
}
%>
    <input name="Refresh" type="submit" value="Refresh"/>
    <input name="Reset" type="submit" value="Reset"/>
    <input name="type" type="hidden" value="<%=counterType%>"/>
        </form>
    </body>
</html>


