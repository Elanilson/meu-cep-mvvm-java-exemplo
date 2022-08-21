package com.example.meucepmvvmjava.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.meucepmvvmjava.R;
import com.example.meucepmvvmjava.databinding.ActivityMainBinding;
import com.example.meucepmvvmjava.views.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private String campoCep = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campoCep = binding.editTextCep.getText().toString();
                viewModel.validarCampo(campoCep);
            }
        });

        observers();


    }

    private void observers() {
        viewModel.validado.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    irParaProximaTela();
                }
            }
        });
        viewModel.mensagem.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s != ""){
                    Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void irParaProximaTela(){
        Bundle bundle = new Bundle();
        bundle.putString("cep",campoCep);
        Intent intent = new Intent(this,ExibirEnderecoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}