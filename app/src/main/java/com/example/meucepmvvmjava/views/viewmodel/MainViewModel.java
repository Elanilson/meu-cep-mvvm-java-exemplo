package com.example.meucepmvvmjava.views.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<Boolean> _Validado  = new MutableLiveData<>();
    public LiveData<Boolean> validado = _Validado;

    private MutableLiveData<String> _Mensagem = new MutableLiveData<>();
    public LiveData<String> mensagem  = _Mensagem;

    public void validarCampo(String cep){
        if(cep != null && cep != "" && cep != " "){
            _Validado.setValue(true);
        }else{
            _Mensagem.setValue ("Preencha o campo corretamente!");
        }
    }
}
