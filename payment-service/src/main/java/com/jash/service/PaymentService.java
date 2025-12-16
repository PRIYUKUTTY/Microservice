package com.jash.service;

import com.jash.domain.PaymentMethod;
import com.jash.modal.PaymentOrder;
import com.jash.payload.PaymentLinkResponse;
import com.jash.payload.dlo.BookingDTO;
import com.jash.payload.dlo.UserDTO;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

   PaymentLinkResponse createOrder(UserDTO user,
                                   BookingDTO booking,
                                   PaymentMethod paymentMethod) throws RazorpayException, StripeException;

   PaymentOrder getPaymentOrderById(Long id) throws Exception;

   PaymentOrder getPaymentOrderByPaymentId(String paymentId);

   PaymentLink createRazorPaymentLink(UserDTO user,
                                      Long amount,
                                      Long orderId) throws RazorpayException;

   String createStripePaymentLink(UserDTO user,
                                  Long amount,
                                  Long orderId) throws StripeException;
   Boolean proceedPayment(PaymentOrder paymentOrder,String paymentId,
                          String paymentLinkId) throws RazorpayException;

}
