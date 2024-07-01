<html>
<%@ page import="java.net.*,				 
				 java.util.*,
           		 com.avaya.weblm.*,
           		 java.io.InputStream,
				 java.io.IOException,
				 java.io.BufferedReader,
				 java.io.InputStreamReader,
				 com.avaya.sce.runtimecommon.*,
				 java.io.PrintWriter,				 
           		 java.lang.reflect.Method,                 						 	
                 com.avaya.ade.common.utils.io.IO,
				 java.sql.DatabaseMetaData,
				 com.avaya.sce.runtime.jdbc.Database,
				 com.avaya.sce.runtime.connectivity.db.DBParam"				
   session="false" %>
<%@ include file="validate-common.jsp" %>
<%
String applicationName = request.getParameter( PROPERTY_APP_NAME );
if (applicationName != null) {
	applicationName = cleanString(applicationName);
}
String dbtype = request.getParameter( "dbtype" );
if ( dbtype == null ) {
    dbtype = "";
}
String valtype="Database Connectivity (Optional)";
	
%> 
<%@ include file="validate-head.jsp" %>

    <form name="dbform" method="post" action="validate-db.jsp?appName=<%=applicationName%>">
    	<b>Validate Jar Files Used by Tomcat for Connection Pooling:</b>
    	<br>
    	<i>Ignore this section if your application server is not Tomcat 5.0.xx.</i>
    	<table border="0" width="100%" id="commons">
    		<tr>
                <td>
                <%
                probeClass(out, setColor("Warning ", WARN), "org.apache.commons.dbcp.PoolableConnection", 
                "commons-dbcp-1.2.1.jar",
                "Apache-Commons DBCP (Database Connection Pooling)",
                "Database connectivity will not work",
                "http://jakarta.apache.org/commons/dbcp/");
                %>
                </td>
    		</tr>
                 
    		<tr>
                <td>
                <%
                probeClass(out, setColor("Warning ", WARN), "org.apache.commons.pool.PoolableObjectFactory", 
                "commons-pool-1.2.jar",
                "Apache-Commons Pool, object pooling",
                "Database connectivity will not work",
                "http://jakarta.apache.org/commons/pool/");
                %>
                </td>
    		</tr>  
    		
		<tr>
		<td>
		<%
		probeClass(out, setColor("Warning ", WARN), "org.apache.commons.collections.SequencedHashMap", 
		"commons-collections-3.1.jar",
		"Jakarta-Commons Collections",
		"Database connectivity will not work",
		"http://jakarta.apache.org/commons/collections/");
		%>
		</td>
    		</tr>  
    	</table>
    	<br>
    	<i>Ignore this section if your application server is not Tomcat 5.5.xx or above</i>
    	<table border="0" width="100%" id="commons">
    		<tr>
                <td>
                <%
                probeClass(out, setColor("Warning ", WARN), "org.apache.tomcat.dbcp.dbcp.PoolableConnection", 
                "naming-factory-dbcp.jar;tomcat-dbcp.jar",
                "Apache-Commons DBCP (Database Connection Pooling)",
                "Database connectivity will not work",
                "http://jakarta.apache.org/commons/dbcp/");
                %>
                </td>
    		</tr>
    	</table>
        <br>
        <br>
        <b>JDBC Drivers Installed:</b><br>
        <i>The following table lists all of the JDBC drivers specified in the project's data sources, 
        and tells you if each driver is installed in the application server. If the driver is not installed, 
        and the data source you configured in Dialog Desinger depends on it, you will need
        to manually copy the driver library file in the application server's classpath. For Tomcat, it's &lt;Tomcat&gt;/common/lib
        </i>
        
        <% 
        	List drivers = new ArrayList(5);
			//Retrieved all data sources configured for the app.
			Enumeration dsNames = application.getInitParameterNames();
			while (dsNames.hasMoreElements()){
				String name = (String)dsNames.nextElement();
				int index = name.indexOf(DBParam.NAMESPACE);
				if (!(index > -1))
					continue;
				else{
					String data = application.getInitParameter(name);
					DBParam dbParam = new DBParam(data);
					String driver = dbParam.getDriver();
					if (driver != null && !drivers.contains(driver))
						drivers.add(driver);
				}
			}
	        
         	if (drivers.size() == 0){
	           drivers.add("oracle.jdbc.OracleDriver");
	           drivers.add("com.microsoft.sqlserver.jdbc.SQLServerDriver");           
	           drivers.add("com.microsoft.jdbc.sqlserver.SQLServerDriver");
	           drivers.add("com.ibm.db2.jcc.DB2Driver"); 
         	}
        %>
        
        <table border='0'>
        <th><tr><td><b>Driver</b></td><td><b>Library</b></td><td><b>Found</b></td></tr></th>
        
        <% 
        Iterator it = drivers.iterator();
        while (it.hasNext() ){
        	String location = "";
        	String found = setColor("No (For JBoss, manually check if the drivers are deployed in the deployments directory)", ERROR);
        	String driver = (String)it.next(); 
        	Class clazz = classExists(driver);
        	if (clazz != null){
        		location = getLocation(clazz);
        		found = setColor("Yes", OKAY);
        	}
        %>
        	<tr><td><%=driver%>&nbsp;&nbsp;</td><td><%=location%>&nbsp;&nbsp;</td><td><%=found%></td></tr>
        <% } %>
        </table>
       
        <br><br>    
        <b>Validate Each Data Source You Have Added in <%=SCERT.PRODUCT_NAME_SHORT%>:</b><br>
        <i>First make sure all the data sources are listed; then select each data source, and click on the
        button to connect. If the connection is successfully, it will return some specific database information.
        In case the connection failed, you will get an exception track trace for diagnostic purpose.
        </i>
        <table border="0" id="datasource">
        	<tr>
        	<td>Database Sources:&nbsp;&nbsp;</td>
        	<td><select name="dbtype">
			<%
				//Retrieved all data sources configured for the app.
				Enumeration names = application.getInitParameterNames();
				while (names.hasMoreElements()){
					String name = (String)names.nextElement();
					int index = name.indexOf(DBParam.NAMESPACE);
					if (!(index > -1))
						continue;
					else
						name = name.substring(6);
			%>
					<option value="<%=name%>"><%=name%>

			<% 	
				} 
			%>
		</select></td>
		</td>
		<td><input type="button" value="go" onclick="document.dbform.submit();"></td>
	</table>
        <br>

	<% if (!dbtype.equals("")){
		Database db = null;
		try{
			db = new Database("jdbc/" + dbtype);
		}catch(Exception e){
			out.println("<font color='#FF0000'><pre>");
			out.println("There is a problem finding the context information for the data source you selected.");
			out.println("For Tomcat, make sure the context XML file is in the &lt;TOMCAT_HOME&gt;/conf/Catalina/localhost directory,");
			out.println("and the context information for the data source exists in the file;");
			out.println("for other application server, make sure you have defined the data sources in the admin console.");
			out.println("</pre></font>");
			return;
		}
		try{
			String paramName = DBParam.getParamName(dbtype);
			String data = application.getInitParameter(paramName);
			DBParam dbParam = new DBParam(data);
			if (dbParam.getUser().length() > 0){
				db.open(dbParam.getUser(), dbParam.getPassword());
			}else{
				db.open();
			}
			DatabaseMetaData metaData = db.getMetaData();
			out.println("<table border='0'>");
			out.println("<tr><td colspan='2'>Data source [" + dbtype + "] connected successfully</td></tr>");
			out.println("<tr><td><b>Product Name:</b></td>");
			out.println("<td>" + metaData.getDatabaseProductName() + "</td></tr>");
			out.println("<tr><td><b>Version:</b></td>");
			out.println("<td>" + metaData.getDatabaseProductVersion() + "</td></tr>");
			out.println("<tr><td><b>Driver Name:</b></td>");
			out.println("<td>" + metaData.getDriverName() + "</td></tr>");
			out.println("<tr><td><b>Driver Version:</b></td>");
			out.println("<td>" + metaData.getDriverVersion() + "</td></tr>");
			out.println("<tr><td><b>JDBC Version:</b></td>");
			out.println("<td>" + metaData.getJDBCMajorVersion() + "." + metaData.getJDBCMinorVersion() + "</td></tr>");
			out.println("</table>");      		      
      		}catch(Throwable e){      			
      			out.println("<font color='#FF0000'><pre>");
      			out.println(e.getClass().getName() + ": " + e.getMessage());
      			StackTraceElement elements[] = e.getStackTrace();
			for (int i=0; i<elements.length; i++){
				out.println("\t" + elements[i].toString());
			}
			out.println("</pre></font>");
      		}finally{
      			if (db != null){
      				db.close();
      			}
      		}
	}	
	%>

    </form>
	</body>
</html>
