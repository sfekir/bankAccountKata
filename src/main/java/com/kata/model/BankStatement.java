package com.kata.model;

/**
 * @author SAMIA FEKIR
 * 
 *         Bank Statement Class
 *
 */
public class BankStatement {

	/**
	 * Header To print in console
	 */
	private static final String ACCOUNT_HEADER = "Operation      | Date                       | Amount             | Balance           "
			+ "\n";

	/**
	 * Account attribute
	 */
	private Account account;

	/**
	 * Constructor with 1 parameter
	 * 
	 * @param account
	 */
	public BankStatement(Account account) {
		super();
		this.account = account;
	}

	/**
	 * Generate Operation History of an account
	 */
	public String showHistoryStaement() {
		StringBuilder builder = new StringBuilder(ACCOUNT_HEADER);
		account.getOperationList().forEach(op -> builder.append(op.toString()));
		return builder.toString();
	}
}
