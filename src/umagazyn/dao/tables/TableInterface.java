package umagazyn.dao.tables;

public interface TableInterface {

	public String getTableName();
	public String getCreateSQL();
	public String getDeleteTableSQL();
	public String getClearSQL();
	
}
