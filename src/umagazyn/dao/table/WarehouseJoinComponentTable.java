package umagazyn.dao.table;

import umagazyn.dao.TableInterface;

public class WarehouseJoinComponentTable implements TableInterface {

	private static String tableName = "warehouse_component";
	
	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public String getCreateSQL() {
		return "CREATE TABLE " + tableName + " ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "count INTEGER NOT NULL, "
				+ "warehouse_id INTEGER NOT NULL," 
				+ "component_id INTEGER NOT NULL, " 
				+ "FOREIGN KEY(warehouse_id) REFERENCES "+ WarehouseTable.tableName +"(id), " 
				+ "FOREIGN KEY(component_id) REFERENCES "+ ComponentTable.tableName +"(id) )";
	}

	@Override
	public String getDeleteTableSQL() {
		return "DROP TABLE IF EXISTS " + tableName;
	}

	@Override
	public String getClearSQL() {
		return "DELETE * FROM " + tableName;
	}

}
