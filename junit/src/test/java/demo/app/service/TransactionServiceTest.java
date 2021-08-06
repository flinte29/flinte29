package demo.app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import demo.app.entity.Transaction;
import demo.app.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class  TransactionServiceTest {

    private static final long ID = 100L;
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    Transaction transaction;

    @Before
    public void setUp() {

        transaction = new Transaction();

        transaction.setId(ID);
        transaction.setAmount(30.0);
        transaction.setName("John");
    }

    @Test
    public void testAddTransaction() {
        transactionService.addTransaction(transaction);
        Mockito.verify(transactionRepository, Mockito.times(1)).addTransaction(transaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTransactionWhenInputIsNullThrowAnException() {
        transactionService.addTransaction(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTransactionWhenInputIsInvalidThrowAnException() {
        Transaction transaction = new Transaction();
        transaction.setId(100);
        transaction.setAmount(-30.0);
        transaction.setName("John");

        transactionService.addTransaction(transaction);

    }

    @Test
    public void testGetTransaction() {
        //arrange
        Mockito.when(transactionRepository.getTransactionById(ID))
                .thenReturn(transaction);

        //act
        Transaction actualTransaction = transactionService.getTransactionById(ID);

        //assert
        assertEquals(transaction.getId(), actualTransaction.getId());
        assertEquals(transaction.getAmount(), actualTransaction.getAmount(), 10);
        assertEquals(transaction.getName(), actualTransaction.getName());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetTransactionException() {
        Mockito.when(transactionRepository.getTransactionById(ID))
                .thenThrow(IndexOutOfBoundsException.class);

        Transaction actualTransaction = transactionService.getTransactionById(ID);;

    }

    @Test
    public void testFindTheTransactionsWithABiggerAmountThan() {
        //arrange
        Transaction transaction = new Transaction();
        transaction.setId(100);
        transaction.setAmount(50);
        transaction.setName("John");

        Transaction transaction1 = new Transaction();
        transaction1.setId(101);
        transaction1.setAmount(130);
        transaction1.setName("Steve");

        Transaction transaction2 = new Transaction();
        transaction2.setId(102);
        transaction2.setAmount(400);
        transaction2.setName("John");

        Transaction transaction3 = new Transaction();
        transaction3.setId(103);
        transaction3.setAmount(25);
        transaction3.setName("Laura");

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);

        Mockito.when(transactionRepository.getTransactionList()).thenReturn(transactionList);

        //act
        List<Transaction> transactionListFiltered = transactionService.findTheTransactionsWithABiggerAmountThan(100);

        //assert
        assertEquals(2, transactionListFiltered.size());
    }

    @Test
    public void testFindTheTransactionOfTheCustomer() {
        //arrange
        Transaction transaction = new Transaction();
        transaction.setId(100);
        transaction.setAmount(50);
        transaction.setName("John");

        Transaction transaction1 = new Transaction();
        transaction1.setId(101);
        transaction1.setAmount(130);
        transaction1.setName("Steve");

        Transaction transaction2 = new Transaction();
        transaction2.setId(102);
        transaction2.setAmount(400);
        transaction2.setName("John");

        Transaction transaction3 = new Transaction();
        transaction3.setId(103);
        transaction3.setAmount(25);
        transaction3.setName("Laura");

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);

        Mockito.when(transactionRepository.getTransactionList()).thenReturn(transactionList);

        //act
        List<Transaction> transactionListFiltered = transactionService.findTheTransactionsOfTheCustomer("Laura");

        //assert
        assertEquals(1, transactionListFiltered.size());
    }
}