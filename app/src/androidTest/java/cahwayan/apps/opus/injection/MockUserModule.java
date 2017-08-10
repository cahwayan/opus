package cahwayan.apps.opus.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import cahwayan.apps.opus.user.UserMVP;
import cahwayan.apps.opus.user.UserModelImpl;
import cahwayan.apps.opus.user.UserPresenterImpl;
import cahwayan.apps.opus.user.database.UserDatabase;
import cahwayan.apps.opus.user.database.dao.UserDao;
import dagger.Module;
import dagger.Provides;

/**
 * Created by felip on 08-Aug-17.
 */

@Module
public class MockUserModule {

    public MockUserModule() {}

    @Provides
    @Singleton
    UserDatabase provideUserDatabase(Context context) {
        return Room.inMemoryDatabaseBuilder(context.getApplicationContext(), UserDatabase.class).build();
    }

    @Provides @Singleton
    UserDao provideUserDao(UserDatabase userDatabase) {
        return userDatabase.userDao();
    }

    @Provides @Singleton
    UserMVP.UserModel provideUserModel(UserDao userDao, Executor executor) {
        return new UserModelImpl(userDao, executor);
    }

    @Provides @Singleton
    UserMVP.UserPresenter provideUserPresenter(UserMVP.UserModel userModel) {
        return new UserPresenterImpl(userModel);
    }
}
