package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.Frame;
import com.simbirsoft.con_calc.services.CustomerService;
import com.simbirsoft.con_calc.services.FoundationService;
import com.simbirsoft.con_calc.services.MaterialService;
import com.simbirsoft.con_calc.services.WallCladdingService;
import com.simbirsoft.con_calc.view.FoundationRepo;
import com.simbirsoft.con_calc.view.FrameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/newFoundation")
public class AddFoundationController {

    @Autowired
    MaterialService materialService;

    @Autowired
    CustomerService customerService;

    @Autowired
    WallCladdingService wallCladdingService;

    @Autowired
    FrameRepo frameRepo;

    @Autowired
    FoundationRepo foundationRepo;

    @Autowired
    FoundationService foundationService;

    @GetMapping("/add")
    public String addFoundationPage(
            @RequestParam(required = true, defaultValue = "") Long customerId,
            @RequestParam(required = true, defaultValue = "") Long orderId,
            Model model
    ) {

        model.addAttribute("piles", materialService.getPilesMaterials());
        model.addAttribute("concrete", materialService.getConcreteMaterials());
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);
        return "newFoundation";
    }

    @PostMapping("/add")
    public String save(
            @RequestParam(required = true, defaultValue = "") Long customerId,
            @RequestParam(required = true, defaultValue = "" ) String pilesName,
            @RequestParam(required = true, defaultValue = "" ) String concreteName,
            @RequestParam(required = true, defaultValue = "" ) Long orderId,
            Foundation foundation,
            Model model
    ) {

        Frame order;
        if(orderId == null) {
            order = new Frame();
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yy");
            order.setLocalDateTime(formatForDateNow.format(dateNow));
            Customer customer = customerService.findCustomerById(customerId);
            order.setCustomer(customer);
            frameRepo.save(order);
        }
        else order = frameRepo.getById(orderId);

        foundation.setFrame(order);
        foundationRepo.save(foundation);

        wallCladdingService.addFoundationMaterials(pilesName, concreteName, foundation.getId());

        return "redirect:/calculate/foundation/" + foundation.getId();
    }

    @GetMapping("/edit")
    public String editFoundationPage(
            @RequestParam(required = true, defaultValue = "") Long foundationId,
            Model model
    ) {

        model.addAttribute("piles", materialService.getPilesMaterials());
        model.addAttribute("concrete", materialService.getConcreteMaterials());
        model.addAttribute("foundationId", foundationId);

        Foundation foundation = foundationRepo.getById(foundationId);
        model.addAttribute("foundation", foundation);
        model.addAttribute("curConcrete", foundation.getFoundationResults().getNameOfConcrete());
        model.addAttribute("curPiles", foundation.getFoundationResults().getNameOfPiles());

        return "editFoundation";
    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam(required = true, defaultValue = "" ) Long foundationId,
            @RequestParam(required = true, defaultValue = "" ) String pilesName,
            @RequestParam(required = true, defaultValue = "" ) String concreteName,
            @ModelAttribute("foundation") Foundation foundation
    ) {
        foundationService.updateFoundation(foundation, foundationId);

        wallCladdingService.addFoundationMaterials(pilesName, concreteName, foundationId);

        return "redirect:/calculate/foundation/" + foundationId;
    }
}
