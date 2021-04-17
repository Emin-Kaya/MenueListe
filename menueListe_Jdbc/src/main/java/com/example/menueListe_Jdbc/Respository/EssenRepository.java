package com.example.menueListe_Jdbc.Respository;

import com.example.menueListe_Jdbc.Model.Essen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EssenRepository extends CrudRepository<Essen, String> {



    @Query(value = "SELECT * FROM essen WHERE kategorie = ?1", nativeQuery = true)
    Essen[] findByKategorie(String kategorie);

    @Query(value = "SELECT * FROM essen WHERE essen_name = ?1", nativeQuery = true)
    Essen[] findByName(String essen_name);

    @Query(value = "SELECT DISTINCT kategorie from essen", nativeQuery = true)
    ArrayList<String> findUniqueKategorie();

}
