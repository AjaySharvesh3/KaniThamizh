package alphawolf.wolfpack.ajaysharvesh.kanithamizh.Registrations;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.spark.submitbutton.SubmitButton;

import alphawolf.wolfpack.ajaysharvesh.kanithamizh.Menus.MainActivity;
import alphawolf.wolfpack.ajaysharvesh.kanithamizh.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailID, passcode ;
    private Button backBtn;
    private ProgressDialog progressDialog ;

    private SubmitButton submitButton ;

    private FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance() ;

        progressDialog = new ProgressDialog(this) ;

        emailID = (EditText) findViewById(R.id.emailID) ;
        passcode = (EditText) findViewById(R.id.passcode) ;
        backBtn = (Button) findViewById(R.id.back) ;
        submitButton = (SubmitButton) findViewById(R.id.signup) ;

        backButton() ;

        registeringProcess() ;

    }
    public void backButton() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish() ;
            }
        }) ;
    }
    public void registeringProcess() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailID.getText().toString() ;
                String password = passcode.getText().toString() ;

                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter valid email address!", Toast.LENGTH_LONG).show() ;
                    return ;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter valid password!", Toast.LENGTH_LONG).show() ;
                    return ;
                }
                if(password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password should be in maximum 6 characters!", Toast.LENGTH_LONG).show() ;
                    return ;
                }
                progressDialog.setMessage("Registering..") ;
                progressDialog.show() ;

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this, "Email and Password:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();

                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                    progressDialog.dismiss();
                                    //finish();
                                }
                            }
                        });
            }
        }) ;
    }
    @Override
    protected void onResume() {
        super.onResume();
        //progressBar.setVisibility(View.GONE);
        progressDialog.dismiss();
    }
}
