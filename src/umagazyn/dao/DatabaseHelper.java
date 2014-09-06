package umagazyn.dao;

import umagazyn.dao.TableInterface;
import umagazyn.dao.TableRegister;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DEBUG_TAG = "SqLiteUMAGAZYN";
	
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		for (TableInterface table : TableRegister.getTables())
		{
			Log.d(DEBUG_TAG, "Create table : " + table.getCreateSQL());
			db.execSQL(table.getCreateSQL());
		}
	}
	
	public void clearDb(SQLiteDatabase db) {
		
		for (TableInterface table : TableRegister.getTables())
		{
			Log.d(DEBUG_TAG, "Drop table : " + table.getDeleteTableSQL());
			db.execSQL(table.getDeleteTableSQL());
		}
		onCreate(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		for (TableInterface table : TableRegister.getTables())
		{
			Log.d(DEBUG_TAG, "Drop table : " + table.getDeleteTableSQL());
			db.execSQL(table.getDeleteTableSQL());
		}
		onCreate(db);
	}

}
