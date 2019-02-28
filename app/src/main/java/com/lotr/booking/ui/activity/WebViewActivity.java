package com.lotr.booking.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.ClientCertRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.just.agentweb.AgentWeb;
import com.lotr.booking.R;

import static com.lotr.booking.Config.BOOKING_MAIN_URL;
import static com.lotr.booking.Config.jsscript;

public class WebViewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private ViewGroup container;
    private AgentWeb mAgentWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        setUpNavigation();
        //setUpWebView();
    }

    private void setUpWebView() {
        container = findViewById(R.id.container);

        WebViewClient mWebViewClient = new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //setDrawerToggleState(view.canGoBack());
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                //setDrawerToggleState(view.canGoBack());
                applyJavaScript();
            }

            @Override
            public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
                super.onReceivedClientCertRequest(view, request);
                //setDrawerToggleState(view.canGoBack());
            }
        };

        WebChromeClient mWebChromeClient = new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                /*if (newProgress > 30 && newProgress < 50) {
                    applyJavaScript();
                }*/
                setDrawerToggleState(view.canGoBack());
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (title.contains("Booking.com:")) {
                    title = title.replace("Booking.com:", "");
                }

                if (title.contains("Booking.com")) {
                    title = title.replace("Booking.com", "");
                }

                toolbar.setTitle(title);
            }
        };

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(container, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .createAgentWeb()
                .ready()
                .go(BOOKING_MAIN_URL);
    }

    private void setUpNavigation() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setToolbarNavigationClickListener(v -> onBackPressed());
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void applyJavaScript() {
        String script = "(function() { " + jsscript + "  })();";
        mAgentWeb.getJsAccessEntrace().callJs(script);
    }

    private void setDrawerToggleState(boolean state) {
        toggle.setDrawerIndicatorEnabled(!state);
        getSupportActionBar().setDisplayHomeAsUpEnabled(state);
        toggle.syncState();
    }

    private void showProgress(boolean state) {

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (!mAgentWeb.back()) {
                super.onBackPressed();
            }
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

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
