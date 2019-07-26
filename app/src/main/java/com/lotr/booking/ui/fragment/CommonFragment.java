package com.lotr.booking.ui.fragment;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.navigation.fragment.NavHostFragment;
import com.lotr.booking.ui.activity.NavigationActivity;
import com.lotr.booking.R;

public class CommonFragment extends Fragment {

    protected final static int STORAGE_PERMISSION_REQUEST_CODE = 3;
    protected Toolbar toolbar;

    protected void setUpToolbar(@NonNull View parentView, @IdRes int toolbarResId, boolean primaryScreen, String title) {
        toolbar = parentView.findViewById(toolbarResId);
        if (toolbar == null) throw new RuntimeException("Toolbar non found in layout");
        toolbar.setVisibility(View.VISIBLE);

        AppCompatActivity act = ((AppCompatActivity) getActivity());
        act.setSupportActionBar(toolbar);
        // Отключается стандартный заголовок toolbar для установки кастомного
        if (act.getSupportActionBar() != null) {
            act.getSupportActionBar().setDisplayShowTitleEnabled(false);
            //act.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (!TextUtils.isEmpty(title)) {
            ((TextView) toolbar.findViewById(R.id.title)).setText(title);
        }

        DrawerLayout drawerLayout = ((NavigationActivity) getActivity()).getDrawerLayout();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        // Установка кастомной иконки для Drawer Indicator
        toggle.setDrawerIndicatorEnabled(false);

        if (primaryScreen) {
            toolbar.setNavigationIcon(R.drawable.icondrawertotoggle);
            toolbar.setNavigationOnClickListener(view -> ((NavigationActivity) getActivity()).showDrawer(true));
        } else {
            toolbar.setNavigationIcon(R.drawable.iconback);
            toolbar.setNavigationOnClickListener(v -> goBackStack());
        }
    }

    /**
     * Делает переход назад по стеку фрагментов
     * С помощью NavController, если фрагмент запущен через него
     * Либо через FragmentManager
     */
    protected void goBackStack() {
        if (!NavHostFragment.findNavController(this).popBackStack()) {
            getFragmentManager().popBackStack();
        }
    }

    protected void setUpTitle(@IdRes int resId, String text) {
        TextView title = toolbar.findViewById(resId);
        if (title != null) {
            title.setText(text);
        }
    }

    protected void setUpFocusTo(EditText edittext) {
        edittext.setFocusableInTouchMode(true);
        edittext.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edittext, InputMethodManager.SHOW_IMPLICIT);
    }

    protected void hideInput(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getActivity().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    protected void showInput(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void showStatusBar(boolean state) {
        if (state) {
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case STORAGE_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //saveMedia(savedMedia);
                }
                break;
        }
    }

    protected boolean isStoragePermissionGranted() {
        int result = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    protected void requestStoragePermission() {
        requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_REQUEST_CODE);
    }
}
