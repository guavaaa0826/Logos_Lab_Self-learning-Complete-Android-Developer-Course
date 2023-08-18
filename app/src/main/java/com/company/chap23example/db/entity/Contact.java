package com.company.chap23example.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "contacts")
public class Contact {

    // Constants for Database
    // We put TABLE_NAME in the property of @Entity,
    // and we put the rest in the properties of @ColumnInfo

    // public static final String TABLE_NAME = "contacts";
    // public static final String COLUMN_ID = "contact_id";
    // public static final String COLUMN_NAME = "contact_name";
    // public static final String COLUMN_EMAIL = "contact_email";

    // Variables
    @ColumnInfo(name = "contact_name")
    private String name;

    @ColumnInfo(name = "contact_email")
    private String email;

    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true) // autoGenerate = true makes it increment itself.
    private int id;

    // Constructors
    @Ignore // @Ignore prevents the code from using this constructor
    public Contact() {

    }

    public Contact(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // SQL Query: Creating the Table
    // public static final String CREATE_TABLE =
    //         "CREATE TABLE " + TABLE_NAME + "("
    //                 + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
    //                 + COLUMN_NAME + " TEXT,"
    //                 + COLUMN_EMAIL + " DATETIME DEFAULT CURRENT_TIMESTAMP)";

}
