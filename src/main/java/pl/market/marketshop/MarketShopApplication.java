package pl.market.marketshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MarketShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketShopApplication.class, args);
	}

//	@EventListener (ApplicationContextEvent.class)
//	public void Test() {
//
//		System.out.println("Test OK");
//
//
//	}



}
