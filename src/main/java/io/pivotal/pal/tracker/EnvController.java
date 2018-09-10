package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    public Map<String, String> envmap;

    public EnvController(
            @Value("${PORT:NOT SET}") String port,
            @Value("${MEMORY_LIMIT:NOT SET}") String memory_limit,
            @Value("${CF_INSTANCE_INDEX:NOT SET}") String cf_instance_index,
            @Value("${CF_INSTANCE_ADDR:NOT SET}") String cf_instance_addr
    ){
        this.envmap = new HashMap<>();
        this.envmap.put("PORT", port);
        this.envmap.put("MEMORY_LIMIT", memory_limit);
        this.envmap.put("CF_INSTANCE_INDEX", cf_instance_index);
        this.envmap.put("CF_INSTANCE_ADDR", cf_instance_addr);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        return this.envmap;
    }
}
