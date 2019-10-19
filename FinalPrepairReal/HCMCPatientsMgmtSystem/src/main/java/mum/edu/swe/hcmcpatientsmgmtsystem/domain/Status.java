package mum.edu.swe.hcmcpatientsmgmtsystem.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Status {

    // 0-YES 1-NO
    public Map<String, String> outPatient = new HashMap<String, String>() {
        {
            put("Yes", "Yes");
            put("No", "No");
        }
    };


}
