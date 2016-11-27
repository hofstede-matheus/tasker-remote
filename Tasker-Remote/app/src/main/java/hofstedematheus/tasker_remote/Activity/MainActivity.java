package hofstedematheus.tasker_remote.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import hofstedematheus.tasker_remote.Adapter.MainCardsAdapter;
import hofstedematheus.tasker_remote.Etc.RecyclerItemClickListener;
import hofstedematheus.tasker_remote.Etc.TaskerHelper;
import hofstedematheus.tasker_remote.Etc.TaskerIntent;
import hofstedematheus.tasker_remote.Objects.Task;
import hofstedematheus.tasker_remote.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MainCardsAdapter mainCardsAdapter;
    TaskerHelper taskerHelper;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] names = {"Task1","task2","task3","task4","task5"};

        recyclerView = (RecyclerView)findViewById(R.id.main_RV);

        taskerHelper = new TaskerHelper(this);
        
        task = new Task();
        task.setTitle("Title of task 1");
        task.setDesc("Thats the fucking description of task 1");
        task.setTask_name("cu");
        task.setCategory("Toast");
        task.setPassword(null);
        task.setAuthentication_method(0);


        mainCardsAdapter = new MainCardsAdapter(names);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(mainCardsAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        String taskName = "";
                        switch (position){
                            case 0:
                                taskName = "Lock screen";
                                break;
                            case 1:
                                taskName = "cu";
                                break;
                        }
                        if (taskerHelper.isStatusOK()){
                            taskerHelper.callTask(taskName);
                        }
                    }
                })
        );
    }
}
