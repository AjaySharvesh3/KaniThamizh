package alphawolf.wolfpack.ajaysharvesh.kanithamizh.Menus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import alphawolf.wolfpack.ajaysharvesh.kanithamizh.Kalangal;
import alphawolf.wolfpack.ajaysharvesh.kanithamizh.R;
import alphawolf.wolfpack.ajaysharvesh.kanithamizh.Registrations.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView bankCard, ideaCard, addcard, linkCard, logout;

    private FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance() ;

        bankCard = (CardView) findViewById(R.id.bankcardId);
        ideaCard = (CardView) findViewById(R.id.ideaCard);
        addcard = (CardView) findViewById(R.id.addCard);
        linkCard = (CardView) findViewById(R.id.settings);
        logout = (CardView) findViewById(R.id.wifiCard);

        bankCard.setOnClickListener(this);
        ideaCard.setOnClickListener(this);
        addcard.setOnClickListener(this);
        linkCard.setOnClickListener(this);
        logout.setOnClickListener(this);

        /*logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });*/

        signOut() ;
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.bankcardId:
                i = new Intent(MainActivity.this, Kalangal.class);
                startActivity(i);
                break;

            case R.id.ideaCard:
                Toast.makeText(this, "Idea Activity Appears", Toast.LENGTH_SHORT).show();
                break;

            case R.id.addCard:
                Toast.makeText(this, "Add Activity Appears", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                break;

            case R.id.wifiCard:
                signOut() ;
                break ;

            default: break;
        }
    }
    public void signOut() {
        auth.signOut();
// this listener will be called when there is change in firebase user session
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
    }
}
