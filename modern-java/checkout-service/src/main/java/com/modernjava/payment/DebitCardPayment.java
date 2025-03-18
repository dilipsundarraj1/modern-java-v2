package com.modernjava.payment;

import com.modernjava.domain.Card;
import com.modernjava.domain.PaymentResponse;

final public class DebitCardPayment extends PaymentGateway {
    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Acquire Debit Payment for the amount = " + amount);
        return PaymentResponse.SUCCESS;
    }
}
