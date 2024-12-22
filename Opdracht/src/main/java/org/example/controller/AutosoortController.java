package org.example.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.example.domein.Autosoort;
import org.example.service.AutosoortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Random;
@Controller
@ResponseBody
@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
@CrossOrigin(origins = {"http://localhost:5000", "http://localhost:8000"})
public class AutosoortController {


    protected AutosoortService autosoortService;

    @Autowired
    public AutosoortController(AutosoortService autosoortService){
        this.autosoortService = autosoortService;
    }

    // REST GET ... breng de toestand van bestaande resources van de server naar de client (lijst van objecten)
    @RequestMapping(value={"/api/v1/autosoorten"},method=RequestMethod.GET)
    @ResponseBody
    // @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public ResponseEntity<List<Autosoort>> getAutosoorts(){

        List<Autosoort> autosoorts = autosoortService.getListOfAutosoorts();
        if (autosoorts != null) return ResponseEntity.ok().body(autosoorts);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    // REST GET ... breng de toestand van bestaande resource van de server naar de client (één object)
    @RequestMapping(value={"/api/v1/autosoorten/{naam}"},method= RequestMethod.GET)
    @ResponseBody
    public  ResponseEntity<Autosoort> getAutosoortByNaam(@PathVariable("naam") String naam){

        Autosoort autosoort = autosoortService.getAutosoortByNaam(naam);
        if (autosoort != null) return ResponseEntity.ok().body(autosoort);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // REST POST ... hiermee wordt een resource gecreeerd
    @RequestMapping(value={"/api/v1/autosoorten"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Autosoort createAutosoort(@RequestBody Autosoort autosoort, HttpServletResponse response)
            throws BindException {

        autosoort.setAutosoortId(autosoortService.addAutosoortD(autosoort.getNaam(), autosoort.getMerk(), autosoort.getHuidigVoorraadniveau(), autosoort.getMinimumpeiler(), autosoort.getMaximumpeiler()));
        return autosoort;
    }

    @RequestMapping(value={"/api/v1/autosoorten"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersons(){
        autosoortService.deleteAllAutosoorts();
    }
}