package umagazyn.network.parts.callback;

import umagazyn.network.parts.WarehouseContentPart;

public interface DBContentCallback extends AsyncCallback{
	
	public void setDBContent(WarehouseContentPart warehouseContentPart);
}
