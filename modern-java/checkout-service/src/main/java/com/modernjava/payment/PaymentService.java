package com.modernjava.payment;

import com.modernjava.domain.*;
import com.modernjava.payment.*;

public class PaymentService {

    public PaymentResponse makePaymentv2(OrderDetails orderDetails) {

        //implement a payment gateway that can handle the different kinds of payment.
        var paymentGateway = PaymentFactory.paymentGateway(orderDetails.card().cardType());
        return paymentGateway.makePayment(orderDetails.card(), orderDetails.finalAmount());
        //return PaymentResponse.SUCCESS;
    }
}
