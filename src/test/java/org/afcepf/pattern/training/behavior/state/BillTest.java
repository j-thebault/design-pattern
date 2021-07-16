package org.afcepf.pattern.training.behavior.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BillTest {

    Mailer mailer;
    Bill bill;

    @BeforeEach
    void setup() {
        mailer = Mockito.mock(Mailer.class);
        bill = new Bill(mailer);
    }

    @Test
    void newBillShouldHaveCreatedStatus() {
        assertEquals("CREATED", bill.getState());
    }

    @Test
    void sendCreatedBill() {
        bill.send();
        assertEquals("SENT", bill.getState());
        Mockito.verify(mailer).sendBill();
        Mockito.verify(mailer, Mockito.times(0)).sendAgainBill();
    }

    @Test
    void sendAlreadySentBill() {
        bill.send();
        bill.send();
        assertEquals("SENT", bill.getState());
        Mockito.verify(mailer).sendBill();
        Mockito.verify(mailer).sendAgainBill();
    }

    @Test
    void sendDuplicata() {
        bill.send();
        bill.pay();
        bill.send();
        assertEquals("PAID", bill.getState());
        Mockito.verify(mailer).sendBill();
        Mockito.verify(mailer).sendAcknowledgement();
        Mockito.verify(mailer).sendBillDuplicata();
    }

    @Test
    void payBill() {
        bill.send();
        bill.pay();
        assertEquals("PAID", bill.getState());
        Mockito.verify(mailer).sendBill();
        Mockito.verify(mailer).sendAcknowledgement();
    }

    @Test
    void shouldNotPayBillAgain() {
        bill.send();
        bill.pay();
        assertThrows(IllegalArgumentException.class, () -> bill.pay());
        assertEquals("PAID", bill.getState());
        Mockito.verify(mailer).sendBill();
        Mockito.verify(mailer).sendAcknowledgement();
    }

    @Test
    void shouldNotPayCancelledBill() {
        bill.send();
        bill.cancel();
        assertThrows(IllegalArgumentException.class, () -> bill.pay());
        assertEquals("CANCELLED", bill.getState());
        Mockito.verify(mailer).sendBill();
        Mockito.verify(mailer).sendCancelled();
        Mockito.verify(mailer, Mockito.times(0)).sendAcknowledgement();
    }
}
