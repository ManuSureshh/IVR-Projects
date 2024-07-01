<%@ include file="validate-common2.jsp" %>
<%!
	static final String HOME_PAGE = "index.html";
	static final String VALIDATION_PAGE = "validate.jsp";
	static final String URL_ENCODING = "UTF-8";
	static final String PROPERTY_INFORMATION = "sendInformation";
	static final String PROPERTY_APP_NAME = "appName";
	static final String PROPERTY_ENTRYPOINT = "entryPoint";
	static final String PROPERTY_APP_MODULES = "modules";
	static final String PROPERTY_APP_VERSION = "appVersion";
	static final String PROPERTY_CTI_VERSION = "ctiVersion";
	static final String PROPERTY_ICC_VERSION = "iccVersion";
	static final String PROPERTY_APP_FRAMEWORK_VERSION = "appFrameworkVersion";
	static final String PROPERTY_EQUAL = "=";
	static final String PROPERTY_APPENDER = "&";
	static final String URL_SEPARATOR = "/";
	static final String PROPERTY_VALUE_UNKNOWN = "Unknown";
	static final int INDEX_NAME = 0;
	static final int INDEX_VERSION = 1;
	static final int INDEX_FRAMEWORK_VERSION = 2;
    static final String COLOR_WARN="FF9900";
    static final String COLOR_ERROR="FF0000";
    static final String COLOR_OKAY="009933";
    static final String COLOR_INFO="0000FF";

	static final int WARN = 1;
	static final int ERROR = 2;
	static final int OKAY = 3;
	static final int INFO = 4;
    boolean showConnectorInfo = false;
    String path = "";

    private boolean versionGreater(String actual, String build) {
    	String[] act = actual.split("\\.");
    	String[] bld = build.split("\\.");
    	int actSize = act.length;
    	int bldSize = bld.length;
    	for(int i = 0, size = Math.max(actSize, bldSize); i < size; i++) {
    		int a = 0;
    		int b = 0;
    		try { a = Integer.parseInt(act[i]); } catch (Exception e) { a = -1; }
    		try { b = Integer.parseInt(bld[i]); } catch (Exception e) { b = -1; }
    		if(a > b) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private String setColor( String message, int type ) {
        StringBuffer buf = new StringBuffer();
        buf.append("<font color='#");
        if ( type== WARN ) {
            buf.append(COLOR_WARN);
        } else if (type == ERROR){
            buf.append(COLOR_ERROR);
        } else if (type == OKAY){
            buf.append(COLOR_OKAY);
        } else if (type == INFO){
            buf.append(COLOR_INFO);
        }
        buf.append("'>");
        buf.append(message);
        buf.append("</font>");
        return( buf.toString() );
    }
    
    Class classExists(String classname) {
        try {
            return Class.forName(classname);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
    
    String getLocation(Class clazz) {
        try {
            java.net.URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
            String location = url.toString();
            if(location.startsWith("jar")) {
                url = ((java.net.JarURLConnection)url.openConnection()).getJarFileURL();
                location = url.toString();
            } 
            
            if(location.startsWith("file")) {
                java.io.File file = new java.io.File(url.getFile());
                return file.getAbsolutePath();
            } else {
                return url.toString();
            }
        } catch (Throwable t){
        }
        return "an unknown location";
    }
    
    int probeClass(JspWriter out,
                   String category,
                   String classname,
                   String jarFile,
                   String description,
                   String errorText,
                   String homePage) throws IOException {
                   
        try {
            Class clazz = classExists(classname);
            if(clazz == null)  {
                String url="";
                if(homePage!=null) {
                    url="<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;See <a href="+homePage+">"+homePage+"</a>";
                }
                out.write(category+" could not find class "+classname
                   +"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;from file <b>"+jarFile
                   +"</b><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+errorText
                   +url+"<br>");
                return 1;
            } else {
                String location = getLocation(clazz);
                if(location == null) {
                    out.write( setColor("Found ", OKAY)+ description + " (" + classname + ")<br>");
                } else {
                	String[] jarFiles = jarFile.split("\\;");
                	boolean found = false;
                	for (int i=0; i<jarFiles.length; i++){
                		 if ( location.endsWith(jarFiles[i] )== true ) {
                             out.write(setColor("Found ", OKAY)+ description + " (" + classname + ") <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;at " + location + "<br>");
                             found = true;
                             break;
                		 }
                	}
                    if (!found) {
                        out.write(setColor("Found ", OKAY)+ description + " (" + classname + ") <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;at " + location + "<br>");
                        out.write(setColor("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Version of jar file may not be correct", WARN) + " expected " + jarFile + "<br>");
                    }
                }
                return 0;
            }
        } catch(NoClassDefFoundError ncdfe) { 
            String url="";
            if(homePage!=null) {
                url="<br>  See <a href="+homePage+">"+homePage+"</a>";
            }
            out.write("" + category + ": could not find a dependency"
                    +" of class " + classname
                    +"<br>from file <b>" + jarFile
                    +"</b><br> " + errorText
                    + url
                    +"<br>The root cause was: "+ncdfe.getMessage()
                    +"<br>This can happen e.g. if "+classname+" is in" 
                    +" the 'common' classpath, but a dependency like "
                    +" activation.jar is only in the webapp classpath."
                    +"");
            return 1;
        }
    }
    
    String getJarLocationContainingClass(String classname) {         
 		try {
     		Class clazz = classExists(classname);
     		if(clazz == null)  {
    	 		return(null);
     		} else {
         		String location = getLocation(clazz);
         		if(location == null) {
        	 		return(null);
         		} else {
         			return (location);
         		}
     		}
 		} catch(Exception e) { 
     		return "";
 		}
	}


	/**
	 *	Encode the properties to string
	 **/
	private String encodeToString(Properties properties) throws IOException
	{
		final StringBuffer buffer = new StringBuffer();
		final Enumeration names = properties.propertyNames();

		String name;
		String value;

		while (names.hasMoreElements()) 
		{
			name = (String)names.nextElement();
			value = properties.getProperty(name);
			buffer.append(URLEncoder.encode(name, URL_ENCODING) + PROPERTY_EQUAL + URLEncoder.encode(value, URL_ENCODING));
			if (names.hasMoreElements())
		    {
				buffer.append(PROPERTY_APPENDER);
		    }
		}

		return buffer.toString();
	}

	/**
	 * Decode the URL-encoded string where name=value pairs are separated by &
	 * into a Properties object
	 */
	private Properties decodeFromString(String propsString) throws IOException
	{
		StringTokenizer tokenizer = new StringTokenizer(propsString, PROPERTY_APPENDER);
		StringTokenizer pst; 

		Properties properties = new Properties();
		String name;
		String value;
		String propString;

		while (tokenizer.hasMoreTokens())
		{
			propString = tokenizer.nextToken();
			pst = new StringTokenizer(propString, PROPERTY_EQUAL);

			if (pst.countTokens() > 1)
			{
				name = URLDecoder.decode(pst.nextToken(), URL_ENCODING);
				value = URLDecoder.decode(pst.nextToken(), URL_ENCODING);
				properties.setProperty(name, value);
			}
		}
		return properties;	
	}
	
	private int [] parseVersion ( String version ) {
		int [] result = new int[4];
		result[0] = 0;
		result[1] = 0;
		result[2] = 0;
		result[3] = 0;
		try {
			StringTokenizer str = new StringTokenizer( version, "." );
			int index = 0;
			while ( str.hasMoreTokens() == true ) {
				String token = str.nextToken();
				result[index] = Integer.parseInt( token );
			}
		} catch ( Exception e ) {
			result[0] = 0;
			result[1] = 0;
			result[2] = 0;
			result[3] = 0;
		}
		return(result);	
	}
	
	private int getFWVersionColor( String requiredVersion,  String availableVersion ) {
		int [] req = parseVersion( requiredVersion );
		int [] avail = parseVersion( availableVersion );
		
		if (req[0] > avail[0] ) {
			return( ERROR );
		}
		if (req[1] > avail[1] ) {
			return( ERROR );
		}
		if (req[2] > avail[2] ) {
			return( ERROR );
		}
		if (req[3] > avail[3] ) {
			return( ERROR );
		}
		return( WARN );
	}
	    
    private boolean valueInStringArray( String [] values, String value ) {
        for (int i = 0; i < values.length; i++) {
            if ( values[i].equals(value)== true ) {
                return( true );
            }
        }
        return( false );
    }
    
	public  String cleanString(String value) {
		if (value == null) {
			return null;
		}
		if (value.length() == 0) {
			return value;
		}
		return (IO.sanitizeString(IO.removeHTMLFromString(value), "."));
	}

    
%>
