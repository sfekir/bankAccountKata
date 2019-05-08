package com.kata.bankAccount;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kata.exception.InvalidAccountOperationException;
import com.kata.model.Account;

public class AccountTest {

	private Account account1;
	private Account account2;

	@Before
	public void setup() {
		account1 = new Account("JACK NORTHEN", 1000);
		account2 = new Account("JEAN PHILIP SERRUT", 25000);

	}

	@Test
	public void should_Find_500_whenDeposit500() {
		account1.deposit(500, LocalDateTime.now());
		Assert.assertTrue(account1.getBalance() == 1500);
	}

	@Test
	public void should_Find_200_whenWithdraw800()
			throws InvalidAccountOperationException {
		account1.withdrawal(800, LocalDateTime.now());
		Assert.assertTrue(account1.getBalance() == 200);
	}

	@Test
	public void should_ThrowException_WhenWithdraw1500() {
		try {
			account1.withdrawal(1500, LocalDateTime.now());
		} catch (InvalidAccountOperationException e) {
			Assert.assertTrue("Transaction is not authorized : your withdrawal amount is not valid or withdrawal amount exceeds your balance"
					.equals(e.getMessage()));
		}
	}

	@Test(expected = InvalidAccountOperationException.class)
	public void should_ThrowException_WhenWithdraw8700()
			throws InvalidAccountOperationException {
		account1.withdrawal(8700, LocalDateTime.now());
	}

	@Test
	public void should_Find3OperationsElement_whenDoing3AccountOperations()
			throws InvalidAccountOperationException {
		account2.deposit(7800,
				LocalDateTime.of(15, Month.NOVEMBER, 18, 15, 45, 21));
		account2.deposit(9000,
				LocalDateTime.of(5, Month.DECEMBER, 18, 8, 2, 15));
		account2.withdrawal(6000,
				LocalDateTime.of(3, Month.FEBRUARY, 20, 1, 8, 9));
		Assert.assertEquals(3, account2.getOperationList().size());

	}
}
