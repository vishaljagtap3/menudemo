package in.bitcode.menudemo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CitiesActivity extends AppCompatActivity {


    private ListView mListViewCities;
    private String [] mArrCities = {
            "Pune", "Mumbai", "Chennai", "Delhi"
    };
    private ArrayAdapter<String> mAdapterCities;

    private final int MENU_SOURCE = 1, MENU_DEST = 2;
    private final int MENU_OFFERS = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.cities_activity);

        mListViewCities = findViewById( R.id.listViewCities );
        mAdapterCities = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mArrCities
        );
        mListViewCities.setAdapter( mAdapterCities );

        registerForContextMenu( mListViewCities );

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.add( 0, MENU_SOURCE, 0, "Source");
        menu.add( 0, MENU_DEST, 0, "Dest");

        if( adapterContextMenuInfo.position == 1 ) {
            menu.add(1, MENU_OFFERS, 0, "Offers");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String citySelected = mArrCities[ adapterContextMenuInfo.position ];

        switch ( item.getItemId() ) {
            case MENU_SOURCE:
                mt("You selected source : " + citySelected);
                break;
            case MENU_DEST:
                mt("You selected dest : " + citySelected);
                break;
            case MENU_OFFERS:
                mt("You selected offers : " + citySelected);
        }

        return super.onContextItemSelected(item);
    }

    private void mt( String text ){
        Toast.makeText( this, text, Toast.LENGTH_LONG).show();
    }
}
