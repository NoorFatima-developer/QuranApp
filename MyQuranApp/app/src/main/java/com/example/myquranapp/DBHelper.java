package com.example.myquranapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
//    public static final String STUDENT_ID = "StudentID";
//    public static final String STUDENT_NAME = "StudentName";
//    public static final String STUDENT_ROLL = "StudentRollNumber";
//    public static final String STUDENT_ENROLL = "IsEnrolled";
    public static final String SURAH_TABLE = "tsurah";
    public static final String AYAH_TABLE = "tayah";
    public static final String ARABIC_TEXT = "'Arabic Text'";



    public DBHelper(@Nullable Context context) {
        super(context, "quran_db.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
//        String createTableSTatement = "CREATE TABLE " + STUDENT_TABLE + "(" +
//                STUDENT_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " Text, "
//                + STUDENT_ROLL + " Int, " + STUDENT_ENROLL + " BOOL) ";
//        db.execSQL(createTableSTatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
//        onCreate(db);
    }

    public ArrayList<Names> populateSurah(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT SurahNameU,SurahNameE  FROM " + SURAH_TABLE, null);

        ArrayList<Names> myList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                myList.add(new Names(cursorCourses.getString(0), cursorCourses.getString(1)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return myList;
    }

    public ArrayList<String> populateAyah(String type, int i){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM tsurah", null);
        if(type.equals("Surah")){
            cursorCourses = db.rawQuery("SELECT \"Arabic Text\" FROM tayah WHERE SuraID=?", new String[] {String.valueOf(i+1)});
        }
        else if(type.equals("Parah")){
            cursorCourses = db.rawQuery("SELECT \"Arabic Text\" FROM tayah WHERE ParaID=?", new String[] {String.valueOf(i+1)});
        }

        ArrayList<String> myList = new ArrayList<>();

        //moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do{
                myList.add(cursorCourses.getString(0));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return myList;
    }

    public ArrayList<String> translation(String type, String temp, int index){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + AYAH_TABLE, null);

        if(type.equals("Surah")){
            if(temp.equals("urdu1")){
                cursorCourses = db.rawQuery("SELECT \"Fateh Muhammad Jalandhri\" FROM " + AYAH_TABLE + " WHERE SuraID = ?", new String[] {String.valueOf(index+1)});
            }
            else if(temp.equals("urdu2")){
                cursorCourses = db.rawQuery("SELECT \"Mehmood ul Hassan\" FROM " + AYAH_TABLE + " WHERE SuraID = ?", new String[] {String.valueOf(index+1)});
            }
            else if(temp.equals("eng1")){
                cursorCourses = db.rawQuery("SELECT \"Dr Mohsin Khan\" FROM " + AYAH_TABLE + " WHERE SuraID = ?", new String[] {String.valueOf(index+1)});
            }
            else if(temp.equals("eng2")){
                cursorCourses = db.rawQuery("SELECT \"Mufti Taqi Usmani\" FROM " + AYAH_TABLE + " WHERE SuraID = ?", new String[] {String.valueOf(index+1)});
            }
        }
        else if(type.equals("Parah")){
            if(temp.equals("urdu1")){
                cursorCourses = db.rawQuery("SELECT \"Fateh Muhammad Jalandhri\" FROM " + AYAH_TABLE + " WHERE ParaID = ?", new String[] {String.valueOf(index+1)});
            }
            else if(temp.equals("urdu2")){
                cursorCourses = db.rawQuery("SELECT \"Mehmood ul Hassan\" FROM " + AYAH_TABLE + " WHERE ParaID = ?", new String[] {String.valueOf(index+1)});
            }
            else if(temp.equals("eng1")){
                cursorCourses = db.rawQuery("SELECT \"Dr Mohsin Khan\" FROM " + AYAH_TABLE + " WHERE ParaID = ?", new String[] {String.valueOf(index+1)});
            }
            else if(temp.equals("eng2")){
                cursorCourses = db.rawQuery("SELECT \"Mufti Taqi Usmani\" FROM " + AYAH_TABLE + " WHERE ParaID = ?", new String[] {String.valueOf(index+1)});
            }
        }

        ArrayList<String> myList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                myList.add(cursorCourses.getString(0));
            } while (cursorCourses.moveToNext());

        }
        cursorCourses.close();
        return myList;
    }

    public ArrayList<Names> getAyahAndTranslation(int index, String type, String translation){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + AYAH_TABLE, null);

        if(type.equals("Surah")) {
            if (translation.equals("urdu1")) {
                cursorCourses = db.rawQuery("SELECT \"Arabic Text\",\"Fateh Muhammad Jalandhri\" FROM tayah WHERE SuraID=?", new String[]{String.valueOf(index + 1)});
            } else if (translation.equals("urdu2")) {
                cursorCourses = db.rawQuery("SELECT \"Arabic Text\",\"Mehmood ul Hassan\" FROM tayah WHERE SuraID=?", new String[]{String.valueOf(index + 1)});
            } else if (translation.equals("eng1")) {
                cursorCourses = db.rawQuery("SELECT \"Arabic Text\",\"Dr Mohsin Khan\" FROM tayah WHERE SuraID=?", new String[]{String.valueOf(index + 1)});
            } else if (translation.equals("eng2")) {
                cursorCourses = db.rawQuery("SELECT \"Arabic Text\",\"Mufti Taqi Usmani\" FROM tayah WHERE SuraID=?", new String[]{String.valueOf(index + 1)});
            }
        }
        else if(type.equals("Parah")) {
            if (translation.equals("urdu1")) {
                cursorCourses = db.rawQuery("SELECT \"Arabic Text\",\"Fateh Muhammad Jalandhri\" FROM tayah WHERE ParaID=?", new String[]{String.valueOf(index + 1)});
            } else if (translation.equals("urdu2")) {
                cursorCourses = db.rawQuery("SELECT \"Arabic Text\",\"Mehmood ul Hassan\" FROM tayah WHERE ParaID=?", new String[]{String.valueOf(index + 1)});
            } else if (translation.equals("eng1")) {
                cursorCourses = db.rawQuery("SELECT \"Arabic Text\",\"Dr Mohsin Khan\" FROM tayah WHERE ParaID=?", new String[]{String.valueOf(index + 1)});
            } else if (translation.equals("eng2")) {
                cursorCourses = db.rawQuery("SELECT \"Arabic Text\",\"Mufti Taqi Usmani\" FROM tayah WHERE ParaID=?", new String[]{String.valueOf(index + 1)});
            }
        }

        ArrayList<Names> myList = new ArrayList<>();

        //moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do{
                myList.add(new Names(cursorCourses.getString(0), cursorCourses.getString(1)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return myList;
    }
//    public void  addStudent(StudentModel STUDENTModel){
//        SQLiteDatabase db = this.getWritableDatabase();
//        //Hash map, as we did in bundles
//        ContentValues cv = new ContentValues();
//
//        cv.put(STUDENT_NAME, STUDENTModel.getName());
//        cv.put(STUDENT_ROLL, STUDENTModel.getRollNmber());
//        cv.put(STUDENT_ENROLL, STUDENTModel.isEnroll());
//        db.insert(STUDENT_TABLE, null, cv);
//        db.close();
//        //NullColumnHack
//        //long insert =
//        //if (insert == -1) { return false; }
//        //else{return true;}
//    }
//
//    public ArrayList<StudentModel> getAllStudents() {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);
//
//        ArrayList<StudentModel> studentArrayList = new ArrayList<>();
//
//        // moving our cursor to first position.
//        if (cursorCourses.moveToFirst()) {
//            do {
//                studentArrayList.add(new StudentModel(cursorCourses.getInt(0), cursorCourses.getString(1), cursorCourses.getInt(2), cursorCourses.getInt(3) == 1 ? true : false));
//            } while (cursorCourses.moveToNext());
//
//        }
//        cursorCourses.close();
//        return studentArrayList;
//    }
//
//    public void deleteRecord(int ID){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(STUDENT_TABLE, STUDENT_ID + " = ?", new String[] {String.valueOf(ID)});
//        db.close();
//    }
//
//    public void updateRecord(int ID, String name, String roll, boolean enrollStat){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(STUDENT_NAME, name);
//        values.put(STUDENT_ROLL, roll);
//        values.put(STUDENT_ENROLL, enrollStat);
//
//        db.update(STUDENT_TABLE, values, STUDENT_ID + " = ?", new String[] {String.valueOf(ID)});
//        db.close();
//    }
}