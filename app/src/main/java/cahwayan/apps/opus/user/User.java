package cahwayan.apps.opus.user;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by felip on 08-Aug-17.
 */

@Entity
public class User {

    @PrimaryKey
    private int id;
    private String name;
    private String email;
    private String activeCourse;

    public User(int id, String name, String email, String activeCourse) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.activeCourse = activeCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActiveCourse() {
        return activeCourse;
    }

    public void setActiveCourse(String activeCourse) {
        this.activeCourse = activeCourse;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", activeCourse='" + activeCourse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!name.equals(user.name)) return false;
        if (!email.equals(user.email)) return false;
        return activeCourse.equals(user.activeCourse);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + activeCourse.hashCode();
        return result;
    }
}
