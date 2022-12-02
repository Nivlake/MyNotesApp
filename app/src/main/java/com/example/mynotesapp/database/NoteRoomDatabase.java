package com.example.mynotesapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// TODO 4: Tambahkan anotasi @Database dan tambahkan entitas yang akan digunakan
@Database(entities = {Note.class}, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
    private static volatile NoteRoomDatabase INSTANCE;
    public static NoteRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoteRoomDatabase.class) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(),
                                        NoteRoomDatabase.class, "note_database").build();
            }
        }
        return INSTANCE;
    }
}
