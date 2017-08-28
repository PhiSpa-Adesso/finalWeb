package com.finalweb.finalweb.controllers;

import com.finalweb.finalweb.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping("/text/{text}")
    public String text(ModelMap modelMap, @PathVariable String text){
        modelMap.put("a",text);
        return "hello";
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String generateObject(Model model){
        model.addAttribute("person", new Person());
        return "personGenerato";
    }
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String showGeneratedPerson(@ModelAttribute Person person){
        return "showGeneratedPerson";
    }
}
