package org.vashonsd.AdventureGalley.Provision;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.InputStream;

public class YamlReader {
    ObjectMapper mapper;
    InputStream is;

    public YamlReader(String filename) {
        this.mapper = new ObjectMapper(new YAMLFactory());
        is = getClass().getClassLoader().getResourceAsStream(filename + ".yaml");
    }

    public WorldSchema readYaml() {
        try {
            WorldSchema ws = mapper.readValue(is, WorldSchema.class);
            ws.deserialize();
            return ws;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
