public class FactoryMethodTest
{

    public static void main(String[] args)
    {
        System.out.println("=== Factory Method Pattern Test ===\n");

        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories)
        {
            Document doc = factory.createDocument();
            doc.open();
        }
    }
}
