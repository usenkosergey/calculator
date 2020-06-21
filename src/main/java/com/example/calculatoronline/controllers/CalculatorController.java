package com.example.calculatoronline.controllers;

import com.example.calculatoronline.api.requests.Data;
import com.example.calculatoronline.api.responses.Payment;
import com.example.calculatoronline.api.responses.Payments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class CalculatorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/calculator")
    public ResponseEntity<Payments> getPayments(@RequestBody(required = false) Data data) {

        logger.info(
                "creditAmount - " + data.getCreditAmount() +
                        " interestRate - " + data.getInterestRate() +
                        " quantityMonths - " + data.getQuantityMonths() +
                        " date - " + data.getDate());

        double balanceAmount = data.getCreditAmount();
        LocalDate datePayment = data.getDate();
        List<Payment> paymentList = new ArrayList<>();

        double monthlyRate = data.getInterestRate() / 100 / 12;
        double monthlyPayment = BigDecimal.valueOf(data.getCreditAmount() * (monthlyRate + monthlyRate / (Math.pow((1 + monthlyRate), data.getQuantityMonths()) - 1))).setScale(4, RoundingMode.HALF_UP).doubleValue();

        for (int i = 1; i <= data.getQuantityMonths(); i++) {
            Payment currentPayment = new Payment();
            double percentMonths = new BigDecimal(balanceAmount * monthlyRate).setScale(4, RoundingMode.HALF_UP).doubleValue();
            double debt = new BigDecimal(monthlyPayment - percentMonths).setScale(4, RoundingMode.HALF_UP).doubleValue();
            balanceAmount = new BigDecimal(balanceAmount - debt).setScale(4, RoundingMode.HALF_UP).doubleValue();
            balanceAmount = balanceAmount < 1 ? 0 : balanceAmount;

            currentPayment.setNumberPayment(i);
            currentPayment.setMonthlyPayment(convert(monthlyPayment));
            currentPayment.setPercentMonths(convert(percentMonths));
            currentPayment.setDebt(convert(debt));
            currentPayment.setBalanceAmount(convert(balanceAmount));
            currentPayment.setDatePayment(datePayment.plusMonths(i - 1));

            paymentList.add(currentPayment);
        }

        Payments listPayments = new Payments();
        listPayments.setPayment(paymentList);
        return new ResponseEntity<>(listPayments, HttpStatus.OK);
    }

    private String convert(double convertData) {
        return String.format(Locale.US, "%.2f", convertData);
    }

}
