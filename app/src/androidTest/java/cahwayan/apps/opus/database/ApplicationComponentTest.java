package cahwayan.apps.opus.database;

import android.app.Instrumentation;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import cahwayan.apps.opus.MockOpusApplication;
import cahwayan.apps.opus.courses.coursemodel.CourseType;
import cahwayan.apps.opus.courses.coursemodel.modules.Module;
import cahwayan.apps.opus.courses.database.dao.ModuleDao;
import cahwayan.apps.opus.injection.MockApplicationModule;
import cahwayan.apps.opus.injection.MockCourseModule;
import cahwayan.apps.opus.injection.MockUserModule;
import cahwayan.apps.opus.injection.component.application.ApplicationComponent;
import cahwayan.apps.opus.user.User;
import cahwayan.apps.opus.user.UserProgress;
import cahwayan.apps.opus.user.database.dao.UserDao;
import dagger.Component;
import timber.log.Timber;

import static cahwayan.apps.opus.courses.coursemodel.CourseType.FOUNDATION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by felip on 08-Aug-17.
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationComponentTest {

    @Inject
    UserDao userDao;

    @Inject
    ModuleDao moduleDao;

    @Component(
            modules = {
                    MockApplicationModule.class,
                    MockUserModule.class,
                    MockCourseModule.class
            }
    )
    @Singleton
    public interface MockApplicationComponent extends ApplicationComponent {
        void inject(ApplicationComponentTest applicationComponentTest);
    }

    @Before
    public void setup() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();

        MockOpusApplication opusApplication = (MockOpusApplication) instrumentation.getTargetContext().getApplicationContext();

        MockApplicationComponent applicationComponent = (MockApplicationComponent) opusApplication.getApplicationComponent();
        applicationComponent.inject(this);
    }

    /**
     * Tests about the User Dao
     * */

    @Test
    public void insertsUserIntoDatabase() throws Exception {

        User user = new User(0, "Caíque", "cahwayan@gmail.com", FOUNDATION.name());
        userDao.saveUser(user);

        User userRetrieved = getValue(userDao.getUser(0));
        assertEquals(user, userRetrieved);
    }


    @Test
    public void insertsUserProgressIntoDatabase() throws Exception {

        UserProgress userProgress = new UserProgress(FOUNDATION.name(), 0, 0, 0);

        userDao.saveUserProgress(userProgress);

        UserProgress progressRetrieved = getValue(userDao.getUserProgress(FOUNDATION.name()));

        assertEquals(userProgress, progressRetrieved);
    }

    /**
     * Tests the Module Dao
     * */
    @Test
    public void insertModuleIntoDatabase() throws Exception {

        moduleDao.insertModule(createModule());
        moduleDao.insertModule(createModule());
        moduleDao.insertModule(createModule());

        List<Module> modulesRetrieved = getValue(moduleDao.getModuleList(CourseType.FOUNDATION.name()));

        Timber.d(modulesRetrieved.toString());

        Assert.assertNotNull(modulesRetrieved);
    }

    @Test
    public void updateModuleSuccessfully() throws Exception {

        Module module = createModule();
        moduleDao.insertModule(module);

        // Creating equal module and updating
        Module moduleToUpdate = createModule();
        moduleToUpdate.setStageProgress(moduleToUpdate.getStageProgress() + 1);
        // Inserting updated module into database
        moduleDao.updateModule(moduleToUpdate);

        // Retrieving updated module
        List<Module> updatedModules = getValue(moduleDao.getModuleList(CourseType.FOUNDATION.name()));
        Timber.d("Updated modules: " + updatedModules.toString());

        //Timber.d("Stage progress onMemory: " + module.getStageProgress() + " On DB: " + moduleDao.getModule(module.getId()).getStageProgress());
        assertNotNull(updatedModules.get(0));
        assertNotEquals(module, updatedModules.get(0));
    }

    /**
     * This is used to make sure the method waits till data is available from the observer.
     */
    public static <T> T getValue(final LiveData<T> liveData) throws InterruptedException {
        final Object[] data = new Object[1];
        final CountDownLatch latch = new CountDownLatch(1);
        Observer<T> observer = new Observer<T>() {
            @Override
            public void onChanged(@Nullable T o) {
                data[0] = o;
                latch.countDown();
                liveData.removeObserver(this);
            }
        };
        liveData.observeForever(observer);
        latch.await(2, TimeUnit.SECONDS);
        //noinspection unchecked
        return (T) data[0];
    }

    public Module createModule() {

        return new Module(0, CourseType.FOUNDATION.name(), "Fundamentos", "cahwayan.apps.opus.R.drawable.foundation", 99, 5, 0);
    }


}
