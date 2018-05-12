package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources("classpath:config.properties")
public interface AppProperties extends Config {
    @Key("url.base")
    @DefaultValue("http://petstore.swagger.io/")
    String baseUrl();

    @Key("url.path")
    @DefaultValue("/v2/pet")
    String basePath();

    @Key("pet.name")
    String petName();

    @Key("pet.id")
    String petId();
}
