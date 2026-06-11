public class Test {
    public static void main(String[] args) {
        
        System.out.println("Client requests a Word Document");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.processNewDocument();
        
        System.out.println("\nClient requests a PDF Document");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.processNewDocument();

        System.out.println("\nClient requests an Excel Document");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.processNewDocument();
    }
}