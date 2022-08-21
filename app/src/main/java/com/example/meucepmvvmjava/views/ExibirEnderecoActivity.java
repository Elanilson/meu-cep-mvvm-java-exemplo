package com.example.meucepmvvmjava.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.meucepmvvmjava.R;
import com.example.meucepmvvmjava.databinding.ActivityExibirEnderecoBinding;
import com.example.meucepmvvmjava.model.Cep;
import com.example.meucepmvvmjava.views.viewmodel.ExibirEnderecoViewModel;

public class ExibirEnderecoActivity extends AppCompatActivity {
    private ActivityExibirEnderecoBinding binding;
    private String cep = "";
    private ExibirEnderecoViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExibirEnderecoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(ExibirEnderecoViewModel.class);

        obsevers();
    }

    private void obsevers() {
        viewModel.meuCep.observe(this, new Observer<Cep>() {
            @Override
            public void onChanged(Cep cep) {
                binding.textViewCep.setText(cep.getCep());
                binding.textViewBairro.setText(cep.getBairro());
                binding.textViewLogradouro.setText(cep.getLogradouro());
                binding.textViewComplemento.setText(cep.getComplemento());
                binding.textViewLocalidade.setText(cep.getLocalidade());
                binding.textView2Uf.setText(cep.getComplemento());
                binding.textViewDDD.setText(cep.getLocalidade());
            }
        });

        viewModel.mensagem.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            cep = bundle.getString("cep");
            viewModel.buscarCep(cep);
        }
    }
}