package cahwayan.apps.opus.injection.module.course;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import cahwayan.apps.opus.courses.coursemodel.modules.ModuleModelImpl;
import cahwayan.apps.opus.courses.coursemodel.modules.ModulePresenterImpl;
import cahwayan.apps.opus.courses.coursemodel.modules.ModuleFragment;
import cahwayan.apps.opus.courses.database.CourseDatabase;
import cahwayan.apps.opus.courses.database.dao.ModuleDao;
import cahwayan.apps.opus.injection.scope.Runtime;
import cahwayan.apps.opus.user.UserMVP;
import dagger.Module;
import dagger.Provides;

import static cahwayan.apps.opus.courses.coursemodel.modules.ModuleMVP.*;
import static cahwayan.apps.opus.courses.database.CourseDatabase.COURSE_DB_NAME;

/**
 * Created by felip on 03-Aug-17.
 */

@Module
public class CourseModule {

    public CourseModule() {}

    /**
     * Database providers
     * */
    @Provides @Singleton
    public CourseDatabase provideCourseDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), CourseDatabase.class, COURSE_DB_NAME).build();
    }

    @Provides @Singleton
    public ModuleDao provideModuleDao(CourseDatabase courseDatabase) {
        return courseDatabase.moduleDao();
    }

    /**
     * Module providers
     * */
    @Provides @Singleton
    public ModulePresenter provideModulePresenter() {
        return new ModulePresenterImpl();
    }

    @Provides @Singleton
    public ModuleModel provideModuleModel(ModuleDao moduleDao, ModulePresenter modulePresenter) {
        return new ModuleModelImpl(moduleDao, modulePresenter);
    }

    @Provides @Singleton
    public ModuleFragment provideModuleFragment(ModulePresenter modulePresenter, UserMVP.UserPresenter userPresenter) {
        return ModuleFragment.newInstance(modulePresenter, userPresenter);
    }
}
