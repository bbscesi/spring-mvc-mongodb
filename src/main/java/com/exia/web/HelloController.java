package com.exia.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");

        model.addAttribute("customers", CustomerDAO.getAllCustomers());
        return "hello";

    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {

        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", name);

        return model;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Customers cost, ModelMap model) {

        CustomerDAO.add(cost);

        model.addAttribute("message", "Spring 3 MVC Hello World");
        model.addAttribute("customers", CustomerDAO.getAllCustomers());

        return "hello";

    }

    @RequestMapping(value = "/delete/{id:.+}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id, ModelMap model) {

        CustomerDAO.deleteCustomer(id);

        model.addAttribute("message", "Spring 3 MVC Hello World");
        model.addAttribute("customers", CustomerDAO.getAllCustomers());

        return "hello";
    }

}
