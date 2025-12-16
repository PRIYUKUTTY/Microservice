package com.jash.controller;


import com.jash.domain.PaymentMethod;
import com.jash.modal.PaymentOrder;
import com.jash.payload.PaymentLinkResponse;
import com.jash.payload.dlo.BookingDTO;
import com.jash.payload.dlo.UserDTO;
import com.jash.service.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(
            @RequestBody BookingDTO booking,
            @RequestParam PaymentMethod paymentMethod
            ) throws StripeException, RazorpayException {

        UserDTO user=new UserDTO();
        user.setFullName("Priya");
        user.setEmail("priya@gmail.com");
        user.setId(1L);

        PaymentLinkResponse res=paymentService.createOrder(user,booking,paymentMethod);
        return ResponseEntity.ok(res);

    }

    @GetMapping("/{paymentOrderId}")
    public ResponseEntity<PaymentOrder> getPaymentOrderById(
           @PathVariable Long paymentOrderId
    ) throws Exception {

        PaymentOrder res=paymentService.getPaymentOrderById(paymentOrderId);
        return ResponseEntity.ok(res);

    }

    @PatchMapping("/proceed")
    public ResponseEntity<Boolean> proceedPayment(
            @RequestParam String paymentId,
            @RequestParam String paymentLinkId
    ) throws Exception {

        PaymentOrder paymentOrder=paymentService.getPaymentOrderByPaymentId(paymentLinkId);

       Boolean res=paymentService.proceedPayment(paymentOrder,paymentId,paymentLinkId);
        return ResponseEntity.ok(res);

    }
}
