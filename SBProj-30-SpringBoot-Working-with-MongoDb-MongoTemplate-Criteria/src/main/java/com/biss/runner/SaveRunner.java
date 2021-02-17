package com.biss.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.biss.model.Ticket;
import com.biss.model.TicketInfo;
//@Component
public class SaveRunner implements CommandLineRunner {
	@Autowired
	MongoTemplate mt;
	@Override
	public void run(String... args) throws Exception {
		mt.save(new Ticket("TICA",656.02,
								new TicketInfo("CC","HYD","BHC"),
								List.of("BUS","FLIGHT")));
		mt.save(new Ticket("TIJK",896.02,
				new TicketInfo("DC","BHC","HYD"),
				List.of("BUS","TRAIN")));
		mt.save(new Ticket("TIYU",565.02,
				new TicketInfo("NB","HYD","CHN"),
				List.of("TRAIN","FLIGHT")));
		mt.save(new Ticket("TICA",786.02,
				new TicketInfo("CC","HYD","BHC"),
				List.of("BUS","TRAIN")));
		mt.save(new Ticket("TIJK",456.02,
				new TicketInfo("CC","BHC","CHN"),
				List.of("TRAIN","BUS")));
		mt.save(new Ticket("TIIU",956.02,
				new TicketInfo("DC","HYD","DEL"),
				List.of("BUS","FLIGHT")));
		System.out.println("Done Dana Done");
	}

}
