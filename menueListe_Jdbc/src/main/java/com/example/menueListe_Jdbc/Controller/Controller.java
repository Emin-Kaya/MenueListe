package com.example.menueListe_Jdbc.Controller;

import com.example.menueListe_Jdbc.Model.Essen;
import com.example.menueListe_Jdbc.Model.EssenRequest;
import com.example.menueListe_Jdbc.Service.EssenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@org.springframework.stereotype.Controller
@RequestMapping(path = "/demo")
public class Controller {
    @Autowired
    private EssenService essenService;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewEssen(@RequestBody EssenRequest essenRequest){
        essenService.addEssen(essenRequest);
        return "Saved";
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<Essen>  getAllEssen(){
        System.out.println("Ah");
        return essenService.getAllEssen();
    }

    @GetMapping(path = "/getById")
    public @ResponseBody Optional<Essen> getEssenById(@RequestParam String id){
        return essenService.getEssenById(id);
    }

    @GetMapping(path = "/getByName")
    public @ResponseBody Essen[] getEssenByNamen(@RequestParam String essen_name){
        return essenService.getEssenByNamen(essen_name);
    }

    @GetMapping(path = "/getByKategorie")
    public @ResponseBody Essen[] getEssenByKategorie(@RequestParam String kategorie){
        return essenService.getEssenByKategorie(kategorie);
    }

    @GetMapping(path = "/getUniqueKategorie")
    public @ResponseBody ArrayList<String> getUniqueKategorie(){
        return essenService.getUniqueKategorie();
    }

    @DeleteMapping(path = "/deleteEssenById")
    public @ResponseBody String delEssen(@RequestParam String id){
        essenService.delEssenByID(id);
        return "Delete";
    }

    @PutMapping(path = "/updateEssenById")
    public @ResponseBody String upEssen(@RequestParam String id, @RequestBody EssenRequest essenRequest){
        essenService.updateEssen(id, essenRequest);
        return "Update";
    }

}
