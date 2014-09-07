package umagazyn.network.parts.callback;

import java.util.Map;

import umagazyn.network.parts.LoginPart;

public interface LoginCallback extends AsyncCallback{
	
	public void setLoginCallback(LoginPart	loginPart);
}
