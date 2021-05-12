package com.smartevo.SmartEvo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.smartevo.SmartEvo.Entity.Customer;
import com.smartevo.SmartEvo.Entity.Edit;
import com.smartevo.SmartEvo.Entity.GetJson;
import com.smartevo.SmartEvo.Entity.payload;
import com.smartevo.SmartEvo.Repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class smartController {
	
	@Autowired
	CustomerRepository repository;
	

	private static final Logger log =LoggerFactory.getLogger(smartController.class);
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/all")
	public GetJson all() {
		
		
		
		for (Customer customer : repository.findAll()) {
	        log.info(customer.toString());
	      }
		 log.info("--------------------------------");
		repository.findByLastName("Bauer").forEach(persona -> {
	        log.info(persona.toString());
	      });
		
		//servizi mock
		payload pay= new payload();
		pay.setBackhaulingFibraOttica(100);
		pay.setBackhaulingPonteRadio(75);
		pay.setBackhaulingRame(0);
		pay.setDaLavoareExtra(0);
		pay.setDaLavoarePev(0);
		pay.setInLavorazioneExtra(0);
		pay.setInLavorazionePev(0);
		pay.setLavoratiExtra(0);
		pay.setLavoratiPev(0);
		
		GetJson jj = new GetJson();
		
		jj.setResult("Success");
		jj.setPayload(pay);
		jj.setTotaleElementi(3);
		
		return jj;
	}
	
	@GetMapping("/edit")
	public Edit edit(@RequestParam(value = "idIntervento") String idIntervento) {
		
		int intervento=Integer.parseInt(idIntervento);
		log.info("Id intervento "+intervento);
		
		//servizi mock
	
		
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
		return new Edit (String.format("success"));
	}
}
