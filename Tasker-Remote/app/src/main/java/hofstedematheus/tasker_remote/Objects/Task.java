package hofstedematheus.tasker_remote.Objects;

/**
 * Created by he4dless on 26/11/2016.
 */

public class Task {
    String title;
    String desc;
    String task_name;
    String category;
    String password;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthentication_method() {
        return authentication_method;
    }

    public void setAuthentication_method(int authentication_method) {
        this.authentication_method = authentication_method;
    }

    int authentication_method;
}
