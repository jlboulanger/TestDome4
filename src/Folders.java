import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        var document = builder.parse(new InputSource(new StringReader(xml)));
        NodeList folders = document.getElementsByTagName("folder");
        Collection<String> res = new ArrayList<>();
        for (int i = 0; i < folders.getLength(); i++) {
            Node ni = folders.item(i);
            if (ni.hasAttributes() && ni.getAttributes().getNamedItem("name") != null) {
                String folderName = ni.getAttributes().getNamedItem("name").getNodeValue();
                if(folderName.charAt(0) == startingLetter)
                    res.add(ni.getAttributes().getNamedItem("name").getNodeValue());
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
