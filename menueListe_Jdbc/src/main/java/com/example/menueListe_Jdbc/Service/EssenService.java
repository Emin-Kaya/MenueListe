package com.example.menueListe_Jdbc.Service;

import com.example.menueListe_Jdbc.Model.Essen;
import com.example.menueListe_Jdbc.Model.EssenRequest;
import com.example.menueListe_Jdbc.Respository.EssenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class EssenService {
    @Autowired
    private EssenRepository essenRepository;

    public void addEssenWithId(Essen essen){
        essenRepository.save(essen);
    }

    public static double withBigDecimal(double value, int places) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public void addEssen(EssenRequest essenRequest){
        String id= UUID.randomUUID().toString();
        Essen essen = Essen.builder()
                .id(id)
                .kategorie(essenRequest.getKategorie())
                .essen_name(essenRequest.getEssen_name())
                .preis(withBigDecimal(essenRequest.getPreis(), 2))
                .bild(essenRequest.getBild())
                .zutaten(essenRequest.getZutaten())
                .build();
        essenRepository.save(essen);
    }

    public Iterable<Essen> getAllEssen(){
       return essenRepository.findAll();
    }

    public Optional<Essen> getEssenById(String id){
        return essenRepository.findById(id);
    }

    public Essen[] getEssenByNamen(String essen_name){
        return essenRepository.findByName(essen_name);
    }

    public ArrayList<String> getUniqueKategorie(){
        return essenRepository.findUniqueKategorie();
    }

    public Essen[] getEssenByKategorie(String essen_name){
        return essenRepository.findByKategorie(essen_name);
    }


    public void delEssenByID(String id){
        essenRepository.deleteById(id);
    }



    public void updateEssen(String id, EssenRequest essenRequest){
        delEssenByID(id);
        Essen essen = Essen.builder()
                .id(id)
                .kategorie(essenRequest.getKategorie())
                .essen_name(essenRequest.getEssen_name())
                .preis(withBigDecimal(essenRequest.getPreis(), 2))
                .bild(essenRequest.getBild())
                .zutaten(essenRequest.getZutaten())
                .build();
        addEssenWithId(essen);
    }
}
