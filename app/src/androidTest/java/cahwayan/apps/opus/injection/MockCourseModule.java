package cahwayan.apps.opus.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import cahwayan.apps.opus.courses.coursemodel.modules.ModuleFragment;
import cahwayan.apps.opus.courses.coursemodel.modules.ModuleModelImpl;
import cahwayan.apps.opus.courses.coursemodel.modules.ModulePresenterImpl;
import cahwayan.apps.opus.courses.database.CourseDatabase;
import cahwayan.apps.opus.courses.database.dao.ModuleDao;
import dagger.Module;
import dagger.Provides;

import static cahwayan.apps.opus.courses.coursemodel.modules.ModuleMVP.*;
import static cahwayan.apps.opus.user.UserMVP.*;

/**
 * Created by felip on 08-Aug-17.
 */

@Module
public class MockCourseModule {

    public MockCourseModule() {
    }

    /**
     * Database providers
     * */
    @Provides
    @Singleton
    public CourseDatabase provideCourseDatabase(Context context) {
        return Room.inMemoryDatabaseBuilder(context.getApplicationContext(), CourseDatabase.class).build();
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
    public ModuleFragment provideModuleFragment(final ModulePresenter modulePresenter, final UserPresenter userPresenter) {
        return ModuleFragment.newInstance(modulePresenter, userPresenter);
    }
}
