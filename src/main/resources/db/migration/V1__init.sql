-- Flyway V1__init.sql
CREATE TABLE IF NOT EXISTS orders (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  customer_name VARCHAR(100) NOT NULL,
  items JSON NOT NULL,
  total_amount DECIMAL(10,2) NOT NULL,
  order_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Indexes for optimization
CREATE INDEX idx_orders_order_time ON orders (order_time);

CREATE INDEX idx_orders_customer_name ON orders (customer_name);
