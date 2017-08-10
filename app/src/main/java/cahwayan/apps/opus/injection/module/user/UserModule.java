package cahwayan.apps.opus.injection.module.user;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import cahwayan.apps.opus.injection.scope.Runtime;
import cahwayan.apps.opus.user.UserMVP;
import cahwayan.apps.opus.user.UserModelImpl;
import cahwayan.apps.opus.user.UserPresenterImpl;
import cahwayan.apps.opus.user.database.UserDatabase;
import cahwayan.apps.opus.user.database.dao.UserDao;
import dagger.Module;
import dagger.Provides;

import static cahwayan.apps.opus.user.UserMVP.*;

/**
 * Created by felip on 08-Aug-17.
 */

@Module
public class UserModule {

    public UserModule() {}

    @Provides @Singleton
    UserDatabase provideUserDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, UserDatabase.USER_DATABASE_NAME).build();
    }

    @Provides @Singleton
    UserDao provideUserDao(UserDatabase userDatabase) {
        return userDatabase.userDao();
    }

    @Provides @Singleton
    UserModel provideUserModel(UserDao userDao, Executor executor) {
        return new UserModelImpl(userDao, executor);
    }

    @Provides @Singleton
    UserPresenter provideUserPresenter(UserModel userModel) {
        return new UserPresenterImpl(userModel);
    }


}
