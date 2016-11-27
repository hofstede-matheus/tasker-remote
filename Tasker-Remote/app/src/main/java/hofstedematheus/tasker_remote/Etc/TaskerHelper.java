package hofstedematheus.tasker_remote.Etc;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by he4dless on 26/11/2016.
 */

public class TaskerHelper {
    Context context;

    public TaskerHelper(Context context){
        this.context = context;

    }

    public void callTask(String task_name){
        TaskerIntent i = new TaskerIntent(task_name);
        context.sendBroadcast(i);
    }
    public void showError(){
        Toast.makeText(context, TaskerIntent.testStatus(context).toString(), Toast.LENGTH_SHORT).show();
    }
    public boolean isStatusOK(){
            if(TaskerIntent.testStatus(context).equals(TaskerIntent.Status.OK)){
                return true;
            }else{
                showError();
                return false;
            }
    }
}
