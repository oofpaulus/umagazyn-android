package ofpaulus.umagazyn.warehouse;

import java.util.List;

import ofpaulus.umagazyn.R;

import umagazyn.dao.entity.Warehouse;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class WarehouseArrayAdapter extends ArrayAdapter<Warehouse> {

	private final List<Warehouse> warehouses;
	private final Context context;
	
	public WarehouseArrayAdapter(Context context, List<Warehouse> warehouses) {
	    super(context, R.layout.warehouse_item, warehouses);
	    this.context = context;
	    this.warehouses = warehouses;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.warehouse_item, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.component_name);
		textView.setText(warehouses.get(position).getName());

		return rowView;
		//return super.getView(position, convertView, parent);
	}


}
