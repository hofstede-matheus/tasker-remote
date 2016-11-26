package hofstedematheus.tasker_remote.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import hofstedematheus.tasker_remote.Adapter.MainCardsAdapter;
import hofstedematheus.tasker_remote.Etc.RecyclerItemClickListener;
import hofstedematheus.tasker_remote.Etc.TaskerIntent;
import hofstedematheus.tasker_remote.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MainCardsAdapter mainCardsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] names = {"Task1","task2","task3","task4","task5"};

        recyclerView = (RecyclerView)findViewById(R.id.main_RV);
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
                        Toast.makeText(getApplicationContext(), TaskerIntent.testStatus(getApplicationContext()) + "" + position, Toast.LENGTH_SHORT).show();
                        if (TaskerIntent.testStatus(getApplicationContext()).equals(TaskerIntent.Status.OK)){
                            TaskerIntent i = new TaskerIntent(taskName);
                            sendBroadcast(i);
                        }
                    }
                })
        );
    }
}
