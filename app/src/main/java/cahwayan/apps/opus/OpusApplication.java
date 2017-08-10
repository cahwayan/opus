package cahwayan.apps.opus;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import cahwayan.apps.opus.injection.component.application.ApplicationComponent;
import cahwayan.apps.opus.injection.component.application.DaggerApplicationComponent;
import cahwayan.apps.opus.injection.module.application.ApplicationModule;
import cahwayan.apps.opus.injection.module.course.CourseModule;
import cahwayan.apps.opus.injection.module.user.UserModule;
import timber.log.Timber;

/**
 * Created by felip on 07-Aug-17.
 */

public class OpusApplication extends Application {

    private final ApplicationComponent applicationComponent = createApplicationComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree()); // TODO: Instal crashlytics tree in production
            Timber.d("Application is in DEBUG and started with Timber!");
        }
    }

    protected ApplicationComponent createApplicationComponent() {
        return DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .userModule(new UserModule())
                .courseModule(new CourseModule())
                .build();
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
