package umagazyn.network.parts;

import org.json.JSONException;
import org.json.JSONObject;

public class AuthUser extends ResultPart {

	protected static ResultPart GetObject() {
		return new AuthUser();
	}

	private String token;
	private String name;

	public void FillByJson(String json) {
		try {
			JSONObject jsObject = new JSONObject(json);

			token = jsObject.getString("token");
			name = jsObject.getString("name");
		} catch (JSONException e) {
			token = "";
		}
		token = "android";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
