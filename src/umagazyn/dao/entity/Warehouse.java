package umagazyn.dao.entity;

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
	
	
}
