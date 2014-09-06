package umagazyn.network.parts.interfaces;

import umagazyn.network.parts.AuthUser;
import umagazyn.network.parts.UserWarehouses;

public interface DBCallback extends AsyncCallback{
	
	public void setUserWarehouse(UserWarehouses userWarehouses);
}
