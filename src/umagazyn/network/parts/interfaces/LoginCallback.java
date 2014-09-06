package umagazyn.network.parts.interfaces;

import java.util.Map;

import umagazyn.network.parts.AuthUser;

public interface LoginCallback extends AsyncCallback{
	
	public void setLoginCallback(AuthUser authUser);
}
