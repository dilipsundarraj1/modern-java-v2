package com.modernjava.service;

import com.modernjava.domain.Card;
import com.modernjava.domain.CardType;
import com.modernjava.domain.CheckOutStatus;
import com.modernjava.domain.OrderDetails;
import com.modernjava.payment.PaymentService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutServiceTest {


    PaymentService paymentService = new PaymentService();
    CheckoutService checkoutService = new CheckoutService(paymentService);


    @EnumSource(CardType.class)
    @ParameterizedTest(name = "Checkout For Card Type : {0}")
    void checkout(CardType cardType) {

        var orderDetails = orderDetails(cardType);
        var response = checkoutService.checkoutOrder(orderDetails);
        assertEquals(CheckOutStatus.SUCCESS, response);

    }

    static OrderDetails orderDetails(CardType cardType) {

        var card = new Card("ABC", "7676709809809809",
                "4567", "09/99", cardType);
        return new OrderDetails("1234", card, 99.0);

    }
}
