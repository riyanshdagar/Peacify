package www.testing.login_autism;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {

    EditText email_signup, name_signup, pass_signup;
    public Button signup;
    float v = 0;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        name_signup = root.findViewById(R.id.name_signup);
        email_signup = root.findViewById(R.id.email_signup);
        pass_signup = root.findViewById(R.id.pass_signup);
        signup = root.findViewById(R.id.sign_up);

        button = root.findViewById(R.id.sign_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpUser();
            }
        });
        return root;
    }

    public void signUpUser() {
        String name = name_signup.getText().toString().trim();
        String email = email_signup.getText().toString().trim();
        String password = pass_signup.getText().toString().trim();

        if (name.isEmpty()) {
            name_signup.setError("This field is required");
            name_signup.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            email_signup.setError("This field is required");
            email_signup.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_signup.setError("Please enter a valid email");
            email_signup.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            pass_signup.setError("This field is required");
            pass_signup.requestFocus();
            return;
        }
        if (password.length() < 6) {
            pass_signup.setError("The password length should be more than 6 characters");
            pass_signup.requestFocus();
            return;
        }
        Toast.makeText(getActivity(), "Your Account is Created Successfully", Toast.LENGTH_SHORT).show();
    }
}
