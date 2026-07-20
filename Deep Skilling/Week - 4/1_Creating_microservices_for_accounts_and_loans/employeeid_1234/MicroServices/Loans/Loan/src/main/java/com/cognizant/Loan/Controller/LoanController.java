package com.cognizant.Loan.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Loans")
public class LoanController {

    @GetMapping("/{number}")
    public LoanDetail getDetails(@PathVariable String number) {
        return new LoanDetail(number, "home", 100000, 10000, 10);
    }

    static class LoanDetail {
        private String number;
        private String type;
        private int amount;
        private int emi;
        private int tenure;


        public LoanDetail(String number, String type, int amount, int emi, int tenure) {
            this.number = number;
            this.type = type;
            this.amount = amount;
            this.emi = emi;
            this.tenure = tenure;
        }

        public String getNumber() { return number; }
        public String getType() { return type; }
        public int getAmount() { return amount; }
        public int getEmi() { return emi; }
        public int getTenure() { return tenure; }
    }
}
