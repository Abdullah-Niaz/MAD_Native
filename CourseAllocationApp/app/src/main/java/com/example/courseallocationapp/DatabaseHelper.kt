package com.example.courseallocationapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class StudentDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "course_allocation.db"
        private const val DATABASE_VERSION = 2

        // Student Table
        const val TABLE_STUDENT = "students"
        const val STUDENT_ID = "id"
        const val STUDENT_NAME = "name"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createStudentTable = "CREATE TABLE $TABLE_STUDENT ($STUDENT_ID TEXT PRIMARY KEY, $STUDENT_NAME TEXT)"
        db.execSQL(createStudentTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENT")
        onCreate(db)
    }

    // Insert Student
    fun insertStudent(id: String, name: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(STUDENT_ID, id)
            put(STUDENT_NAME, name)
        }
        val result = db.insert(TABLE_STUDENT, null, values)
        db.close()
        return result != -1L
    }

    // Fetch All Students
    fun getAllStudents(): List<Pair<String, String>> {
        val studentList = mutableListOf<Pair<String, String>>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_STUDENT", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndexOrThrow(STUDENT_ID))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(STUDENT_NAME))
                studentList.add(Pair(id, name))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return studentList
    }
}

class ProfessorDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createProfessorTable = """
            CREATE TABLE IF NOT EXISTS Professor (
                professor_id INTEGER PRIMARY KEY AUTOINCREMENT,
                professor_name TEXT NOT NULL
            );
        """.trimIndent()

        db.execSQL(createProfessorTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Professor")
        onCreate(db)
    }
    fun insertProfessor(professorId: String, professorName: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("professor_id", professorId)
            put("professor_name", professorName)
        }
        val result = db.insert("Professor", null, values)
        db.close()
        return result != -1L
    }

    fun getAllProfessors(): List<Pair<String, String>> {
        val professors = mutableListOf<Pair<String, String>>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT professor_id, professor_name FROM Professor", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0)
                val name = cursor.getString(1)
                professors.add(id to name)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return professors
    }

    companion object {
        private const val DATABASE_NAME = "CourseAllocation.db"
        private const val DATABASE_VERSION = 2
    }
}





class SubjectDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        Log.d("DB_DEBUG", "Creating Subject table...")  // Debugging log

        val createTableQuery = """
            CREATE TABLE IF NOT EXISTS Subject (
                subject_code TEXT PRIMARY KEY,
                subject_title TEXT NOT NULL
            );
        """.trimIndent()

        db.execSQL(createTableQuery)
        Log.d("DB_DEBUG", "Subject table created successfully.")  // Debugging log
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.d("DB_DEBUG", "Upgrading database from version $oldVersion to $newVersion...")
        db.execSQL("DROP TABLE IF EXISTS Subject")
        onCreate(db)
    }

    fun insertSubject(subjectCode: String, subjectTitle: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("subject_code", subjectCode)
            put("subject_title", subjectTitle)
        }
        val result = db.insert("Subject", null, values)
        db.close()
        Log.d("DB_DEBUG", "Inserted subject: $subjectCode - $subjectTitle")  // Debugging log
        return result != -1L
    }

    fun getAllSubjects(): List<Pair<String, String>> {
        val subjects = mutableListOf<Pair<String, String>>()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT subject_code, subject_title FROM Subject", null)

        if (cursor.moveToFirst()) {
            do {
                val code = cursor.getString(0)
                val title = cursor.getString(1)
                subjects.add(code to title)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        Log.d("DB_DEBUG", "Retrieved subjects: $subjects")  // Debugging log
        return subjects
    }

    fun doesTableExist(): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT name FROM sqlite_master WHERE type='table' AND name='Subject'",
            null
        )
        val exists = cursor.count > 0
        cursor.close()
        db.close()
        Log.d("DB_DEBUG", "Table 'Subject' exists: $exists")  // Debugging log
        return exists
    }

    companion object {
        private const val DATABASE_NAME = "CourseAllocation.db"
        private const val DATABASE_VERSION = 2
    }
}



class CourseAllocationDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE IF NOT EXISTS CourseAllocation (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                student_id TEXT NOT NULL,
                subject_code TEXT NOT NULL,
                professor_id TEXT NOT NULL
            );
        """.trimIndent()

        db.execSQL(createTableQuery)
        Log.d("DB_DEBUG", "CourseAllocation table created successfully.")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS CourseAllocation")
        onCreate(db)
    }

    fun insertAllocation(studentID: String, subjectCode: String, professorID: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("student_id", studentID)
            put("subject_code", subjectCode)
            put("professor_id", professorID)
        }
        val result = db.insert("CourseAllocation", null, values)
        db.close()
        return result != -1L
    }

    companion object {
        private const val DATABASE_NAME = "CourseAllocation.db"
        private const val DATABASE_VERSION = 2
    }
}
