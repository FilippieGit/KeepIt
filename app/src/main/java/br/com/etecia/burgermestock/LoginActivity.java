package br.com.etecia.burgermestock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button btnEsqSenha, btnEntrar, btnCriarConta;
    TextInputEditText txtSenha, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //apresentando as variáveis do java para o xml
        btnCriarConta = findViewById(R.id.btnLoginCriarConta);
        btnEntrar = findViewById(R.id.btnLoginEntrar);
        txtEmail = findViewById(R.id.idTextoUsuario);
        txtSenha = findViewById(R.id.idTextoSenha);
        btnEsqSenha = findViewById(R.id.btnLoginEsqueceuSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;

                email = txtEmail.getText().toString().trim();
                password = txtSenha.getText().toString().trim();

                if (email.equals("etecia") && password.equals("etecia")) {
                    startActivity(new Intent(getApplicationContext(),
                            ProdutosActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Usuários ou senha inválidos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEsqSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), EsqSenhaActivity.class));
                finish();

            }
        });

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), CriarContaActivity.class));
                finish();

            }
        });


    }
}