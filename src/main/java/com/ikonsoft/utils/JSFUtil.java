
package com.ikonsoft.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public final class JSFUtil {
	
	public static void addInfoMsg(String componentId, String msg) {
		FacesContext.getCurrentInstance().addMessage(componentId, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addInfoMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addErrorMsg(String componentId, String msg) {
		FacesContext.getCurrentInstance().addMessage(componentId, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
	
	public static void addErrorMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
                FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
        
        public static Object getRequest() {
            return FacesContext.getCurrentInstance().getExternalContext().getRequest();
        }
}


