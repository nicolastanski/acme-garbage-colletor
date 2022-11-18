package br.com.colletor.garbage.acme

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, name: String?) : SQLiteOpenHelper(context,name,null,1)  {

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("CREATE TABLE SCHEDULES(\n" +
                "\tID_SCHEDULE INT NOT NULL,\n" +
                "\tLOCATION VARCHAR(255),\n" +
                "\tQUANTITY INT(11),\n" +
                "\tWEIGHT INT(11),\n" +
                "\tDAY VARCHAR(20),\n" +
                "\tHOUR VARCHAR(20),\n" +
                "\tPRIMARY KEY (ID_SCHEDULE)\n" +
                "\t);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS SCHEDULES")

//        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
//                "\tID_SAUDACAO INT NOT NULL,\n" +
//                "\tNOME VARCHAR(20),\n" +
//                "\tTRATAMENTO VARCHAR(20),\n" +
//                "\tPRIMARY KEY (ID_SAUDACAO)\n" +
//                "\t);")
    }

    fun insertSchedule(id: Int, location: String, quantity: String, weight: String, day: String, hour: String){
        var db = this.writableDatabase

        var cv = ContentValues()

        cv.put("ID_SCHEDULE", id)
        cv.put("LOCATION", location)
        cv.put("QUANTITY", quantity)
        cv.put("WEIGHT", weight)
        cv.put("DAY", day)
        cv.put("HOUR", hour)

        db.insert("SCHEDULES","ID_SCHEDULE",cv)
    }

    fun listSchedules(): Cursor {

        var db = this.readableDatabase
        return db.rawQuery("SELECT REGION, DAY, HOUR from SCHEDULES",null)
    }

    fun removeSchedule(){
        var db = this.writableDatabase
        db.delete("SCHEDULES","ID_SCHEDULE=1",null)
    }
}