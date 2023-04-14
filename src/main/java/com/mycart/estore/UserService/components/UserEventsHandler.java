package com.mycart.estore.UserService.components;

import com.mycart.estore.core.model.PaymentDetails;
import com.mycart.estore.core.model.User;
import com.mycart.estore.core.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User fetchUserPaymentDetails(FetchUserPaymentDetailsQuery fetchUserPaymentDetails) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("janak kapadiya")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName("janak")
                .lastName("kapadiya")
                .userId(fetchUserPaymentDetails.getUserId())
                .paymentDetails(paymentDetails)
                .build();
    }
}
