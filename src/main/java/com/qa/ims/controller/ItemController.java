package com.qa.ims.controller;

import java.util.List;
import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;
/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	private CrudServices<Item> ItemService;
	public ItemController(CrudServices<Item> itemsService) {
		this.ItemService = itemsService;
	}
	public String getInput() {
		return Utils.getInput();	
	}
	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = ItemService.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}
	/**
	 * Creates a item by taking in user input
	 */
	public Item create() {
		LOGGER.info("Enter the item you require");
		String items_name = getInput();
		LOGGER.info("Please enter the item value");
		Double cost = Double.valueOf(getInput());
		Item items = ItemService.create(new Item(items_name, cost));
		LOGGER.info("Item created");
		return items;
	}
	public Item update() {
		LOGGER.info("Please enter the ID of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter the item name");
		String items_name = getInput();
		LOGGER.info("Please enter the new item value");
		Double items_value = Double.valueOf(getInput());
		Item items = ItemService.update(new Item(id, items_name, items_value));
		LOGGER.info("Item List Updated");
		return items;
	}
	public void delete() {
		LOGGER.info("Please enter the ID of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		ItemService.delete(id);
		LOGGER.info("Item Deleted");
	}
}
