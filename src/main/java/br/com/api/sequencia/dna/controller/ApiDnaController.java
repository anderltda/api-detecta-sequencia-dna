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
import br.com.api.sequencia.dna.util.HelpUtil;

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

    /**
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> version() {
        final String body = "{ \"application\": \"Teste Símios - Mercado Livre - Api Sequencia DNA\", \"version\" : \""
                        .concat(applicationVersion).concat("\"}");
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }

    /**
     * @param dna
     * @return
     */
    @RequestMapping(value = "/simian", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> simian(@RequestBody Dna dna) {

        if (HelpUtil.validCharacter(dna.getId())) {

            boolean isSimian = detectaSequenciaGeneticaService.isSimian(dna);

            final String body = "{\"dna\": \"".concat(String.valueOf(isSimian).concat("\"}"));

            return new ResponseEntity<String>(body, isSimian ? HttpStatus.OK : HttpStatus.FORBIDDEN);

        } else {

            return new ResponseEntity<String>("{ \"erro\": \"As letras da String só podem ser: (A, T, C, G) , que representa cada base nitrogenada do DNA\" }",
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @return
     */
    @RequestMapping(value = "/stats", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response> stats() {
        return ResponseEntity.ok(new Response(detectaSequenciaGeneticaService.stats()));
    }
}
