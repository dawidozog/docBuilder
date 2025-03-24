package com.DocBuilder.controllers;

import com.DocBuilder.db.CarSaleAgreementRequest;
import com.DocBuilder.db.RentAgreementRequest;
import com.DocBuilder.services.PdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private static final Logger log = Logger.getLogger(PdfController.class.getName());

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/generate/rent")
    public ResponseEntity<byte[]> generatePdfRent(@RequestBody RentAgreementRequest request) {

        byte[] pdfBytes = null;
        try {
            pdfBytes = pdfService.generateRentAgreement(request);
        } catch (Exception e) {
            log.log(Level.SEVERE, "generatePdfRent: " + e.getMessage());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "umowa_najmu.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @PostMapping("/generate/car")
    public ResponseEntity<byte[]> generatePdfCar(@RequestBody CarSaleAgreementRequest request) {

        byte[] pdfBytes = null;
        try {
            pdfBytes = pdfService.generateCarSaleAgreement(request);
        } catch (Exception e) {
            log.log(Level.SEVERE, "generatePdfCar: " + e.getMessage());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "umowa_kupna_sprzedazy_auta.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
