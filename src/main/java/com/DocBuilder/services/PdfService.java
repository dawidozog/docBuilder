package com.DocBuilder.services;

import com.DocBuilder.db.RentAgreementRequest;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {
    public byte[] generatePdf() {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Add content to PDF
            document.add(new Paragraph("Hello from Spring Boot! This is your PDF file."));

            document.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }

    public byte[] generateRentAgreement(RentAgreementRequest request) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Polish Rent Agreement Content
            document.add(new Paragraph("UMOWA NAJMU"));
            document.add(new Paragraph("Zawarta pomiędzy:"));
            document.add(new Paragraph("Wynajmujący: " + request.getLandlordName()));
            document.add(new Paragraph("Najemca: " + request.getTenantName()));
            document.add(new Paragraph("Adres nieruchomości: " + request.getAddress()));
            document.add(new Paragraph("Kwota czynszu: " + request.getRentAmount() + " PLN"));
            document.add(new Paragraph("Okres najmu: " + request.getStartDate() + " do " + request.getEndDate()));

            document.add(new Paragraph("\n\nPodpis Wynajmującego: __________________"));
            document.add(new Paragraph("\nPodpis Najemcy: __________________"));

            document.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Błąd generowania PDF", e);
        }
    }
}