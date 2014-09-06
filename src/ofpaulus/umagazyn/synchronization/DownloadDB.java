package ofpaulus.umagazyn.synchronization;

import ofpaulus.umagazyn.LoginActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import umagazyn.dao.DatabaseAdapter;
import umagazyn.dao.entity.Warehouse;
import umagazyn.dao.table.WarehouseTable;
import umagazyn.network.ServerConnector;
import umagazyn.network.parts.AuthUser;
import umagazyn.network.parts.UserWarehouses;
import umagazyn.network.parts.interfaces.DBCallback;
import umagazyn.network.parts.interfaces.LoginCallback;

public class DownloadDB implements DBCallback{

	private ServerConnector serverConnector = null;
	final private String dbUrl = "http://192.168.1.101:9000/mobile";
	private String securityToken;
	private DatabaseAdapter dbAdapter = null;
	private LoginActivity loginActivity;
	
	public DownloadDB(String token, DatabaseAdapter dbAdapter, LoginActivity loginActivity)
	{
		this.loginActivity = loginActivity;
		this.dbAdapter = dbAdapter;
		
		this.securityToken = token;
		JSONObject jsObject = new JSONObject();
		try {
			jsObject.put("token", token);
		} catch (JSONException e) {

		}
		serverConnector = new ServerConnector(this, dbUrl, new UserWarehouses());
		serverConnector.execute(jsObject);
	}
	
	@Override
	public void setUserWarehouse(UserWarehouses userWarehouses) {
		if (userWarehouses == null)
			return;
		JSONObject result = userWarehouses.getJsonObject();
		if (result == null)
			return;
		
		try {
			JSONArray warehouses = result.getJSONArray("warehouses");
			for (int i=0;i<warehouses.length(); i++)
			{
				JSONObject jsWarehouse = warehouses.getJSONObject(i);
				Warehouse warehouse = new Warehouse();
				if (warehouse.FillByJson(jsWarehouse) == true)
				{
					// warehouse readed
					WarehouseTable.AddWarehouse(dbAdapter, warehouse);
				}
				
			}
			
		} catch (JSONException e) {
		}
		loginActivity.switchToMainActivity();
		
	}

	
	
}
