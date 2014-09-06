package umagazyn.dao.entity;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.database.Cursor;

public class Warehouse {
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean FillByJson(JSONObject jsObject)
	{
		try {
			id = jsObject.getLong("id");
			name = jsObject.getString("name");
		} catch (JSONException e) {
			return false;
		}
		return true;
	}
	
	public static Warehouse getWarehouseFromCursor(Cursor warehouseCursor)
	{
		if (warehouseCursor == null)
			return null;
		
		Warehouse res = null;
		try
		{
			res = new Warehouse();
			res.setId(warehouseCursor.getLong(0));
			res.setName(warehouseCursor.getString(1));
		}
		catch (Exception e)
		{	
			return null;
		}
		return res;
	}
	@Override
	public String toString() {
		return name;
	}
	public ContentValues GetValues() {
		ContentValues newValues = new ContentValues();
		newValues.put("id", id);
		newValues.put("name", name);
		
		return newValues;
	}
	
	
}
