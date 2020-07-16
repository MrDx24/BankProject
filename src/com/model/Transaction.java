package com.model;

import java.sql.Date;

public class Transaction {

		private int transaction_id;
		private int payee_acc_no;
		private double amount;
		private Date transaction_date;
		private String transaction_time;
		private String operation;
		
		public Transaction(int transaction_id, int payee_acc_no, double amount, Date date,
				String transaction_time, String operation) {
			super();
			this.transaction_id = transaction_id;
			this.payee_acc_no = payee_acc_no;
			this.amount = amount;
			this.transaction_date = date;
			this.transaction_time = transaction_time;
			this.operation = operation;
		}

		public int getTransaction_id() {
			return transaction_id;
		}

		public void setTransaction_id(int transaction_id) {
			this.transaction_id = transaction_id;
		}

		public int getPayee_acc_no() {
			return payee_acc_no;
		}

		public void setPayee_acc_no(int payee_acc_no) {
			this.payee_acc_no = payee_acc_no;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public Date getTransaction_date() {
			return transaction_date;
		}

		public void setTransaction_date(Date transaction_date) {
			this.transaction_date = transaction_date;
		}

		public String getTransaction_time() {
			return transaction_time;
		}

		public void setTransaction_time(String transaction_time) {
			this.transaction_time = transaction_time;
		}

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}
		
		
		
		
}
