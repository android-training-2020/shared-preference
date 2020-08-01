package us.erlang.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SPActivity extends AppCompatActivity {
    private EditText input;
    private SharedPreferences sp;
    private static String SP_KEY_FOO = "sp_key_foo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        sp = getBaseContext().getSharedPreferences(getString(R.string.sp_id), Context.MODE_PRIVATE);
        String value = sp.getString(SP_KEY_FOO, "");

        input = findViewById(R.id.sp_key_foo);
        input.setText(value);

        Button button = findViewById(R.id.update_sp_key_foo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(SP_KEY_FOO, input.getText().toString());
                editor.commit();
            }
        });
    }
}