package com.bukanjoker.witchvillager2.controller;

import com.bukanjoker.witchvillager2.entity.Villager;
import com.bukanjoker.witchvillager2.entity.Witch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WitchVillageController {

    @GetMapping("/")
    public ModelAndView home(@RequestParam(defaultValue = "2") String quota, ModelMap model) {
        List<Villager> people = new ArrayList<>();
        int jml = Integer.parseInt(quota);

        for (int i = 0; i < jml; i++) {
            people.add(new Villager());
        }

        return new ModelAndView("home", "village", people);
    }

    @PostMapping("/execute")
    public ResponseEntity<String> witchExecuting(@RequestBody List<Villager> form){
        Witch theWitch = new Witch();
        theWitch.setList(form);

        if (theWitch.validatePeople()) {
            return new ResponseEntity<>(String.valueOf(theWitch.getKillingNumber()), HttpStatus.OK);
        }
        return new ResponseEntity<>(String.valueOf(-1), HttpStatus.OK);
    }
}
