package cahwayan.apps.opus.injection.module.application;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import cahwayan.apps.opus.OpusApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by felip on 07-Aug-17.
 */

@Module
public class ApplicationModule {

    private final OpusApplication mApplication;

    public ApplicationModule(OpusApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    public Executor providePoolExecutor() {
        return Executors.newCachedThreadPool();
    }

    @Provides
    @Singleton
    public OpusApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}
