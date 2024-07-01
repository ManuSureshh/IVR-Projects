<html>
<%@ page import="java.io.InputStream,
				 java.io.IOException,
				 java.io.BufferedReader,
				 java.io.InputStreamReader,
				 java.io.PrintWriter,
				 java.io.File,
				 java.net.*,
				 java.util.Enumeration,
				 java.util.Properties,
                 java.lang.reflect.Method,
                 com.avaya.weblm.*,
                 com.avaya.sce.runtimecommon.*,
                 com.avaya.sce.runtimecommon.License,
                 com.avaya.sce.runtimecommon.ILicense,                
                 com.avaya.sce.runtimecommon.Proxy,                
                 com.avaya.runtimecommon.platforms.Toolkit,
                 com.avaya.sce.runtimecommon.config.*,
                 com.avaya.ade.common.utils.io.IO,
                 com.avaya.ade.common.utils.security.BreezeUtil,
				 java.util.StringTokenizer"
   session="false" %>
<%@ include file="validate-common.jsp" %>
<%!
	// Constants

	// Application Information
	static final String applicationName = "CLUB_MAHINDRA";
	static final String applicationVersion = "1.0.0";	
	static final String entryPoint = "CLUB_MAHINDRA/Start";
	static final String buildFrameworkVersion = "08.11.08.01";
	static final String buildFrameworkCommonVersion = "08.11.08.01";
	static final String ICCVersion = "08.11.08.01";
	static final String CTIVersion = "08.11.08.01";

	static final String[][] dependencyDetails =  {
					{ "MITDM", "1.0.0", "08.11.08.01" },

		};
        
        	/**
	 *	Prepare properties for self.
	 **/
	 
	private String cavEnabled = "false";
			 
	private Properties getMyProperties()
	{
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_APP_NAME, applicationName);
		properties.setProperty(PROPERTY_APP_VERSION, applicationVersion);
		properties.setProperty(PROPERTY_ENTRYPOINT, entryPoint);
		properties.setProperty(PROPERTY_ICC_VERSION, ICCVersion);
		properties.setProperty(PROPERTY_CTI_VERSION, CTIVersion);

		if (dependencyDetails.length > 0 ) {
			String moduleNames = "";
			boolean first = true;
		
			for (int i = 0; i < dependencyDetails.length; i++) {
				if (first == true) {
					moduleNames += dependencyDetails[i][INDEX_NAME];
					first = false;
				} else {
					moduleNames += "|" + dependencyDetails[i][INDEX_NAME];
					
				}
			}		
			properties.setProperty(PROPERTY_APP_MODULES, moduleNames);
		}
		
		String ver;
        try {
            ver = getVersion( "com.avaya.sce.runtime.RuntimeVersion", "getVersion" );
        } catch ( Exception e ) {
            ver = "unknown";
        }
		properties.setProperty(PROPERTY_APP_FRAMEWORK_VERSION, ver);
		return properties;	
	}

	/**
	 *	Fetch properties for the module.
	 **/
	private Properties getModuleProperties(String moduleURL)
	{
		Properties properties;	
		try
		{
			URL url = new URL(moduleURL);
            InputStream inputStream  =  (InputStream)url.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		   	String information;
		   	while((information = reader.readLine()) != null) {
		   		if(information.indexOf(PROPERTY_APP_NAME) > -1) {
		   			break;
		   		}
		   	}
		   	if(information != null) {
				properties = decodeFromString(information);
		   	} else {
		   		properties = new Properties();
		   	}
		}
		catch (Exception e)
		{
			properties = new Properties();
		}
		return properties;
	}
	
	private String getJavaVersion() throws Exception {
		String javaVer;
        try {
        	javaVer = System.getProperties().getProperty("java.version");
        } catch ( Exception e ) {
        	javaVer = "unknown";
        }
		return javaVer;
	}

	private String getAxisVersion() throws Exception {
		String axisVer;
        try {
        	axisVer = getVersion("org.apache.axis.Version", "getVersion");
        } catch ( Exception e ) {
        	axisVer = "unknown";
        }
		return axisVer;
	}
	
	private String getAxis2Version() throws Exception {
		String axis2Ver;
        try {
        	axis2Ver = getVersion("org.apache.axis2.Version", "getVersion");
        } catch ( Exception e ) {
        	axis2Ver = "unknown";
        }
		return axis2Ver;
	}
	
	private boolean testTooManyJars(String className, String jarPrefix) {
    	String path = getJarLocationContainingClass(className);
    	if (path == null) {
    		return(false);
    	}
    	path = path.replaceAll("%20", " ");	// wi00360125 - path resolution fail if spaces converted to %20

    	File jarFile = new File(path);
    	File parent = jarFile.getParentFile();
    	System.out.println( parent.getAbsolutePath() );
	    File [] contents = parent.listFiles();
	    if(contents == null) {
	    	return false;	// wi00360125 - directory contents will be null if path resolution fails.
	    }
	    
		int count = 0;
		for (File file : contents) {
			System.out.println( file.getName() );
		    if (file.getName().startsWith(jarPrefix) == true && !file.getName().endsWith("index")) {//JBoss creates an index file with the same name for each jar in the module
		    	count++;
		    }
		}
		return(count > 1);
	}
	
	private String getJarforPrefix(String className, String jarPrefix) {
    	String path = getJarLocationContainingClass(className);
    	if (path == null) {
    		return("");
    	}
    	path = path.replaceAll("%20", " ");	// wi00360125 - path resolution fail if spaces converted to %20

    	File jarFile = new File(path);
    	File parent = jarFile.getParentFile();
    	System.out.println( parent.getAbsolutePath() );
	    File [] contents = parent.listFiles();
	    if(contents == null) {
	    	return "";	// wi00360125 - directory contents will be null if path resolution fails.
	    }
	    
		int count = 0;
		String name = "";
		for (File file : contents) {
			System.out.println( file.getName() );
		    if (file.getName().startsWith(jarPrefix) == true && !file.getName().endsWith("index")) {//JBoss creates an index file with the same name for each jar in the module
		    	count++;
		    	name = file.getName();
		    }
		}
		return(name);
	}


%> 
<%
if (request.getParameter(PROPERTY_INFORMATION) != null) {
	response.setContentType("text/plain");
	PrintWriter writer = response.getWriter();
	String responseString = encodeToString(getMyProperties());
	writer.println(responseString);
} else { 
    String actualFrameworkVersion;
	String actualFrameworkCommonVersion;
    try {
        actualFrameworkVersion = getVersion( "com.avaya.sce.runtime.RuntimeVersion", "getVersion" );
        if( actualFrameworkVersion.equals(buildFrameworkVersion) == true ) {
            actualFrameworkVersion = setColor(actualFrameworkVersion, OKAY );
        } else {
            if ( versionGreater(actualFrameworkVersion, buildFrameworkVersion) == true ) {
                actualFrameworkVersion = setColor(actualFrameworkVersion, WARN );
                actualFrameworkVersion += " warning, actual version is newer than the version this application was built with (" + buildFrameworkVersion + ").";
            } else {
                actualFrameworkVersion = setColor(actualFrameworkVersion, ERROR );
                actualFrameworkVersion += " actual version is older than the version this application was built with (" + buildFrameworkVersion + "), application may not work.";
            }
        }
    } catch (Exception e) {
        actualFrameworkVersion = "missing";
        actualFrameworkVersion = setColor(actualFrameworkVersion, ERROR );
    }
    
    try {
        actualFrameworkCommonVersion = getVersion( "com.avaya.sce.runtimecommon.RuntimeCommonVersion", "getVersion" );
        if( actualFrameworkCommonVersion.equals(buildFrameworkCommonVersion) == true ) {
            actualFrameworkCommonVersion = setColor(actualFrameworkCommonVersion, OKAY );
        } else {
            if ( versionGreater(actualFrameworkCommonVersion, buildFrameworkCommonVersion) == true ) {
                actualFrameworkCommonVersion = setColor(actualFrameworkCommonVersion, WARN );
                actualFrameworkCommonVersion += " warning, actual version is newer than the version this application was built with (" + buildFrameworkCommonVersion + ").";
            } else {
                actualFrameworkCommonVersion = setColor(actualFrameworkCommonVersion, ERROR );
                actualFrameworkCommonVersion += " actual version is older than the version this application was built with (" + buildFrameworkCommonVersion + "), application may not work.";
           }
        }
    } catch (Exception e) {
        actualFrameworkCommonVersion = "missing";
        actualFrameworkCommonVersion = setColor(actualFrameworkCommonVersion, ERROR );
    }

    
    String scertDups = "";
    if ( testTooManyJars("com.avaya.sce.runtime.AppDocument", "scert") == true ) {
    	scertDups = setColor( ", multiple scert-xxx.jars were detected: delete all old ones and restart your app server", ERROR );
    }
    
    String scertcommonDups = "";
    if ( testTooManyJars("com.avaya.sce.runtimecommon.SCESession", "scertcommon") == true ) {
    	scertcommonDups = setColor( ", multiple scertcommon-xxx.jars were detected: delete all old ones and restart your app server", ERROR );        	
    }
    
   String applogDups = "";
   String applogVersion = getJarforPrefix("com.avaya.vp.common.IDb", "VPAppLogClient_");
    if ( testTooManyJars("com.avaya.vp.common.IDb", "VPAppLogClient_") == true ) {
    	applogDups = setColor( ", multiple VPAppLogClient_xxx.jars were detected: delete all old ones and restart your app server", ERROR );
    }
%>
	<head>
		<title><%=applicationName%> Validation Page</title>
	</head>
	<body bgcolor='#ffffff'>
	<h1><%=applicationName%> Validation Page</h1>
	<h3>Application details</h3>
	<table border="0" width="100%" id="table1">
		<tr>
			<td width="350" valign="top">Application name:</td>
			<td><%=applicationName%></td>
		</tr>
		<tr>
			<td width="350" valign="top">Application version:</td>
			<td><%=applicationVersion%></td>
		</tr>
		<tr>
			<td width="350" valign="top">Framework runtime version (scert.jar) <%=scertDups%>:</td>
			<td><%=actualFrameworkVersion%></td>
		</tr>
		<tr>
			<td width="350" valign="top">Framework runtime common version (scertcommon.jar) <%=scertcommonDups%>:</td>
			<td><%=actualFrameworkCommonVersion%></td>
		</tr>
		<tr>
			<td width="350" valign="top">Application Logging Client version (VPAppLogClient_x.x.x.jar) <%=applogDups%>:</td>
			<td><%=applogVersion%></td>
		</tr>
		<tr>
			<td width="350" valign="top">Java version:</td>
			<td><%=getJavaVersion()%></td>
		</tr>
		<tr>
			<td width="350" valign="top">Axis/Axis2 version:</td>
			<td><%=getAxisVersion()%></td>
		</tr>
		<tr>
			<td width="350" valign="top"></td>
			<td><%=getAxis2Version()%></td>
		</tr>
		
		<TR><TD>&nbsp;</TD><TD>&nbsp;</TD></TR>
        <%
        /* pick up all the string values we need for html */
        //ServletContext context = this.getServletContext();
        IApplicationConfiguration appConfig = Toolkit.getConfig("");
        ILicenseConfig licenseConf = appConfig.getLicenseConfig();
        IProxySettings proxy = appConfig.getProxySettings();

        String runtimeASR = application.getInitParameter(com.avaya.sce.runtimecommon.SCERT.RUNTIME_ASR);
        String runtimeSSML = application.getInitParameter(com.avaya.sce.runtimecommon.SCERT.RUNTIME_SSML);
        String runtimePlatform = application.getInitParameter(com.avaya.sce.runtimecommon.SCERT.RUNTIME_PLATFORM);
        String runtimeNature = application.getInitParameter(com.avaya.sce.runtimecommon.SCERT.RUNTIME_NATURE);
        String useProxy = (proxy.useProxy()==true?"true":"false");
        String proxyHost = proxy.getProxyHost();
        String proxyPort = proxy.getProxyPort(); 
        String ignoreHosts = proxy.getNonProxyHosts();
        String useHTTPSProxy = (proxy.useProxySecure()==true?"true":"false");
        String proxyHTTPSHost = proxy.getSecureProxyHost();
        String proxyHTTPSPort = proxy.getSecureProxyPort();
        String ignoreHostsHTTPS = proxy.getSecureNonProxyHosts();
        String serverHost = licenseConf.getLicenseServerURL();
        String startLanguage = application.getInitParameter(com.avaya.sce.runtimecommon.SCERT.INITIAL_LANGUAGE);
        String host = "";
        String port = "";
        String protocol = "";
        String weblmUrl = "";
        boolean error = false;
        String cti = setColor( "Disabled", WARN);
        String ic = setColor( "Disabled", WARN);
        String runtime = setColor( "Disabled", WARN);
        
        //Get license server url in cache - this what DD apps are using.
        ILicense license = License.getCachedLicense();
        String cachedLicURL = null;
        String rtPlatform = runtimePlatform;
        if (license != null){
        	cachedLicURL = license.getLicServerURL();
        	if (cachedLicURL.indexOf("/WebLM/LicenseServer") < 0) {
        		if (cachedLicURL.endsWith("/")==true) {
					cachedLicURL = cachedLicURL + "WebLM/LicenseServer";
        		} else {
					cachedLicURL = cachedLicURL + "/WebLM/LicenseServer";        			
        		}
        	}
        }
        if (serverHost.equals("")== true) {
            runtime = setColor( "unknown", INFO );
            cti = setColor( "unknown", INFO );
            ic = setColor( "unknown", INFO );
            rtPlatform += setColor(" - License URL empty, using URL supplied by the VPMS when the application starts", INFO);
        } else {
	        try {
	            URL url = new URL(serverHost);
	            host = url.getHost();
	            port = Integer.toString(url.getPort());
	            protocol = url.getProtocol();
	        } catch (Exception e) {
	            error = true;
	        }
	        
	        /* build the url */
	    	weblmUrl = protocol + "://" + host + ":" + port + "/WebLM/LicenseServer";
	        if ( runtimePlatform.equals(com.avaya.sce.runtimecommon.SCERT.PLATFORM_DESKTOP) == true) {
	             /* desktop always enabled, skip the check */
	            runtime = setColor( "Enabled", OKAY );
	            cti = setColor( "Enabled - simulation only", OKAY );
	            ic = setColor( "Enabled - simulation only", OKAY );
	            rtPlatform += setColor ( " - warning license NOT VERIFIED, Desktop is always licensed", WARN );
	        } else {
	        	Proxy.setupProxy();
	            LicenseManager lm = new LicenseManager(weblmUrl);
	            LicensedFeature lf;
	
	            try {
	                lm.getProduct(com.avaya.sce.runtimecommon.ILicense.PRODUCT);
	                runtime = setColor( "Enabled", OKAY );
	            } catch (Exception e) {
	                runtime = setColor( "Error :" + e.toString(), ERROR );
	            }
	
	            try {
	                lf = lm.getFeature(com.avaya.sce.runtimecommon.ILicense.PRODUCT, com.avaya.sce.runtimecommon.ILicense.FEATURE_CTI_AVAYA);
	                if (lf.getValue().equalsIgnoreCase("1")) {
	                    cti = setColor( "Enabled", OKAY );
	                } 
	            } catch (Exception e) {
	                cti = setColor( "Error :" + e.toString(), ERROR );
	            }
	
	            try {
	                lf = lm.getFeature(com.avaya.sce.runtimecommon.ILicense.PRODUCT, com.avaya.sce.runtimecommon.ILicense.FEATURE_IC_AVAYA);
	                if (lf.getValue().equalsIgnoreCase("1")) {
	                    ic = setColor( "Enabled", OKAY );
	                }
	            } catch (Exception e) {
	                ic = setColor( "Error :" + e.toString(), ERROR );
	            }
	        }
        }
        /* color code the proxy use */
        if ( useProxy.equalsIgnoreCase("true" )== true ) {
            useProxy = setColor( useProxy, OKAY );
        } else {
            useProxy = setColor( useProxy, WARN );
        }

        if ( useHTTPSProxy.equalsIgnoreCase("true" )== true ) {
            useHTTPSProxy = setColor( useHTTPSProxy, OKAY );
        } else {
            useHTTPSProxy = setColor( useHTTPSProxy, WARN );
        }
        
        String desktopOnly = " - this setting is for simulation only, you may encounter problems";
        if ( runtimePlatform.equals(com.avaya.sce.runtimecommon.SCERT.PLATFORM_DESKTOP) ) {
            runtimePlatform = setColor(runtimePlatform , WARN) + desktopOnly;
        }  else {
            if ( valueInStringArray(SCERT.PLATFORM_TYPES, runtimePlatform) == false ) {
                runtimePlatform = setColor(runtimePlatform, ERROR) + " - invalid setting for runtime-Platfrom";
            }
        }
        if (runtimeASR != null) {
       	 	if ( runtimeASR.equals(com.avaya.sce.runtimecommon.SCERT.ASR_DISPLAY_DESKTOPMS) ) {
        	    runtimeASR = setColor(runtimeASR, WARN) + desktopOnly;
       	 	} else {
        	    if ( SCERT.ASR_TYPES_MAP.get(runtimeASR) == null ) {
        	        runtimeASR = setColor(runtimeASR, ERROR) + " - invalid setting for runtime-ASR";
        	    }
        	}
        }
        %>
        <TR><TD colspan="2"><b>Application Platform Settings (<i>if this app is called as a module by another app, the following settings will be ignored and inherited from the calling app at runtime. Make sure you verify the settings of the calling app.</i>)</b></TD></TR>
        <TR><TD>Start Language</TD><TD><%=startLanguage%></TD></TR>
        <TR><TD>Platform</TD><TD><%=runtimePlatform%></TD></TR>
        <% if (runtimeASR != null) {%>
        	<TR><TD>ASR</TD><TD><%=runtimeASR%></TD></TR>
        <%}%>
        <%if (runtimeSSML != null) {%>
        	<TR><TD>Use SSML</TD><TD><%=runtimeSSML%></TD></TR>
        <%}%>
        <% if (Boolean.parseBoolean(cavEnabled)) {%>    
        <TR>
        	<TD>Configurable Variables</TD>
        	<TD><a href="<%=request.getContextPath()%>/AdminVariableInfo">Enabled</a></TD>
        </TR>
        <% } %>
        <TR><TD>&nbsp;</TD><TD>&nbsp;</TD></TR>
        <TR><TD>WebLM URL</TD><TD><a href="<%=weblmUrl%>"><%=weblmUrl%></a></TD></TR>
        <% if (cachedLicURL != null && !cachedLicURL.equals(weblmUrl)){
		        out.print("<TR><TD><FONT color='FF9900'>Cached WebLM URL</TD><TD><a href='" + cachedLicURL + "'>" + cachedLicURL + "</a></TD></TR><TR>");
		        out.print("<TD colspan='2'><FONT color='FF9900'>The WebLM URL configured in the DD Admin does not match the Cached WebLM URL used by DD applications in the runtime environment. You may need to restart the app server.</TD></TR>");
        	}
       	%>
        <TR><TD>&nbsp;</TD><TD>&nbsp;</TD></TR>
        <TR><TD><b>License status for platform</b></TD><TD><%=rtPlatform%><TD></TD></TR>
        <TR><TD>Runtime</TD><TD><%=runtime%></TD></TR> 
        <% 	if (BreezeUtil.isBreezeHosted() == false) { %>
        <TR><TD>CTI</TD><TD><%=cti%></TD></TR> 
        <TR><TD>IC</TD><TD><%=ic%></TD></TR>
        <% } %>
        <TR><TD>&nbsp;</TD><TD>&nbsp;</TD></TR>
        <TR><TD><b>HTTP Proxy Settings</b></TD><TD></TD></TR> 
        <TR><TD>Use Proxy</TD><TD><%=useProxy%></TD></TR>
        <TR><TD>Host</TD><TD><%=proxyHost%></TD></TR>
        <TR><TD>Port</TD><TD><%=proxyPort%></TD></TR>
        <TR><TD>Ignore Hosts</TD><TD><%=ignoreHosts%></TD></TR>
        <TR><TD>&nbsp;</TD><TD>&nbsp;</TD></TR>
        <TR><TD><b>HTTPS Proxy Settings</b></TD><TD></TD></TR> 
        <TR><TD>Use Proxy</TD><TD><%=useHTTPSProxy%></TD></TR>
        <TR><TD>Host</TD><TD><%=proxyHTTPSHost%></TD></TR>
        <TR><TD>Port</TD><TD><%=proxyHTTPSPort%></TD></TR>
        <TR><TD>Ignore Hosts</TD><TD><%=ignoreHostsHTTPS%></TD></TR>
	</table>
	<p>
	<hr>
	<h3>Dependencies</h3>
	<P><B>NOTE:</B> These required libraries must be manually installed and are available from the <b>runtimesupport.zip</b>, which is provided with <%=SCERT.PRODUCT_NAME_SHORT%>.  This .zip file is located in the directory <B><I>&lt;Eclipse home&gt;</I>/plugins/com.avaya.sce.core_<I>&lt;version number&gt;</I></B>, where <I>&lt;Eclipse home&gt;</I> is the directory in which you installed the Eclipse and <%=SCERT.PRODUCT_NAME_SHORT%> software, and <I>&lt;version number&gt;</I> is the version number of the <%=SCERT.PRODUCT_NAME_SHORT%> release.<BR>
	<br>Please refer to the <%=SCERT.PRODUCT_NAME_SHORT%> documentation, Chapter 13 <i>&quot;Application Deployment&quot;</i> in the section titled <i>&quot;Preparing the application server to run <%=SCERT.PRODUCT_NAME_SHORT%> applications&quot;</i>, for instructions on how to install these libraries.
	</P>
	
	<table border="0" width="100%" id="table1">
    	<tr>
            <td>
            &nbsp;&nbsp;&nbsp;&nbsp;
            </td>
            <td>
            	<table border="0" width="100%" id="table1">
            		<tr>
            			<td width="350" valign="top"><a href="validate-lib.jsp?appName=<%=applicationName%>">Libraries</a></td>
            		</tr>
            		<tr>
            			<td width="350" valign="top"><a href="validate-ws.jsp?appName=<%=applicationName%>">Web Services</a></td>
            		</tr>
            		<%
            		// if application does not have DB connector enabled, do not expose the validate db page.
            		if(classExists("com.avaya.sce.runtime.jdbc.Database") != null) {
            			%>
	            		<tr>
	            			<td width="350" valign="top"><a href="validate-db.jsp?appName=<%=applicationName%>">Database</a></td>
	            		</tr>
	            		<%
            		}
            		if (runtimeNature != null) {
            		   if ((runtimeNature.equalsIgnoreCase(SCERT.RUNTIME_NATURE_SPEECH) == true) && (BreezeUtil.isBreezeHosted() == false)) {
            		%>
            		<tr>
            			<td width="350" valign="top"><a href="validate-IC.jsp?appName=<%=applicationName%>&iccVersion=<%=ICCVersion%>">Interaction Center</a></td>
            		</tr>
            		<tr>
            			<td width="350" valign="top"><a href="validate-CTI.jsp?appName=<%=applicationName%>&ctiVersion=<%=CTIVersion%>">CTI (Computer Telephony)</a></td>
            		</tr>
            		<%	} 
            		 }
            		%>
            	</table>
            </td>
    	</tr>
	</table>
	
	<p>
	<hr>
	<h3>Required dependencies</h3>
	<%
	if (dependencyDetails.length <= 0)
	{
	%>
	&nbsp;&nbsp;None
	<%
	} else {
        try {
            URL url = new URL(request.getRequestURL().toString());
            host = url.getHost();
            port = Integer.toString(url.getPort());
            protocol = url.getProtocol();
        } catch (Exception e) {            
        }
        
        /* build the url */
		String prefixForURL = protocol + "://" + host + ":" + port + URL_SEPARATOR;
		for (int i = 0; i < dependencyDetails.length; i++)
		{
			// URL is of the form http://localhost:8080/ModuleName/validate.jsp?sendInformation=true
			String moduleHomeURL = "";
			String moduleValidationURL = "";		
			String moduleName = "", moduleVersion = "", moduleFrameworkVersion = "";
			boolean isOSDM = false;
			boolean thirdParty = false;
			if(dependencyDetails[i][INDEX_NAME].indexOf("OSDM_") == 0  ||  dependencyDetails[i][INDEX_NAME].indexOf("NDM_") == 0) {
				isOSDM = true;
				String osdmModuleName;
				String osdmBaseModule = "";
				if(dependencyDetails[i][INDEX_NAME].startsWith("OSDM_")) {
					osdmModuleName = dependencyDetails[i][INDEX_NAME].substring(5).toLowerCase();	
					if(osdmModuleName.equals("address") || osdmModuleName.equals("name")) {
						osdmBaseModule = "osdm2-" + osdmModuleName + URL_SEPARATOR + "controller";
					} else {
						osdmBaseModule = "osdm2-core" + URL_SEPARATOR + osdmModuleName;
					}
				} else {
					osdmModuleName = dependencyDetails[i][INDEX_NAME].substring(4).toLowerCase();
					osdmBaseModule = "ndm-core" + URL_SEPARATOR + osdmModuleName;
				}
				
				moduleHomeURL = prefixForURL + osdmBaseModule;
				moduleValidationURL = moduleHomeURL;
				boolean validModule = false;
				try
				{
					//For OSDM modules we just check if we can get the start page				
					HttpURLConnection.setFollowRedirects(false);
					HttpURLConnection con =	(HttpURLConnection) new URL(moduleValidationURL).openConnection();
					con.setRequestMethod("HEAD");
					if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
						validModule = true;
					}
				
				}
				catch (Exception e)	{}
				
				if(!validModule) {
					moduleVersion = setColor("Invalid", ERROR);
				} else {
					moduleVersion = setColor("Valid", OKAY);					
				}
				
			} else {
				moduleHomeURL = prefixForURL + dependencyDetails[i][INDEX_NAME] + URL_SEPARATOR + HOME_PAGE;
				moduleValidationURL = prefixForURL + dependencyDetails[i][INDEX_NAME] + URL_SEPARATOR + "jsp" + URL_SEPARATOR + VALIDATION_PAGE + "?" + PROPERTY_INFORMATION + "=true";
				
				if (dependencyDetails[i][INDEX_FRAMEWORK_VERSION].equals(PROPERTY_VALUE_UNKNOWN)){
					thirdParty = true;
				}
	
				Properties properties = getModuleProperties(moduleValidationURL);
				moduleName = properties.getProperty(PROPERTY_APP_NAME);
				moduleVersion = properties.getProperty(PROPERTY_APP_VERSION);
				if (moduleVersion == null) {
					moduleVersion = setColor(PROPERTY_VALUE_UNKNOWN, ERROR);
				} 
				moduleFrameworkVersion = properties.getProperty(PROPERTY_APP_FRAMEWORK_VERSION);
				if (moduleFrameworkVersion == null) {
					moduleFrameworkVersion = setColor(PROPERTY_VALUE_UNKNOWN, ERROR);
				}
			}
		%>
		
		<%if (!thirdParty) {%>
		<p><%=i+1%>. Module name: <a href="<%=moduleHomeURL%>"><%=dependencyDetails[i][INDEX_NAME]%></a></p>
		<%}else{%>
		<p><%=i+1%>. Module name(3rd-party module): <%=dependencyDetails[i][INDEX_NAME]%></p>
		<%} %>
		
		
		<table border="0">
			<tr>
				<td width="20"></td>
				<td>
					<table border="1" style="border-collapse: collapse;">
						<tr>
							<td width="350">&nbsp;</td>
							<% if(isOSDM) { %>
								<td align="center">&nbsp;Version&nbsp;</td>
								<td align="center">&nbsp;Status&nbsp;</td>
							<% } else if(thirdParty){ %>
								<td align="center">&nbsp;Version&nbsp;</td>
							<% } else {%>
								<td align="center">&nbsp;Required&nbsp;</td>
								<td align="center">&nbsp;Available&nbsp;</td>
							<% } %>
						</tr>
						<tr>
							<%
							if (moduleVersion.equalsIgnoreCase(dependencyDetails[i][INDEX_VERSION]) || isOSDM || thirdParty) {
							%>
							<td width="350">Module version:</td>
							<td align="center"><%=dependencyDetails[i][INDEX_VERSION]%></td>
							<% if (!thirdParty) {%>
								<td align="center"><%=moduleVersion%></td>
							<%} %>
							<%
							} else {
							%>
							<td width="350"><font color="#ff0000">Module version:</font></td>
							<td align="center"><font color="#ff0000"><%=dependencyDetails[i][INDEX_VERSION]%></font></td>
							<td align="center"><font color="#ff0000"><%=moduleVersion%></font></td>
							<% } %>
						</tr>
						<tr>
							<%
							if(!isOSDM && !thirdParty) {
							if (moduleFrameworkVersion.equalsIgnoreCase(dependencyDetails[i][INDEX_FRAMEWORK_VERSION])) {
							%>
							<td width="350">Framework runtime version:</td>
							<td align="center"><%=setColor(dependencyDetails[i][INDEX_FRAMEWORK_VERSION], OKAY)%></td>
							<td align="center"><%=setColor(moduleFrameworkVersion, OKAY)%></td>
							<% 
							} else{
							int color = getFWVersionColor( dependencyDetails[i][INDEX_FRAMEWORK_VERSION], moduleFrameworkVersion ); 
							%>
							<td width="350">Framework runtime version:</td>
							<td align="center"><%=setColor(dependencyDetails[i][INDEX_FRAMEWORK_VERSION], color)%></td>
							<td align="center"><%=setColor(moduleFrameworkVersion, color)%></td>
							<% } } %>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<%}%>
	<%}%>
	<p>
	<B><I>Note:</I></B> Even if all the dependencies are present, there is no guarantee your
	<%=SCERT.PRODUCT_NAME_SHORT%> application will work, because there are many configuration options that 
	this page does not check for. These tests are <i>necessary</i> but not <i>sufficient.</i>
	<p>
	<hr>
	</body>
</html>
<%
}
%>
