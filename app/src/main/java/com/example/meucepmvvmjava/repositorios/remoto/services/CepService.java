package com.example.meucepmvvmjava.repositorios.remoto.services;


import com.example.meucepmvvmjava.model.Cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {
    @GET("{cep}/json/")
    Call<Cep> buscarCep(@Path(value = "cep",encoded = true) String cep);
}
