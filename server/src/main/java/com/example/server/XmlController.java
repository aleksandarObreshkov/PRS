package com.example.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/xml")
public class XmlController {

    private final XmlMapper xmlMapper = new XmlMapper();

    @GetMapping
    public ResponseEntity<Object> printXml() throws IOException {
        String pathToXml = "models/src/main/resources/data.xml";
        File xmlFile =  new File(pathToXml);
        Object value = xmlMapper.readValue(xmlFile, new TypeReference<>() {});
        return ResponseEntity.ok(value);
    }
}
