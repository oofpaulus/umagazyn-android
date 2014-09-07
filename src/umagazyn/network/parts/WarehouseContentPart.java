package umagazyn.network.parts;

import org.json.JSONException;
import org.json.JSONObject;


public class WarehouseContentPart extends ResultPart {

	private JSONObject jsonObject = null;
	
	public JSONObject getJsonObject() {
		return jsonObject;
	}


	@Override
	public void FillByJson(String json) {
		try {
			jsonObject = new JSONObject(json);
		} catch (JSONException e) {
			
		}
	}

	
	
}
