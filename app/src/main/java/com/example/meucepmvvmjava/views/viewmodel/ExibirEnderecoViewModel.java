package com.example.meucepmvvmjava.views.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.meucepmvvmjava.listeners.APIListener;
import com.example.meucepmvvmjava.model.Cep;
import com.example.meucepmvvmjava.repositorios.CepRepositorio;
import com.example.meucepmvvmjava.repositorios.remoto.services.CepService;

public class ExibirEnderecoViewModel extends AndroidViewModel {

    public ExibirEnderecoViewModel(@NonNull Application application) {
        super(application);
    }

    private CepRepositorio repositorio = new CepRepositorio();

    private MutableLiveData<Cep> _MeuCep  = new MutableLiveData<>();
    public LiveData<Cep> meuCep = _MeuCep;

    private MutableLiveData<String> _Mensagem = new MutableLiveData<>();
    public LiveData<String> mensagem  = _Mensagem;

    public void buscarCep(String cep){

        APIListener<Cep> listener = new APIListener<Cep>() {
            @Override
            public void onSuccess(Cep result) {
                _MeuCep.setValue(result);
            }

            @Override
            public void onFailures(String mensagem) {
                _Mensagem.setValue(mensagem);
            }
        };

        repositorio.buscarCep(cep,listener);

    }
}
