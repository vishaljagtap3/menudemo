package in.bitcode.menudemo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContextMenuActivity extends AppCompatActivity {

    private TextView mTxtInfo;
    private EditText mEdtInfo;

    public final int MENU_COPY = 1, MENU_CUT = 2, MENU_PASTE = 3, MENU_APPEND = 4, MENU_CLEAR = 5;
    public final int DEFAULT_GROUP_ID = 1;

    private String mCopiedString = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        mt("onCreateContextMenu");

        if( view == mTxtInfo ) {
            MenuItem menuItemPaste = menu.add( DEFAULT_GROUP_ID, MENU_PASTE, 0, "Paste");
            MenuItem menuItemAppend = menu.add( DEFAULT_GROUP_ID, MENU_APPEND, 0, "Append");
            if( mCopiedString == null ) {
                menuItemPaste.setEnabled( false );
                menuItemAppend.setEnabled( false );
            }
            menu.add( DEFAULT_GROUP_ID, MENU_CLEAR, 0, "Clear");
        }
        if( view.getId() == R.id.edtInfo ) {
            menu.add( DEFAULT_GROUP_ID, MENU_COPY, 0, "Copy");
            menu.add( DEFAULT_GROUP_ID, MENU_CUT, 0, "Cut");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ){
            case MENU_COPY:
                mCopiedString = mEdtInfo.getText().toString();
                break;
            case MENU_CUT:
                mCopiedString = mEdtInfo.getText().toString();
                mEdtInfo.setText("");
                break;

            case MENU_PASTE:
                mTxtInfo.setText( mCopiedString );
                break;
            case MENU_APPEND:
                mTxtInfo.append( mCopiedString );
                break;
            case MENU_CLEAR:
                mTxtInfo.setText("");
                break;

        }


        return super.onContextItemSelected(item);
    }

    private void init() {

        setContentView(R.layout.context_menu_activity);

        mTxtInfo = findViewById( R.id.txtInfo );
        mEdtInfo = findViewById( R.id.edtInfo );

        registerForContextMenu( mTxtInfo );
        registerForContextMenu( mEdtInfo );
    }

    private void mt( String text){
        Toast.makeText( this, text, Toast.LENGTH_LONG).show();
    }
}
