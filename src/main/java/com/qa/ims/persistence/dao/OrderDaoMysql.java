package com.qa.ims.persistence.dao;


	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import org.apache.log4j.Logger;
	import com.qa.ims.persistence.domain.Customer;
	import com.qa.ims.persistence.domain.Item;
	import com.qa.ims.persistence.domain.Order;
	public class OrderDaoMysql implements Dao<Order> {
		public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);
		private String jdbcConnectionUrl;
		private String username;
		private String password;
		public OrderDaoMysql(String username, String password) {
			this.jdbcConnectionUrl = "jdbc:mysql://35.189.117.62:3306/ims";
			this.username = username;
			this.password = password;
		}
		public OrderDaoMysql(String jdbcConnectionUrl, String username, String password) {
			this.jdbcConnectionUrl = jdbcConnectionUrl;
			this.username = username;
			this.password = password;
		}
		Order orderFromResultSet(ResultSet resultSet) throws SQLException {
			Long order_id = resultSet.getLong("order_id");
			Long customer_id = resultSet.getLong("customer_id");
			Long total_cost = resultSet.getLong("order_price");
			Long number_of_items = resultSet.getLong("Quantity");
			return new Order(order_id, customer_id, total_cost, number_of_items);
		}
		/**
		 * Reads all customers from the database
		 *
		 * @return A list of customers
		 */
		@Override
		public List<Order> readAll() {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from orders");) {
				ArrayList<Order> orders = new ArrayList<>();
				while (resultSet.next()) {
					orders.add(orderFromResultSet(resultSet));
				}
				return orders;
			} catch (SQLException e) {
			}
			return new ArrayList<>();
		}
		public Order create(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("insert into orders (customer_id, order_price, Quantity) values('" + order.getCustomer_Id()
						+ "','" + order.getTotal_Cost() + "', '" + order.getNumber_Of_Items() + "')");
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		public Order update(Order order) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update orders set customer_id ='" + order.getCustomer_Id() + "', order_price ='"
						+ order.getTotal_Cost() + "', Quantity ='"+ order.getNumber_Of_Items() + "' where order_id =" + order.getOrder_Id());
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
			return null;
		}
		/**
		 * Deletes a customer in the database
		 *
		 * @param id - id of the customer
		 */
		@Override
		public void delete(long id) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("delete from orders where order_id = " + id);
			} catch (Exception e) {
				LOGGER.debug(e.getStackTrace());
				LOGGER.error(e.getMessage());
			}
		}

}
