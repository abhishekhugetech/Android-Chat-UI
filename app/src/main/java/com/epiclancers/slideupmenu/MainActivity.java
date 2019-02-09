package com.epiclancers.slideupmenu;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.epiclancers.slideupmenu.ui.adapters.TheUserAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        setUpRecyclerView();
        setUpFab();
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.nav_menu_icon);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpFab() {
        final FloatingActionButton fab = findViewById(R.id.fab_menu);
        final LinearLayout linearLayout = findViewById(R.id.linear_layout);
        final View padding = findViewById(R.id.padding);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayout.getVisibility() == View.GONE){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fab.setImageResource(R.drawable.ic_close);
                        }
                    },500);
                    padding.setTranslationY(500);
                    padding.animate().setDuration(300).alpha(1).translationYBy(-500);
                    linearLayout.setTranslationY(500);
                    linearLayout.animate().setDuration(300).translationYBy(-500);
                    linearLayout.setVisibility(View.VISIBLE);
                }else {
                    padding.setAlpha(0);
                    fab.setImageResource(R.drawable.android_menu);
                    linearLayout.animate().translationYBy(500).setDuration(200);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            linearLayout.animate().translationYBy(-500).setDuration(200);
                            linearLayout.setVisibility(View.GONE);
                        }
                    },200);
                }
            }
        });
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TheUserAdapter adapter = new TheUserAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate( R.menu.menu , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home){
            // Do stuff
            Toast.makeText(this, "Menu Clicked", Toast.LENGTH_SHORT).show();
        }
        if ( itemId == R.id.new_chat){
            Toast.makeText(this, "Adding New Chat", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
