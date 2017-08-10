package cahwayan.apps.opus.user.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import cahwayan.apps.opus.user.User;
import cahwayan.apps.opus.user.UserProgress;

/**
 * Created by felip on 08-Aug-17.
 */

@Dao
public interface UserDao {

    public static final String TD_USER = "user";
    public static final String TD_USER_PROGRESS = "userprogress";

    @Query("SELECT * FROM " + TD_USER_PROGRESS + " WHERE courseName = :courseName LIMIT 1")
    LiveData<UserProgress> getUserProgress(String courseName);

    @Query("SELECT * FROM " + TD_USER + " WHERE id = :userId LIMIT 1")
    LiveData<User> getUser(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUserProgress(UserProgress userProgress);
}
