package com.ecommerce;

import com.ecommerce.model.Inventory;
import com.ecommerce.repository.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepo){

		return args -> {
			Inventory inventory = new Inventory();
			inventory.setQuantity(200);
			inventory.setSkuCode("iphone_15");

			Inventory inventory1 = new Inventory();
			inventory1.setQuantity(300);
			inventory1.setSkuCode("S22");


			inventoryRepo.save(inventory);
			inventoryRepo.save(inventory1);
		};

	}
}
