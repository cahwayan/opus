package cahwayan.apps.opus.user;

import android.arch.lifecycle.LiveData;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import cahwayan.apps.opus.user.UserMVP.UserPresenter;
import cahwayan.apps.opus.user.database.dao.UserDao;

/**
 * Created by felip on 08-Aug-17.
 */

public class UserModelImpl implements UserMVP.UserModel {

    private UserDao userDao;
    private Executor executor;
    private UserPresenter userPresenter;

    @Inject
    public UserModelImpl(UserDao userDao, Executor executor) {
        this.userDao = userDao;
        this.executor = executor;
    }

    @Override
    public LiveData<User> getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Override
    public LiveData<UserProgress> getUserProgress(String courseName) {
        return userDao.getUserProgress(courseName);
    }

    @Override
    public void saveUserProgress(final UserProgress userProgress) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.saveUserProgress(userProgress);
            }
        });
    }

    @Override
    public void saveUser(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.saveUser(user);
            }
        });

    }

    @Override
    public void setPresenter(UserPresenter presenter) {
        this.userPresenter = presenter;
    }
}
