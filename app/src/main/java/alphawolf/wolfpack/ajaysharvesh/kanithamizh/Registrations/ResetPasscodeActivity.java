package alphawolf.wolfpack.ajaysharvesh.kanithamizh.Registrations;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.spark.submitbutton.SubmitButton;

import alphawolf.wolfpack.ajaysharvesh.kanithamizh.R;

public class ResetPasscodeActivity extends AppCompatActivity {

    private EditText inputEmail;
    private Button  btnBack;

    private FirebaseAuth auth;

    private SubmitButton submitButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_passcode);

        inputEmail = (EditText) findViewById(R.id.emailID) ;
        btnBack = (Button) findViewById(R.id.back1) ;
        submitButton = (SubmitButton) findViewById(R.id.changeCode) ;

        progressBar = new ProgressBar(this);

        auth = FirebaseAuth.getInstance() ;

        backMethod() ;

        resetMethod() ;
    }
    public void backMethod() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void resetMethod() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ResetPasscodeActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ResetPasscodeActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                }

                                progressBar.setVisibility(View.GONE);
                            }
                        });
            }
        });
    }
}
