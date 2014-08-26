package umagazyn.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter {

	public final static String DB_NAME = "umagazyn";
	public final static int DB_VERSION = 1;
	
	private SQLiteDatabase db;
    private Context context;
    
    private DatabaseHelper dbHelper = null;
    
    
    public DatabaseAdapter(Context context)
    {
    	this.context = context;	
    }
    
    public DatabaseAdapter open(){
        dbHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION, null);
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException e) {
            db = dbHelper.getReadableDatabase();
        }
        return this;
    }
 
    public void close() {
        dbHelper.close();
    }

	public SQLiteDatabase getDb() {
		return db;
	}    
    
}
