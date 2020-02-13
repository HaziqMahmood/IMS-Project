package com.qa.ims.persistence.dao;


	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import org.apache.log4j.Logger;

	import com.qa.ims.persistence.domain.Item;
	public class ItemDaoMySql implements Dao<Item> {


		public static final Logger LOGGER = Logger.getLogger(ItemDaoMySql.class);

		private String jdbcConnectionUrl;
		private String username;
		private String password;

		public ItemDaoMySql(String username, String password) {
			this.jdbcConnectionUrl = "jdbc:mysql://35.189.117.62:3306/ims";
			this.username = username;
			this.password = password;
		}

		public ItemDaoMySql(String jdbcConnectionUrl, String username, String password) {
			this.jdbcConnectionUrl = jdbcConnectionUrl;
			this.username = username;
			this.password = password;
		}

		public Item itemFromResultSet(ResultSet resultSet) throws SQLException {
			Long id = resultSet.getLong("item_id");
			String Name = resultSet.getString("item_name");
			Double Cost = resultSet.getDouble("cost")
			return new Item(id, Name, Cost);
		}
		/**
		 * Reads all items from the database
		 * 
		 * @return A list of items
		 */
		@Override
		public List<Item> readAll() {
			try (Connection connection = DriverManager
					.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from item");) {
				ArrayList<Item> items = new ArrayList<>();
				while (resultSet.next()) {
					items.add(itemFromResultSet(resultSet));
				}
				return items;
			} catch (SQLException e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return new ArrayList<>();
		}

		public Item readLatest() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM Item ORDER BY item_id DESC LIMIT 1");) {
				resultSet.next();
				return itemFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		/**
		 * Creates an item in the database
		 * 
		 * @param item - takes in an item object. id will be ignored
		 */
		@Override
		public Item create(Item item) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into item(item_name) values('" + item.getName()  + "')");
				return readLatest();
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		
		public Item readItem(Long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT FROM item where item_id = "+id);) {
				resultSet.next();
				return itemFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}

		
		/**
		 * Updates an item in the database
		 * 
		 * @param item - takes in an item object, the id field will be used to
		 *                 update that item in the database
		 * @return 
		 */
		@Override
		public Item update(Item item) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update item set item_name =" + item.getName() + " where item_id =" + item.getId());
				
				
				return readItem(item.getId());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
	
		/**
		 * Deletes an item in the database
		 * 
		 * @param id - id of the item
		 */
		@Override
		public void delete(long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from Item where item_id = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

	}



