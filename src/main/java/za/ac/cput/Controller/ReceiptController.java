package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;
import za.ac.cput.Service.ReceiptService;

import java.util.Set;


@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/create")
    public Receipt create(Receipt receipt){
       Receipt newReceipt = ReceiptFactory.createReceiptItem(receipt.getReceiptID());

        return receiptService.create(newReceipt);

    }
    @PostMapping("/update")
    public Receipt update(@RequestBody Receipt receipt){
        return receiptService.update(receipt);
    }

    @GetMapping("/read/{receiptId}")
    public Receipt read(@PathVariable String receiptID){
        return receiptService.read(receiptID);
    }

    @PostMapping("/delete/{receiptId}")
    public Boolean Delete(@PathVariable String receiptID){
        return receiptService.delete(receiptID);
    }
    @GetMapping("/getAll")
    public Set<Receipt> getAll(){
        return receiptService.getAll();
    }
}
