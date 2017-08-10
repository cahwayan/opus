package cahwayan.apps.opus.injection;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import cahwayan.apps.opus.MockOpusApplication;
import cahwayan.apps.opus.OpusApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by felip on 08-Aug-17.
 */

@Module
public class MockApplicationModule {

    private final OpusApplication mockOpusApplication;

    public MockApplicationModule(OpusApplication mockOpusApplication) {
        this.mockOpusApplication = mockOpusApplication;
    }

    @Provides
    @Singleton
    public Executor providePoolExecutor() {
        return Executors.newCachedThreadPool();
    }

    @Provides
    @Singleton
    public OpusApplication provideApplication() {
        return mockOpusApplication;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return mockOpusApplication;
    }
}
