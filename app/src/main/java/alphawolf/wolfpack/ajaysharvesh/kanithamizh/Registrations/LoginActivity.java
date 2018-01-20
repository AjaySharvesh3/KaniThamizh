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

public class LoginActivity extends AppCompatActivity {

    private EditText emailID, passCode ;

    private Button  register, resetCode ;
    private ProgressDialog progressDialog ;

    private SubmitButton signin;

    private FirebaseAuth auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_login) ;

        progressDialog = new ProgressDialog(this) ;

        auth = FirebaseAuth.getInstance() ;

        if(auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class)) ;
            finish() ;
        }

        setContentView(R.layout.activity_login) ;

        emailID = (EditText) findViewById(R.id.emailID) ;
        passCode = (EditText) findViewById(R.id.passcode) ;

        signin = (SubmitButton) findViewById(R.id.signin) ;
        register = (Button) findViewById(R.id.regBtn) ;
        resetCode = (Button) findViewById(R.id.resetCode) ;

        auth = FirebaseAuth.getInstance() ;

        registerHere() ;
        resetCode() ;
        signInMethod() ;

    }

    public void registerHere() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    public void resetCode() {
        resetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasscodeActivity.class));
            }
        });
    }

    public void signInMethod() {
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailID.getText().toString() ;
                final String password = passCode.getText().toString() ;

                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_LONG).show() ;
                    return ;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter your correct password", Toast.LENGTH_SHORT).show() ;
                    return ;
                }

                progressDialog.setMessage("உள்நுழைகிறது.. ") ;
                progressDialog.show() ;

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()) {
                            if(password.length() < 6) {
                                passCode.setError(getString(R.string.errormessageforpassword)) ;
                                progressDialog.dismiss() ;
                            } else {
                                Toast.makeText(LoginActivity.this, getString(R.string.authFailed), Toast.LENGTH_LONG).show() ;
                                progressDialog.dismiss() ;
                            }
                        } else {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class)) ;
                            progressDialog.dismiss() ;
                        }
                    }
                });
            }
        });
    }
}
