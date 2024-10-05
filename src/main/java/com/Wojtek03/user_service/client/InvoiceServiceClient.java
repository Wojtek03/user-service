package com.Wojtek03.user_service.client;

import com.Wojtek03.user_service.dto.InvoiceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "invoice-service", url = "http://invoice-service:8084")
public interface InvoiceServiceClient {

    @GetMapping("/{id}")
    InvoiceDto getInvoiceById(@PathVariable("id") Long id);

    @GetMapping
    List<InvoiceDto> getAllInvoices();
}
