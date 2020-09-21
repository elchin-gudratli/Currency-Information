package cbar;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ParseXmlStructure {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {


        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.println("\nEnter code");
            String code = scanner.nextLine().toUpperCase();

            if(!code.equals("-1")){
                xmlFile(code);
            }else {
                exit = false;
                System.out.println("Program Sonlandi");
            }

        }

    }

    public static void xmlFile(String code) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        final String cbar = "/Users/elchingudratli/eclipse-workspace/javaHelloWorld/src/cbar/cbar.xml";
        File file = new File(cbar);
        Document document = builder.parse(file);

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        NodeList nodeList = document.getElementsByTagName("Valute");
        System.out.println("=========================================\n");

        for (int temp = 0; temp <nodeList.getLength() ; temp++) {
            Node node = nodeList.item(temp);
           
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                if(element.getAttribute("Code").equals(code)) {
                    System.out.println("CODE: " + element.getAttribute("Code"));
                    System.out.println("Nominal: " + element.getElementsByTagName("Nominal").item(0).getTextContent());
                    System.out.println("Name: " + element.getElementsByTagName("Name").item(0).getTextContent());
                    System.out.println("Value: " + element.getElementsByTagName("Value").item(0).getTextContent());
                    break;
                 }
            }
        }
    }
}
