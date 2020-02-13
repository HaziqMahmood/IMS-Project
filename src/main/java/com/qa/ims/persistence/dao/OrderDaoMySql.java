//package com.qa.ims.persistence.dao;
//
//
//	import java.sql.Connection;
//	import java.sql.DriverManager;
//	import java.sql.ResultSet;
//	import java.sql.SQLException;
//	import java.sql.Statement;
//	import java.util.ArrayList;
//	import java.util.List;
//
//	import org.apache.log4j.Logger;
//
//import com.qa.ims.persistence.domain.Item;
//import com.qa.ims.persistence.domain.Order;
//	public class OrderDaoMySql implements Dao<Order> {
//
//
//		public static final Logger LOGGER = Logger.getLogger(OrderDaoMySql.class);
//
//		private String jdbcConnectionUrl;
//		private String username;
//		private String password;
//
//		public OrderDaoMySql(String username, String password) {
//			this.jdbcConnectionUrl = "jdbc:mysql://35.189.117.62:3306/ims";
//			this.username = username;
//			this.password = password;
//		}
//
//		public OrderDaoMySql(String jdbcConnectionUrl, String username, String password) {
//			this.jdbcConnectionUrl = jdbcConnectionUrl;
//			this.username = username;
//			this.password = password;
//		}
//
//		public Order orderFromResultSet(ResultSet resultSet) throws SQLException {
//			Long id = resultSet.getLong("order_id");
//			double Price = resultSet.getDouble("order_price");
//			Long Quantity = resultSet.getLong("quantity");
//			Long Customer_id = resultSet.getLong("customer_id");
//			
//			
//			return new Order(id, Price, Quantity, Customer_id);
//		}
//		/**
//		 * Reads all orders from the database
//		 * 
//		 * @return A list of all orders
//		 */
//		@Override
//		public List<Order> readAll() {
//			try (Connection connection = DriverManager
//					.getConnection(jdbcConnectionUrl, username, password);
//					Statement statement = connection.createStatement();
//					ResultSet resultSet = statement.executeQuery("select * from orders");) {
//				ArrayList<Order> items = new ArrayList<>();
//				while (resultSet.next()) {
//					Order.add(orderFromResultSet(resultSet));
//				}
//				return items;
//			} catch (SQLException e) {
//				LOGGER.debug(e.getStackTrace());
//				LOGGER.error(e.getMessage());
//			}
//			return new ArrayList<>();
//		}
//
//		public Item readLatest() {
//			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//					Statement statement = connection.createStatement();
//					ResultSet resultSet = statement.executeQuery("SELECT * FROM Item ORDER BY Item_ID DESC LIMIT 1");) {
//				resultSet.next();
//				return orderFromResultSet(resultSet);
//			} catch (Exception e) {
//				LOGGER.debug(e.getStackTrace());
//				LOGGER.error(e.getMessage());
//			}
//			return null;
//		}
//
//		/**
//		 * Creates an item in the database
//		 * 
//		 * @param item - takes in an item object. id will be ignored
//		 */
//		@Override
//		public Item create(Item item) {
//			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//					Statement statement = connection.createStatement();) {
//				statement.executeUpdate("insert into Item(Item_name) values('" + item.getName()  + "')");
//				return readLatest();
//			} catch (Exception e) {
//				LOGGER.debug(e.getStackTrace());
//				LOGGER.error(e.getMessage());
//			}
//			return null;
//		}
//		
//		public Item readItem(Long id) {
//			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//					Statement statement = connection.createStatement();
//					ResultSet resultSet = statement.executeQuery("SELECT FROM Item where Item_ID = "+id);) {
//				resultSet.next();
//				return orderFromResultSet(resultSet);
//			} catch (Exception e) {
//				LOGGER.debug(e.getStackTrace());
//				LOGGER.error(e.getMessage());
//			}
//			return null;
//		}
//
//		
//		/**
//		 * Updates an item in the database
//		 * 
//		 * @param item - takes in an item object, the id field will be used to
//		 *                 update that item in the database
//		 * @return 
//		 */
//		@Override
//		public Order update(Order order) {
//			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//					Statement statement = connection.createStatement();) {
//				statement.executeUpdate("update Item set Item_name =" + item.getName() + " where Item_ID =" + item.getId());
//				
//				
//				return readItem(item.getId());
//			} catch (Exception e) {
//				LOGGER.debug(e.getStackTrace());
//				LOGGER.error(e.getMessage());
//			}
//			return null;
//		}
//	
//		/**
//		 * Deletes an item in the database
//		 * 
//		 * @param id - id of the item
//		 */
//		@Override
//		public void delete(long id) {
//			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//					Statement statement = connection.createStatement();) {
//				statement.executeUpdate("delete from Item where Item_ID = " + id);
//			} catch (Exception e) {
//				LOGGER.debug(e.getStackTrace());
//				LOGGER.error(e.getMessage());
//			}
//		}
//
//	}
//
//
