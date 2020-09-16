package in.bitcode.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final int MENU_NEW_CITY = 1, MENU_SETTINGS = 2, MENU_ABOUT_APP = 3, MENU_EXIT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mt("onCreateOptionsMenu");

        MenuItem menuItem;

        menuItem = menu.add(1, MENU_NEW_CITY, 0, "New City");
        menuItem.setIcon(R.mipmap.ic_launcher);
        menuItem.setEnabled( true );
        menuItem.setVisible( true );
        menuItem.setCheckable( true );
        menuItem.setChecked( true );
        menuItem.setShowAsAction( MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menuItem = menu.add(1, MENU_SETTINGS, 2, "Settings");

        menu.add(2, MENU_ABOUT_APP, 1, "About App");
        menu.add(2, MENU_EXIT, 3, "Exit");

        //menu.setGroupEnabled(1, false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ) {
            case MENU_NEW_CITY:
                mt("New City");
                break;
            case MENU_SETTINGS:
                mt("Settings");
                break;
            case MENU_ABOUT_APP:
                mt("About");
                break;
            case MENU_EXIT:
                mt("Exit");
                System.exit(0);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void mt(String text ) {
        Toast.makeText( this, text, Toast.LENGTH_LONG).show();
    }
}