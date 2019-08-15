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
     * @param object - Object que será convertido em JSON
     * @return - string com JSON convertido
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
     * @param object - string com os caracteres especiais
     * @return - string com os caracteres especiais removidos
     */
    public static String removeCharacter(String object) {
        if(StringUtils.isEmpty(object)) {
            return "";
        }
        return object.replaceAll("\\W", "");
    }
    
    
    /**
     * Valida os caracteres validos 
     * @param object - string com os caracteres a serem verificados
     * @return - verdadeiro ou falso
     */
    public static boolean validCharacter(String object) {
        if(StringUtils.isEmpty(object)) {
            return false;
        }
        
        String value = object.replace("A", "").replace("C", "").replace("G", "").replace("T", "");
        
        return value.isEmpty();
    }
}
