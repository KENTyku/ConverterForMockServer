package ru.kentyku.converterformockserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String getInfo() {
        String page = "<html>" +
                "<body>" +
                "<h1>Converter v.1</h1>" +
                "<p>Instruction:</p>" +
//                "<br>"+
                "Add to url your string"+
                "</body>" +
                "</html>";
        return page;
    }

    @RequestMapping(value = "getPorts",method = RequestMethod.GET)
    public String getPortsForPom(@RequestParam(value = "textFromPipeLine", required = true) final String textFromPipeLine,
                           @RequestParam(value = "converterType", required = false) final String converterType) {
        //always use default converter
        Converter converter=(null==converterType)?new DefaultConverter():new DefaultConverter();
        String portMapedForPom=converter.convert(textFromPipeLine);
        return portMapedForPom;
    }
}

