package br.com.api.sequencia.dna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.sequencia.dna.entity.Dna;
import br.com.api.sequencia.dna.response.Response;
import br.com.api.sequencia.dna.service.DetectaSequenciaGeneticaService;

/**
 * 
 * @author Anderson Nascimento
 *
 */
@RestController
@RequestMapping("/")
public class ApiDnaController {

    @Value("${application.version}")
    private String applicationVersion;

    @Autowired
    private DetectaSequenciaGeneticaService detectaSequenciaGeneticaService;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> version() {
        final String body = "{ \"applicationName\": \"Api Sequencia DNA\", \"applicationVersion\" : \"".concat(applicationVersion).concat("\"}");
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }

    @RequestMapping(value = "/simian", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> simian(@RequestBody Dna dna) {

        boolean isSimian = detectaSequenciaGeneticaService.isSimian(dna);
        
        final String body = "{\"dna\": \"".concat(String.valueOf(isSimian).concat("\"}"));

        return new ResponseEntity<String>(body, isSimian ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }
    
    @RequestMapping(value = "/stats", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response> stats() {
        
        Response response = detectaSequenciaGeneticaService.stats();

        return ResponseEntity.ok(response);
    }

}
