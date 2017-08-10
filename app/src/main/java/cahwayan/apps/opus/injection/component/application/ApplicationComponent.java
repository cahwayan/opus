package cahwayan.apps.opus.injection.component.application;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import cahwayan.apps.opus.OpusApplication;
import cahwayan.apps.opus.courses.CourseActivity;
import cahwayan.apps.opus.courses.coursemodel.modules.ModuleFragment;
import cahwayan.apps.opus.courses.coursemodel.modules.ModuleMVP;
import cahwayan.apps.opus.courses.database.CourseDatabase;
import cahwayan.apps.opus.courses.database.dao.ModuleDao;
import cahwayan.apps.opus.injection.module.application.ApplicationModule;
import cahwayan.apps.opus.injection.module.course.CourseModule;
import cahwayan.apps.opus.injection.module.user.UserModule;
import cahwayan.apps.opus.injection.scope.Runtime;
import cahwayan.apps.opus.user.UserMVP;
import cahwayan.apps.opus.user.UserModelImpl;
import cahwayan.apps.opus.user.UserPresenterImpl;
import cahwayan.apps.opus.user.database.UserDatabase;
import cahwayan.apps.opus.user.database.dao.UserDao;
import dagger.Component;
import dagger.Provides;

/**
 * Created by felip on 07-Aug-17.
 */

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                CourseModule.class,
                UserModule.class
        }
)
public interface ApplicationComponent {

    void inject(CourseActivity courseActivity);

    OpusApplication application();
    Context applicationContext();
    Executor executor();

    /**
     * Course related objects
     * */
    ModuleDao moduleDao();
    ModuleMVP.ModulePresenter modulePresenter();
    ModuleMVP.ModuleModel moduleModel();
    ModuleFragment moduleFragment();


    /**
     * User related objects
     * */
    UserDao userDao();
    UserMVP.UserModel userModel();
    UserMVP.UserPresenter userPresenter();


}
