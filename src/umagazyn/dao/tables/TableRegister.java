package umagazyn.dao.tables;

import java.util.ArrayList;
import java.util.List;

public class TableRegister {
	
	public static List<TableInterface> getTables()
	{
		List<TableInterface> tables = new ArrayList<TableInterface>();
		tables.add(new WarehouseTable());
		tables.add(new ComponentTable());	
		return tables;		
	}
		
}
