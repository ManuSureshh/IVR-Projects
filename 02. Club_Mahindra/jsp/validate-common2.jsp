<!-- 
Use this file as the default place for shared functions that ony work on some(but not all) of the platform we support.
For example, the getVersion function here only work on Webshpere and Tomcat while its counterpart for Weblogic will come
from validate-common-weblogic.jsp.
-->
<%!
	private String getVersion(String className, String methodName) throws Exception {
        Class c = Class.forName(className);
        Method[] m = c.getMethods();
        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().equals(methodName) == true) {
                Object o = m[i].invoke(c, null);
                return(o.toString());
            }
        }
        return("missing");
    }
%>
