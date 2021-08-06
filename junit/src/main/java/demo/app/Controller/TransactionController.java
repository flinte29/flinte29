package demo.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import demo.app.entity.Transaction;
import demo.app.service.TransactionService;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/test")
    private String testEndPoint(){
        return "I'm ok";
    }

    @PostMapping("/post")
    public  void addTransaction(@RequestParam Transaction transaction){
        transactionService.addTransaction(transaction);
    }

}
