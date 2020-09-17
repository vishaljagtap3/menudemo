package in.bitcode.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final int MENU_NEW_CITY = 1, MENU_SETTINGS = 2, MENU_ABOUT_APP = 3, MENU_EXIT = 4;
    public final int MENU_PHONE_SETTINGS = 11, MENU_SYSTEM_SETTINGS = 12;

    private CheckBox mChkSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChkSettings = findViewById( R.id.chkSettings );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mt("onCreateOptionsMenu");

        MenuInflater menuInflater = new MenuInflater( this );
        menuInflater.inflate( R.menu.main_activity, menu);

        /*
        MenuItem menuItem;

        menuItem = menu.add(1, MENU_NEW_CITY, 0, "New City");
        menuItem.setIcon(R.mipmap.ic_launcher);
        menuItem.setEnabled( true );
        menuItem.setVisible( true );
        menuItem.setCheckable( true );
        menuItem.setChecked( true );
        menuItem.setShowAsAction( MenuItem.SHOW_AS_ACTION_IF_ROOM);

        SubMenu subMenu = menu.addSubMenu(1, MENU_SETTINGS, 2, "Settings");
        subMenu.add( 2, MENU_PHONE_SETTINGS, 0, "Phone Settings");
        subMenu.add( 2, MENU_SYSTEM_SETTINGS, 0, "System Settings");

        menu.add(2, MENU_ABOUT_APP, 1, "About App");
        menu.add(2, MENU_EXIT, 3, "Exit");

        //menu.setGroupEnabled(1, false);
        */
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        mt("onPrepareOptionsMenu");
       /* menu.findItem( MENU_SETTINGS )
                .setEnabled( mChkSettings.isChecked() );*/
        menu.findItem( R.id.menuSettings )
                .setEnabled( mChkSettings.isChecked() );

        /*if( mChkSettings.isChecked() ) {
            menuItem.setEnabled( true );
        }
        else {
            menuItem.setEnabled( false );
        }*/

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ) {
            case R.id.menuNewCity:
                mt("New City");
                break;
            case R.id.menuSettings:
                mt("Settings");
                break;
            case R.id.menuAboutApp:
                mt("About");
                break;
            case R.id.menuPhoneSettings:
                mt("Phone Settings");
                break;
            case R.id.menuSystemSettings:
                mt("System Settings");
                break;
            case R.id.menuExit:
                mt("Exit");
                System.exit(0);
                break;
        }

        /*switch ( item.getItemId() ) {
            case MENU_NEW_CITY:
                mt("New City");
                break;
            case MENU_SETTINGS:
                mt("Settings");
                break;
            case MENU_ABOUT_APP:
                mt("About");
                break;
            case MENU_PHONE_SETTINGS:
                mt("Phone Settings");
                break;
            case MENU_SYSTEM_SETTINGS:
                mt("System Settings");
                break;
            case MENU_EXIT:
                mt("Exit");
                System.exit(0);
                break;
        }*/

        return super.onOptionsItemSelected(item);
    }

    private void mt(String text ) {
        Toast.makeText( this, text, Toast.LENGTH_LONG).show();
    }
}