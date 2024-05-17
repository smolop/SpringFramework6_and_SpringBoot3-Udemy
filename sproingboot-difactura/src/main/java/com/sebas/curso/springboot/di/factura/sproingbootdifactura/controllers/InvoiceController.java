package com.sebas.curso.springboot.di.factura.sproingbootdifactura.controllers;

import com.sebas.curso.springboot.di.factura.sproingbootdifactura.models.Client;
import com.sebas.curso.springboot.di.factura.sproingbootdifactura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping(path = "getOne")
    public Invoice get(){
        Invoice methodInvoice = new Invoice();
        Client methodClient = new Client();
        methodClient.setName(invoice.getClient().getName());
        methodClient.setLastname(invoice.getClient().getLastname());
        methodInvoice.setClient(methodClient);
        methodInvoice.setClient(invoice.getClient());
        methodInvoice.setDescription(invoice.getDescription());
        methodInvoice.setItems(invoice.getItems());
        return methodInvoice;
    }



}
