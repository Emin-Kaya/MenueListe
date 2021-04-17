package com.example.menueListe_Jdbc.Model;

import lombok.Data;

@Data
public class EssenRequest {
    private String kategorie;
    private String essen_name;
    private double preis;
    private String bild;
    private String zutaten;
}
