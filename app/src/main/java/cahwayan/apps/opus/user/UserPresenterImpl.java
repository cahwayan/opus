package cahwayan.apps.opus.user;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;

import javax.inject.Inject;

import cahwayan.apps.opus.courses.coursemodel.CourseType;

import static cahwayan.apps.opus.user.UserMVP.*;

/**
 * Created by felip on 08-Aug-17.
 */

public class UserPresenterImpl implements UserPresenter {

    private UserModel userModel;
    private UserView userView;

    private LiveData<User> userLiveData;
    private LiveData<UserProgress> userProgressLiveData;

    @Inject
    public UserPresenterImpl(UserModel userModel) {
        this.userModel = userModel;
        this.userModel.setPresenter(this);
    }

    @Override
    public void init(int userId) {
        if(userLiveData.getValue() == null) {
            userLiveData = userModel.getUser(userId);
        }

        if(userProgressLiveData.getValue() == null) {
            userProgressLiveData = Transformations.switchMap(userLiveData, new Function<User, LiveData<UserProgress>>() {
                @Override
                public LiveData<UserProgress> apply(User user) {
                    return userModel.getUserProgress(user.getActiveCourse());
                }
            });
        }
    }

    @Override
    public void saveUser(User user) {
        if(user != null) {
            userModel.saveUser(user);
        }
    }

    @Override
    public void saveUserProgress(UserProgress userProgress) {
        if(userProgress != null) {
            userModel.saveUserProgress(userProgress);
        }
    }

    @Override
    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }

    @Override
    public LiveData<UserProgress> getUserProgressLiveData() {
        return userProgressLiveData;
    }

    @Override
    public void setUserView(UserView view) {
        this.userView = view;
    }


}
