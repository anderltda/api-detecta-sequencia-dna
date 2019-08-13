package br.com.api.sequencia.dna.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> home() {
        final String body = "{ \"applicationName\": \"Api Sequencia DNA\", \"applicationVersion\" : \""
                .concat(applicationVersion).concat("\"}");
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }

}
