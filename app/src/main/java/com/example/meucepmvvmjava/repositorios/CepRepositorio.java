package com.example.meucepmvvmjava.repositorios;



import com.example.meucepmvvmjava.listeners.APIListener;
import com.example.meucepmvvmjava.model.Cep;
import com.example.meucepmvvmjava.repositorios.remoto.RetrofitClient;
import com.example.meucepmvvmjava.repositorios.remoto.services.CepService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CepRepositorio {
    private CepService service = RetrofitClient.classService(CepService.class);

    public void buscarCep(String cep, APIListener<Cep> listener){

        Call<Cep> call = service.buscarCep(cep);
        call.enqueue(new Callback<Cep>() {
            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {
                if (response.code() == 200){
                    listener.onSuccess(response.body());
                }else{
                    listener.onFailures("cod: "+response.code()+" - "+response.message());
                }
            }
            @Override
            public void onFailure(Call<Cep> call, Throwable t) {
                listener.onFailures(t.getMessage());

            }
        });


    }

}
