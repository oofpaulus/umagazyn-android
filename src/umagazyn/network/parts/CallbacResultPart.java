package umagazyn.network.parts;

import org.json.JSONObject;

import umagazyn.network.parts.interfaces.AsyncCallback;
import umagazyn.network.parts.interfaces.DBCallback;
import umagazyn.network.parts.interfaces.LoginCallback;

public class CallbacResultPart {

	public CallbacResultPart()
	{
	
	}
	public void CallbackObjectWithJson(AsyncCallback callback, String result, ResultPart resultPart) {
		if (resultPart instanceof AuthUser)
		{
			AuthUser authUser = (AuthUser)resultPart;
			authUser.FillByJson(result);
			if (callback instanceof LoginCallback)
			{
				((LoginCallback)callback).setLoginCallback(authUser);
			}
		}
		if (resultPart instanceof UserWarehouses)
		{
			UserWarehouses warehouses = (UserWarehouses)resultPart;
			warehouses.FillByJson(result);
			if (callback instanceof DBCallback)
			{
				((DBCallback)callback).setUserWarehouse(warehouses);
			}
		}
		
	}
}
