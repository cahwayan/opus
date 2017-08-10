package cahwayan.apps.opus.user.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import cahwayan.apps.opus.user.User;
import cahwayan.apps.opus.user.UserProgress;
import cahwayan.apps.opus.user.database.dao.UserDao;

/**
 * Created by felip on 08-Aug-17.
 */

@Database(
        entities = {
                User.class,
                UserProgress.class
        },

        version = 1
)
public abstract class UserDatabase extends RoomDatabase {

    public static final String USER_DATABASE_NAME = "userDatabase";

    public abstract UserDao userDao();
}
