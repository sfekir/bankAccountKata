package com.kata.bankAccount;

import java.time.LocalDateTime;
import java.time.Month;

import com.kata.exception.InvalidAccountOperationException;
import com.kata.model.Account;
import com.kata.model.BankStatement;

/**
 * App Class
 *
 */
public class App {
	public static void main(String[] args) {

		Account account = new Account("Fadoua RAFASS", 9000);

		BankStatement historyOp = new BankStatement(account);

		/*
		 * US 1: In order to save money As a bank client I want to make a
		 * deposit in my account
		 */
		account.deposit(1800,
				LocalDateTime.of(15, Month.NOVEMBER, 18, 15, 45, 21));
		account.deposit(3500,
				LocalDateTime.of(25, Month.JANUARY, 19, 9, 55, 21));

		/*
		 * US 2: In order to retrieve some or all of my savings As a bank client
		 * I want to make a withdrawal from my account
		 */

		try {
			account.withdrawal(6000, LocalDateTime.now());
		} catch (InvalidAccountOperationException e) {
			System.err.println(e.getMessage());
		}

		/*
		 * US 3: In order to check my operations As a bank client I want to see
		 * the history (operation, date, amount, balance) of my operations
		 */

		System.out.println("Client Information" + "\t" + account.getOwner()
				+ "\t" + "The Number Of Account Operations is : "
				+ account.getOperationList().size() + "\n");
		System.out.println(historyOp.showHistoryStaement());

	}
}
