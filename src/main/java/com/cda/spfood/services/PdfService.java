package com.cda.spfood.services;

import com.cda.spfood.entities.Recipe;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public byte[] generateRecipePdf(Recipe recipe) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            Paragraph title = new Paragraph("RECETTE : " + recipe.getName());
            document.add(title);

            Paragraph info = new Paragraph()
                    .add("Créée par : ").setBold()
                    .add(recipe.getOwner().getFirstname() + " " + recipe.getOwner().getLastname())
                    .add("Visible : ").setBold()
                    .add(recipe.getVisibility() ? "Oui" : "Non");
            document.add(info);

            document.add(new Paragraph(" "));

            Paragraph details = new Paragraph()
                    .add("Temps de préparation : ").setBold()
                    .add(recipe.getPreparationTime() + " minutes\n")
                    .add("Temps de cuisson : ").setBold()
                    .add(recipe.getCookingTime() + " minutes\n")
                    .add("Calories : ").setBold()
                    .add(recipe.getCalories() + " kcal");
            document.add(details);

            document.close();
        } catch (Exception e) {
            throw new IOException("Erreur lors de la génération du PDF", e);
        }

        return out.toByteArray();
    }
}

