package br.com.api.sequencia.dna.util;

import org.springframework.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Anderson Nascimento
 *
 */
public class HelpUtil {

    /**
     * Converte object em json
     * @param object
     * @return
     */
    public static String convertObjectForJson(Object object) {

        ObjectMapper mapper = new ObjectMapper();

        String jsonArray = "{}";
        
        try {
            jsonArray = mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        return jsonArray;
    }

    
    /**
     * Remove caracteres especiais 
     * @param object
     * @return
     */
    public static String removeCharacter(String object) {
        if(StringUtils.isEmpty(object)) {
            return "";
        }
        return object.replaceAll("\\W", "");
    }
    
}
