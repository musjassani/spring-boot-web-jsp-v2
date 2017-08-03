package com.proto.controllers;

import com.proto.beans.Pays;
import com.proto.services.PaysService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PaysController {

	private final Logger logger = LoggerFactory.getLogger(PaysController.class);

	@Autowired
	PaysService paysService;

	@RequestMapping(value = "/pays",method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		List<Pays> pays = paysService.list();
		model.put("pays", pays);
		model.put("active", "pays");
		return "pays";
	}

	//https://stackoverflow.com/questions/34048617/spring-boot-how-to-use-hiddenhttpmethodfilter
	@RequestMapping(value = "/pays", method = RequestMethod.PUT)
	public ModelAndView add(ModelMap model, String code, String langue, String nom) {
		try {
			if (StringUtils.isNoneBlank(code, langue, nom)) {
                Pays pays = new Pays(code, nom, langue);
                paysService.save(pays);
                model.put("success", true);
            }
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			model.put("success", false);
			model.put("error", e.getMessage());
		}
		//http://www.baeldung.com/spring-redirect-and-forward
		return new ModelAndView("redirect:/pays", model);
	}

}