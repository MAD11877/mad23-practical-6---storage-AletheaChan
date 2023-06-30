package sg.edu.np.mad.practical6;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c) {super (c, "userDB.db", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE User (Name TEXT, Description TEXT, Id INT, Followed BOOLEAN)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Message");
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO User VALUES( \"" + user.userName + "\", \"" + user.userDescription + "\", + \"" + user.userID + "\", + \"" + user.userFollowed + "\")");
        db.close();
    }

    public ArrayList<User> getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<user> list = new ArrayList<User>();

        Cursor cursor = db.rawQuery("SELECT * FROM USER", null);
        while(cursor.moveToNext())
        {
            User newUser = new User();
            newUser.userName = cursor.getString(0);
            newUser.userDescription = cursor.getString(1);
            newUser.userID = cursor.getInt(2);
            newUser.userFollowed = Boolean.parseBoolean(cursor.getString(3));
            list.add(newUser);
        }
        return list;
    }

    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE User SET Followed = \""+ user.userFollowed +"\" " +  "WHERE id = \""+ user.userID +"\"");
        db.close();
    }

    public int Count() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User", null);
        return cursor.getCount();
    }
}
