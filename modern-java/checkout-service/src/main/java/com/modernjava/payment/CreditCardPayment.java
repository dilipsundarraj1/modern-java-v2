package com.modernjava.payment;


import com.modernjava.domain.Card;
import com.modernjava.domain.PaymentResponse;

final public class CreditCardPayment extends PaymentGateway
{
    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Acquire Credit Payment for the amount = " + amount);
        return PaymentResponse.SUCCESS;
    }


}

