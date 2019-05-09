package com.kata.model;

import java.time.LocalDateTime;

import com.kata.enumType.OperationType;
import com.kata.util.DecimaUtil;
import com.kata.util.FormatDateTime;

/**
 * @author SAMIA FEKIR
 * 
 *         Bank Operation Class
 *
 */
public class Operation {

	/**
	 * amount attribute to deposit in account
	 */
	private double amount;

	/**
	 * balance of an account
	 */
	private double balance;

	/**
	 * Operation Date
	 */
	private LocalDateTime dateOp;

	/**
	 * Operation Type is a Deposit or withdrawal
	 */
	private OperationType operationType;

	/**
	 * Default constructor
	 * 
	 */
	public Operation() {
		super();
	}

	/**
	 * Constructor with 4 parameters
	 * 
	 * @param operationType
	 * @param dateOp
	 * @param amount
	 * @param balance
	 */
	public Operation(OperationType operationType, LocalDateTime dateOp,
			double amount, double balance) {
		super();
		this.operationType = operationType;
		this.dateOp = dateOp;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		if ("DEPOSIT".equals(this.operationType.name())) {
			return this.operationType.name() + "        |"
					+ FormatDateTime.convertFormatDateTime(this.dateOp)
					+ "         |" + DecimaUtil.formatDecimal(amount)
					+ "             |" + DecimaUtil.formatDecimal(balance)
					+ "\n";
		} else {
			return this.operationType.name() + "     |"
					+ FormatDateTime.convertFormatDateTime(this.dateOp)
					+ "         |" + DecimaUtil.formatDecimal(amount)
					+ "             |" + DecimaUtil.formatDecimal(balance)
					+ "\n";

		}
	}

	public LocalDateTime getDateOp() {
		return dateOp;
	}

}
