package hofstedematheus.tasker_remote.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import hofstedematheus.tasker_remote.Adapter.MainCardsAdapter;
import hofstedematheus.tasker_remote.Etc.RecyclerItemClickListener;
import hofstedematheus.tasker_remote.Etc.TaskerHelper;
import hofstedematheus.tasker_remote.Fragments.AboutFragment;
import hofstedematheus.tasker_remote.Fragments.HomeFragment;
import hofstedematheus.tasker_remote.Fragments.RemotesFragment;
import hofstedematheus.tasker_remote.Fragments.SettingsFragment;
import hofstedematheus.tasker_remote.Objects.Task;
import hofstedematheus.tasker_remote.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    RecyclerView recyclerView;
    NavigationView navigationView;
    FloatingActionButton fab;

    MainCardsAdapter mainCardsAdapter;
    TaskerHelper taskerHelper;
    Task task;

    private Toolbar toolbar;

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, new HomeFragment());
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(MainActivity.this, ConfigureActionActivity.class);
                startActivity(intent);
            }
        });


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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
        } else if (id == R.id.nav_remotes) {
            fragment = new RemotesFragment();
        } else if (id == R.id.nav_settings) {
            fragment = new SettingsFragment();
        } else if(id == R.id.nav_about){
            fragment = new AboutFragment();
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
