<head>
	<title><%=applicationName%> <%=valtype%> Validation Page</title>
</head>
<body bgcolor='#ffffff'>
<h2><%=applicationName%></h2>
<hr>
<font size=4><b><%=valtype%></b></font>&nbsp;&nbsp;&nbsp;&nbsp;<a href="validate.jsp">Back</a>

<%
if ( showConnectorInfo == true ) {
%>
	<P><B>NOTE:</B> This connector must be manually installed and is avaliable 
    with <%=SCERT.PRODUCT_NAME_SHORT%>.  This connector is a web applications that must be 
    installed on <B><I>this</I></B> application server.  The deployable web application is located
    with <%=SCERT.PRODUCT_NAME_SHORT%> in the directory <%=path%>, where <I>&lt;Eclipse home&gt;</I> is the directory in which you installed the Eclipse and <%=SCERT.PRODUCT_NAME_SHORT%> software, and <I>&lt;version number&gt;</I> is 
    the version number of the <%=SCERT.PRODUCT_NAME_SHORT%> release.<BR><br>
	Please refer to the <%=SCERT.PRODUCT_NAME_SHORT%> 
    documentation, Chapter 13 <i>&quot;Application Deployment&quot;</i> in the section titled <i>&quot;Preparing 
    the application server to run <%=SCERT.PRODUCT_NAME_SHORT%> applications&quot;</i>, for instructions on how to install 
    this connector web application.
	</P>
<%
}
%>