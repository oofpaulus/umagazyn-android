package umagazyn.dao.table;

import java.util.ArrayList;
import java.util.List;

import umagazyn.dao.DatabaseAdapter;
import umagazyn.dao.TableInterface;
import umagazyn.dao.entity.Warehouse;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class WarehouseTable implements TableInterface {

	public final static String tableName = "warehouses";

	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public String getCreateSQL() {
		return "CREATE TABLE " + tableName + " ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "name TEXT NOT NULL )";
	}

	@Override
	public String getDeleteTableSQL() {
		return "DROP TABLE IF EXISTS " + tableName;
	}

	@Override
	public String getClearSQL() {
		return "DELETE * FROM " + tableName;
	}
	
	
	public static long AddWarehouse(DatabaseAdapter dbAdapter, String name)
	{
		ContentValues newValues = new ContentValues();
		newValues.put("name", name);
	    return dbAdapter.getDb().insert(tableName, null, newValues);
	}
	
	public static long AddWarehouse(DatabaseAdapter dbAdapter, Warehouse warehouse)
	{
		ContentValues newValues = warehouse.GetValues();
	    return dbAdapter.getDb().insert(tableName, null, newValues);
	}
	
	public static List<Warehouse> getAllWarehouseAsList(DatabaseAdapter dbAdapter)
	{
		List<Warehouse> items = new ArrayList<Warehouse>();
        Cursor warehouseCursor = WarehouseTable.getAllWarehouseCursor(dbAdapter);
        do
        {
        	Warehouse warehouse = Warehouse.getWarehouseFromCursor(warehouseCursor);
        	if (warehouse != null)
        		items.add(warehouse);
        } while (warehouseCursor.moveToNext());
        
        warehouseCursor.close();
        return items;
	}
	
	public static Cursor getAllWarehouseCursor(DatabaseAdapter dbAdapter)
	{
		String[] columns = {"id", "name"};
		Cursor res = dbAdapter.getDb().query(tableName, columns, null, null, null, null, null);
		if (res != null)
			res.moveToFirst();
		return res;
	}
	

}
