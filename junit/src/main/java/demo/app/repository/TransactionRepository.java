package demo.app.repository;

import org.springframework.stereotype.Repository;
import demo.app.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    List<Transaction> transactionList=new ArrayList<>();

    public void addTransaction(Transaction transaction){
        transactionList.add(transaction);
    }

    public Transaction getTransactionById(long id){
        for(Transaction transaction: transactionList){
            if(transaction.getId()==id){
                return transaction;
            }

        }
        return null;
    }

    public List<Transaction> getTransactionList(){
        return transactionList;
    }
}
