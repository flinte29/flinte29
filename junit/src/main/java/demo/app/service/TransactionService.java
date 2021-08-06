package demo.app.service;

import demo.app.entity.Transaction;
import demo.app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public void addTransaction(Transaction transaction){
        if(transaction==null){
            throw new IllegalArgumentException("Transaction cannot be null!");
        }
        if(transaction.getAmount()<0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        transactionRepository.addTransaction(transaction);
    }

    public Transaction getTransactionById(long id){
        return transactionRepository.getTransactionById(id);
    }

    public List<Transaction> findTheTransactionsWithABiggerAmountThan(double amount){
        List<Transaction> transactionList = transactionRepository.getTransactionList();
        return transactionList.stream()
                .filter(transaction -> transaction.getAmount() > amount)
                .collect(Collectors.toList());
    }

    public List<Transaction> findTheTransactionsOfTheCustomer(String name){
        List<Transaction> transactionList = transactionRepository.getTransactionList();
        return transactionList.stream()
                .filter(transaction -> transaction.getName().equals(name))
                .collect(Collectors.toList());
    }

//    public void setTransactionRepository(TransactionRepository transactionRepository){
//        this.transactionRepository = transactionRepository;
//    }
}
