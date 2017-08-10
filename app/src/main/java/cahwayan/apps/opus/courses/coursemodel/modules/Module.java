package cahwayan.apps.opus.courses.coursemodel.modules;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import cahwayan.apps.opus.courses.coursemodel.CourseType;

/**
 * Created by Caíque on 07-Aug-17.
 * This class represents a single module on the course.
 * The course is composed of modules, stages and lessons.
 * A module contain stages, and stages contain lessons.
 */

@Entity
public class Module implements Parcelable {

    /**
     * Module states. The state is defined by the current user progress.
     * @see ModuleModelImpl for business logic of how the states are determined
     * */
    public static final int MODULE_LOCKED = 0;
    public static final int MODULE_UNLOCKED_INCOMPLETE = 1;
    public static final int MODULE_UNLOCKED_COMPLETE = 2;

    /**
     * The id is only for the database storage. We find the module courses by the field courseType
     * */
    @PrimaryKey
    private int id;

    /**
     * Holds the current course type.
     * @see CourseType to see the course types
    * */
    private String courseType;

    private String title;
    private String drawableResId;
    private int numberOfStages;
    private int stageProgress;
    private int state;

    public Module(int id, String courseType, String title, String drawableResId, int numberOfStages, int stageProgress, int state) {
        this.id = id;
        this.courseType = courseType;
        this.title = title;
        this.drawableResId = drawableResId;
        this.numberOfStages = numberOfStages;
        this.stageProgress = stageProgress;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDrawableResId() {
        return drawableResId;
    }

    public void setDrawableResId(String drawableResId) {
        this.drawableResId = drawableResId;
    }

    public int getStageProgress() {
        return stageProgress;
    }

    public void setStageProgress(int stageProgress) {
        this.stageProgress = stageProgress;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getNumberOfStages() {
        return numberOfStages;
    }

    public void setNumberOfStages(int numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.courseType);
        dest.writeString(this.title);
        dest.writeString(this.drawableResId);
        dest.writeInt(this.numberOfStages);
        dest.writeInt(this.stageProgress);
        dest.writeInt(this.state);
    }

    protected Module(Parcel in) {
        this.courseType = in.readString();
        this.title = in.readString();
        this.drawableResId = in.readString();
        this.numberOfStages = in.readInt();
        this.stageProgress = in.readInt();
        this.state = in.readInt();
    }

    public static final Creator<Module> CREATOR = new Creator<Module>() {
        @Override
        public Module createFromParcel(Parcel source) {
            return new Module(source);
        }

        @Override
        public Module[] newArray(int size) {
            return new Module[size];
        }
    };

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", courseType='" + courseType + '\'' +
                ", title='" + title + '\'' +
                ", drawableResId=" + drawableResId +
                ", numberOfStages='" + numberOfStages + '\'' +
                ", stageProgress=" + stageProgress +
                ", state=" + state +
                '}';
    }
}
