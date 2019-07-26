package com.harts.app.views.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.WindowManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.harts.app.R;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);
        ButterKnife.bind(this);
        setUpNavigation();
        //launchMarket(this, "https%3A%2F%2Fplay.google.com%2Fstore%2Fapps%2Fdetails%3Fid%3Dui.liforapps%26referrer%3D3Dlogolink");
        //launchMarket(this, "by.nitroapps&referrer=3Dlogolink");
    }

    public static void launchMarket(Context context, String packageName) {
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://zigm-cards.com/redir.php?q=" + packageName)));
        /*try {
            context.startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
        }*/
    }

    private void setUpNavigation() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return !Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public void showDrawer(boolean state) {
        if (state) {
            drawerLayout.openDrawer(Gravity.START);
        } else {
            drawerLayout.closeDrawer(Gravity.START);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
