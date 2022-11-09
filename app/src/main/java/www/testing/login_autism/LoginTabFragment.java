package www.testing.login_autism;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {

    EditText email, pass;
    Button Login;
    float v = 0;

    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        Login = root.findViewById(R.id.Login);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        Login.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        Login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        Login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }

    public void onStart() {
        super.onStart();
        Button Login_btn = (Button) context.findViewById(R.id.Login);
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, parent_child.class);
                startActivity(intent);
            }
        });
    }
}
