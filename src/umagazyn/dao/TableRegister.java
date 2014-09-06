package umagazyn.dao;

import java.util.ArrayList;
import java.util.List;

import umagazyn.dao.table.ComponentTable;
import umagazyn.dao.table.ProjectJoinComponentTable;
import umagazyn.dao.table.ProjectTable;
import umagazyn.dao.table.WarehouseJoinComponentTable;
import umagazyn.dao.table.WarehouseTable;

public class TableRegister {
	
	public static List<TableInterface> getTables()
	{
		List<TableInterface> tables = new ArrayList<TableInterface>();
		tables.add(new WarehouseTable());
		tables.add(new ComponentTable());
		tables.add(new ProjectTable());
		tables.add(new WarehouseJoinComponentTable());
		tables.add(new ProjectJoinComponentTable());
		return tables;		
	}
		
}
