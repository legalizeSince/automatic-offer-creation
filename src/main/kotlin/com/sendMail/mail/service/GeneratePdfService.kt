package com.sendMail.mail.service

import com.sendMail.mail.domain.Pdf
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDType1Font
import org.apache.pdfbox.pdmodel.font.Standard14Fonts
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


@Service
class GeneratePdfService {


    fun generatePDF(pdf:Pdf){


        val document = PDDocument()
        val my_page = PDPage()
        document.addPage(my_page);

        val contentStream = PDPageContentStream(document, my_page)


        //Begin the Content stream
        contentStream.beginText()

        //Setting the position for the line
        contentStream.newLineAtOffset(25f, 700f)

        val text = "This is the sample document and we are adding content to it."

        contentStream.setFont( PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12F);

        //Adding text in the form of string
        contentStream.showText(text)


        //Ending the content stream
        contentStream.endText()

        println("Content added")


        //Closing the content stream
        contentStream.close()


        document.save("C:/PdfBox/angebot.pdf");


        val inFileBytes = Files.readAllBytes(Paths.get("C:/PdfBox/angebot.pdf"))
        val encoded = Base64.getEncoder().encode(inFileBytes)
        println(encoded)
        print("Successfully ")

    }
}