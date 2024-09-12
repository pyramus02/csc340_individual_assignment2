package com.csc340.apidemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
class RestApiController {



        @GetMapping("/randomfact")
        public RandomUselessFact getRandomUselessFact () {


        String url = "https://uselessfacts.jsph.pl/api/v2/facts/random";
        RestTemplate restTemplate = new RestTemplate();


        String jsonListResponse = restTemplate.getForObject(url, String.class);

        int i = 2; //API text responses start with two superfluous characters

        while (jsonListResponse.charAt(i) != '\n') {
            i += 1;
        }

        String factStr = jsonListResponse.substring(0,i);





        RandomUselessFact thisRandUselessFact = new RandomUselessFact();


        thisRandUselessFact.setRandomFact(factStr);





        return thisRandUselessFact;







    }


}


