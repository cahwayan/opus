package cahwayan.apps.opus.courses.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import cahwayan.apps.opus.courses.coursemodel.modules.Module;
import cahwayan.apps.opus.courses.database.dao.ModuleDao;

/**
 * Created by felip on 07-Aug-17.
 */

@Database(
        entities = {
                Module.class
        },
        version = 1
)
public abstract class CourseDatabase extends RoomDatabase {

    public static final String COURSE_DB_NAME = "courseDb";

    /*
    * Modules that compose the database
    * */
    public abstract ModuleDao moduleDao();


}
