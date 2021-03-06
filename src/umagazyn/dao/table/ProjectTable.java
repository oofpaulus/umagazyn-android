package umagazyn.dao.table;

import umagazyn.dao.TableInterface;

public class ProjectTable implements TableInterface{

	public final static String tableName = "projects";
	
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

}
