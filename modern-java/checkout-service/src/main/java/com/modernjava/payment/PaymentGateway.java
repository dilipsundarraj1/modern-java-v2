package com.modernjava.payment;

import com.modernjava.domain.*;

public sealed abstract class PaymentGateway permits CreditCardPayment, DebitCardPayment, RewardsCardPayment {
    public abstract PaymentResponse makePayment(Card card, double amount);

}
