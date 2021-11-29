package com.example.isetsl.reservation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Setcontact {
    String URL = "http://10.0.2.2/";

    @GET("affiche.php")
    Call<List<reponse>> setinfo(@Query("ncin") long n1, @Query("nom") String n2, @Query("prenom") String n3, @Query("tel") long n4, @Query("nombre de personne") long n5, @Query("periode") long n6);
}
