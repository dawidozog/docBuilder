package com.DocBuilder.controllers;

import com.DocBuilder.db.CarSaleAgreementRequest;
import com.DocBuilder.db.RentAgreementRequest;
import com.DocBuilder.services.PdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/generate/rent")
    public ResponseEntity<byte[]> generatePdfRent(@RequestBody RentAgreementRequest request) {
        byte[] pdfBytes = pdfService.generateRentAgreement(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "umowa_najmu.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @PostMapping("/generate/car")
    public ResponseEntity<byte[]> generatePdfCar(@RequestBody CarSaleAgreementRequest request) {
        byte[] pdfBytes = pdfService.generateCarSaleAgreement(request);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "umowa_kupna_sprzedazy_auta.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
