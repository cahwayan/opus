package cahwayan.apps.opus.courses.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import cahwayan.apps.opus.courses.coursemodel.modules.Module;

/**
 * Created by felip on 07-Aug-17.
 * Interface to communicate with the database part that holds the modules information
 * @see cahwayan.apps.opus.courses.database.CourseDatabase
 */

@Dao
public interface ModuleDao {

    final String TD_MODULES = "module";

    @Query("SELECT * FROM " + TD_MODULES + " WHERE courseType = :courseType ORDER BY id")
    LiveData<List<Module>> getModuleList(String courseType);

    @Query("SELECT * FROM " + TD_MODULES + " WHERE id = :id")
    Module getModule(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModule(Module module);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateModule(Module module);

    @Delete
    void deleteModule(Module module);

}
