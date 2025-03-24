package com.DocBuilder.services;

import com.DocBuilder.db.RentAgreementRequest;
import com.DocBuilder.db.CarSaleAgreementRequest;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public byte[] generateRentAgreement(RentAgreementRequest request) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = getDocument(outputStream);

            document.add(new Paragraph("UMOWA NAJMU").setBold().setFontSize(14));
            document.add(new Paragraph("Zawarta w dniu " + request.getAgreementDate() + " pomiędzy:"));
            document.add(new Paragraph("Wynajmujący: " + request.getLandlordName() + ", " + request.getLandlordAddress()));
            document.add(new Paragraph("Najemca: " + request.getTenantName() + ", " + request.getTenantAddress()));
            document.add(new Paragraph("§ 1 Przedmiot umowy"));
            document.add(new Paragraph("Wynajmujący oddaje Najemcy w najem lokal mieszkalny położony pod adresem: " + request.getAddress() +
                    ", o powierzchni " + request.getArea() + " m²."));

            document.add(new Paragraph("§ 2 Okres najmu"));
            document.add(new Paragraph("Umowa zawarta na okres od " + request.getStartDate() + " do " + request.getEndDate() + "."));

            document.add(new Paragraph("§ 3 Czynsz i opłaty"));
            document.add(new Paragraph("Najemca zobowiązuje się do płacenia czynszu w wysokości " + request.getRentAmount() +
                    " PLN miesięcznie do dnia " + request.getPaymentDueDate() + " każdego miesiąca."));
            document.add(new Paragraph("Dodatkowo Najemca ponosi koszty za media, tj. prąd, wodę, gaz oraz czynsz administracyjny."));

            document.add(new Paragraph("§ 4 Obowiązki stron"));
            document.add(new Paragraph("Najemca zobowiązuje się do utrzymywania lokalu w należytym stanie i nie może dokonywać zmian bez zgody Wynajmującego."));
            document.add(new Paragraph("Wynajmujący zobowiązuje się do zapewnienia sprawnego działania instalacji wodno-kanalizacyjnej, elektrycznej i grzewczej."));

            document.add(new Paragraph("§ 5 Kaucja"));
            document.add(new Paragraph("Najemca wpłaca Wynajmującemu kaucję w wysokości " + request.getDepositAmount() + " PLN, która zostanie zwrócona po zakończeniu umowy."));

            document.add(new Paragraph("§ 6 Rozwiązanie umowy"));
            document.add(new Paragraph("Strony mogą wypowiedzieć umowę z zachowaniem " + request.getTerminationNotice() + " miesięcznego okresu wypowiedzenia."));

            document.add(new Paragraph("§ 7 Postanowienia końcowe"));
            document.add(new Paragraph("W sprawach nieuregulowanych w niniejszej umowie stosuje się przepisy Kodeksu cywilnego."));
            document.add(new Paragraph("Umowę sporządzono w dwóch jednobrzmiących egzemplarzach, po jednym dla każdej ze stron."));

            document.add(new Paragraph("\nPodpis Wynajmującego: __________________"));
            document.add(new Paragraph("\nPodpis Najemcy: __________________"));

            document.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Błąd generowania PDF", e);
        }
    }


    public byte[] generateCarSaleAgreement(CarSaleAgreementRequest request) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = getDocument(outputStream);

            document.add(new Paragraph("UMOWA KUPNA-SPRZEDAŻY POJAZDU").setBold().setFontSize(14));
            document.add(new Paragraph("Zawarta w dniu " + request.getAgreementDate() + " w " + request.getAgreementLocation() + " pomiędzy:"));

            document.add(new Paragraph("Sprzedający: " + request.getSellerName() + ", " + request.getSellerAddress() +
                    ", PESEL/NIP: " + request.getSellerPeselNip() + ", Tel: " + request.getSellerPhone()));

            document.add(new Paragraph("Kupujący: " + request.getBuyerName() + ", " + request.getBuyerAddress() +
                    ", PESEL/NIP: " + request.getBuyerPeselNip() + ", Tel: " + request.getBuyerPhone()));

            document.add(new Paragraph("§ 1 Przedmiot umowy"));
            document.add(new Paragraph("Sprzedający sprzedaje, a Kupujący kupuje pojazd o następujących danych:"));
            document.add(new Paragraph("Marka: " + request.getCarBrand()));
            document.add(new Paragraph("Model: " + request.getCarModel()));
            document.add(new Paragraph("Rok produkcji: " + request.getYear()));
            document.add(new Paragraph("Numer VIN: " + request.getVin()));
            document.add(new Paragraph("Numer rejestracyjny: " + request.getPlateNumber()));
            document.add(new Paragraph("Przebieg: " + request.getMileage() + " km"));

            document.add(new Paragraph("§ 2 Cena i sposób zapłaty"));
            document.add(new Paragraph("Strony ustalają cenę pojazdu na kwotę " + request.getPrice() + " PLN."));
            document.add(new Paragraph("Kupujący zobowiązuje się do zapłaty gotówką/przelewem na konto Sprzedającego: " + request.getPaymentMethod()));

            document.add(new Paragraph("§ 3 Oświadczenia stron"));
            document.add(new Paragraph("1. Sprzedający oświadcza, że pojazd stanowi jego własność, jest wolny od wad prawnych oraz nie jest przedmiotem zastawu."));
            document.add(new Paragraph("2. Kupujący oświadcza, że zapoznał się ze stanem technicznym pojazdu i nie wnosi zastrzeżeń."));

            document.add(new Paragraph("§ 4 Przekazanie pojazdu"));
            document.add(new Paragraph("Sprzedający przekazuje Kupującemu pojazd wraz z dokumentami: dowodem rejestracyjnym, kartą pojazdu i kluczykami."));

            document.add(new Paragraph("§ 5 Postanowienia końcowe"));
            document.add(new Paragraph("Umowę sporządzono w dwóch jednobrzmiących egzemplarzach, po jednym dla każdej ze stron."));
            document.add(new Paragraph("W sprawach nieuregulowanych niniejszą umową zastosowanie mają przepisy Kodeksu cywilnego."));

            document.add(new Paragraph("\nPodpis Sprzedającego: __________________"));
            document.add(new Paragraph("\nPodpis Kupującego: __________________"));

            document.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Błąd generowania PDF", e);
        }
    }

    private Document getDocument(ByteArrayOutputStream outputStream) throws IOException {
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        String fontPath = "fonts/arial.ttf";  // Plik czcionki w katalogu resources/fonts
        PdfFont font = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H, true);

        document.setFont(font); // Ustawienie domyślnej czcionki dla dokumentu
        return document;
    }


}