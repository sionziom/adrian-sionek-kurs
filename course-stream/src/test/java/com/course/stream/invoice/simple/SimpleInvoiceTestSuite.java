package com.course.stream.invoice.simple;

import org.junit.Assert;
import org.junit.Test;

public class SimpleInvoiceTestSuite {

    @Test
    public void testGetValueToPay(){
        //Given
        SimpleInvoice simpleInvoice = new SimpleInvoice();

        //When
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28), 2));
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        simpleInvoice.addItem(new SimpleItem(new SimpleProduct("Product 3",  6.49), 5.0));

        //Then
        Assert.assertEquals(108.975, simpleInvoice.getValueToPay(), 0.001);

    }
}
