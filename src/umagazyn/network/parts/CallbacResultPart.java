package umagazyn.network.parts;

import org.json.JSONObject;

import umagazyn.network.parts.callback.DBContentCallback;
import umagazyn.network.parts.callback.AsyncCallback;
import umagazyn.network.parts.callback.DBContentCallback;
import umagazyn.network.parts.callback.LoginCallback;

public class CallbacResultPart {

	public CallbacResultPart()
	{
	
	}
	public void CallbackObjectWithJson(AsyncCallback callback, String result, ResultPart resultPart) {
		if (resultPart instanceof LoginPart)
		{
			LoginPart loginPart = (LoginPart)resultPart;
			loginPart.FillByJson(result);
			if (callback instanceof LoginCallback)
			{
				((LoginCallback)callback).setLoginCallback(loginPart);
			}
		}
		if (resultPart instanceof WarehouseContentPart)
		{
			WarehouseContentPart warehouses = (WarehouseContentPart)resultPart;
			warehouses.FillByJson(result);
			if (callback instanceof DBContentCallback)
			{
				((DBContentCallback)callback).setDBContent(warehouses);
			}
		}
		
	}
}
