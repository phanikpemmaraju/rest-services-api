package uk.co.legacy.it.api.resources;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by phani16 on 07/03/2020.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/hello")
@Slf4j
public class HelloResource {

    @GetMapping
    public String defaultHello() {
        log.info("defaultHello method called ");
        return "Hello to everyone !!!";
    }

    @GetMapping(value = "/{name}")
    public String sayHello(@PathVariable String name) {
        log.info("sayHello method called for parameter {}  ", name);
        return "Hello !!! " + name;
    }

}
