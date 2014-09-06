package umagazyn.dao.table;

import umagazyn.dao.TableInterface;

public class ProjectJoinComponentTable implements TableInterface {

	private static String tableName = "project_component";
	
	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public String getCreateSQL() {
		return "CREATE TABLE " + tableName + " ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "count INTEGER NOT NULL, "
				+ "project_id INTEGER NOT NULL," 
				+ "component_id INTEGER NOT NULL, " 
				+ "FOREIGN KEY(project_id) REFERENCES "+ ProjectTable.tableName +"(id), " 
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
