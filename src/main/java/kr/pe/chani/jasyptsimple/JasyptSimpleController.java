package kr.pe.chani.jasyptsimple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class JasyptSimpleController {

    @Value("${example.test}")
    private String exampleProperty;

    @GetMapping(value = "/property")
    public String property() {
//        return "test";
        return exampleProperty;
    }
}
