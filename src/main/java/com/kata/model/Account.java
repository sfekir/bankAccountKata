package com.kata.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kata.enumType.OperationType;
import com.kata.exception.InvalidAccountOperationException;

/**
 * @author SAMIA FEKIR
 *
 *         Bank Account Class
 */
public class Account {

	/**
	 * balance of an account
	 */
	private double balance;

	/**
	 * owner of the account
	 */
	private String owner;

	/**
	 * List of operations
	 */
	private List<Operation> operationList;

	/**
	 * Default constructor
	 */
	public Account() {
		this.balance = 0;
		this.operationList = new ArrayList<Operation>();
	}

	/**
	 * Constructor with 2 parameters
	 * 
	 * @param owner
	 * @param operationList
	 */
	public Account(String owner, double balance) {
		super();
		this.owner = owner;
		this.balance = balance;
		this.operationList = new ArrayList<Operation>();
	}

	/**
	 * deposit Method
	 * 
	 * Add amount to Account ss
	 * 
	 * @param amount
	 *            to deposit
	 * 
	 */
	public synchronized void deposit(double amount, LocalDateTime date) {

		this.balance += amount;
		addOperationToAccount(new Operation(OperationType.DEPOSIT, date,
				amount, this.balance));
	}

	/**
	 * Get the current balance of this account
	 * 
	 * @return the current balance
	 */
	public Double getBalance() {
		return new Double(this.balance);
	}

	/**
	 * Method withdrawal
	 * 
	 * Remove money from Account if enough money is available
	 * 
	 * @param amount
	 *            the amount of the withdrawal
	 * 
	 * @throws BankAccountException
	 */
	public synchronized void withdrawal(double amount, LocalDateTime date)
			throws InvalidAccountOperationException {
		if (amount > balance) {
			throw new InvalidAccountOperationException(
					"Transaction is not authorized : your withdrawal amount is not valid or withdrawal amount exceeds your balance");
		}
		this.balance -= amount;
		addOperationToAccount(new Operation(OperationType.WITHDRAWAL, date,
				amount, this.balance));
	}

	/**
	 * Add an operation to operation List
	 * 
	 * @param operation
	 */
	public void addOperationToAccount(Operation operation) {
		if (operationList == null)
			operationList = new ArrayList<Operation>();

		operationList.add(operation);
		sortLiOperations();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj instanceof Account) {
			return false;
		} else if (obj.equals(this)) {
			return true;
		}
		return false;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void sortLiOperations() {
		Collections.sort(getOperationList(), (o1, o2) -> o2.getDateOp()
				.compareTo(o1.getDateOp()));
	}

}
