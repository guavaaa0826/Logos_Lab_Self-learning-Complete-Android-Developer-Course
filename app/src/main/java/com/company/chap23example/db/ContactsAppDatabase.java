package com.company.chap23example.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.company.chap23example.db.entity.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactsAppDatabase extends RoomDatabase {

    // Linking DAO with database
    public abstract ContactDAO getContactDAO();

}
