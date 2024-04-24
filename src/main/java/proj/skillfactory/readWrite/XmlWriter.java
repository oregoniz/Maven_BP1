package proj.skillfactory.readWrite;

import proj.skillfactory.objects.AllInfo;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {

    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void generateXmlReq(AllInfo allInfo) {

        try {
            logger.log(Level.INFO, "XML заптсь начата");

            JAXBContext jaxbContext = JAXBContext.newInstance(AllInfo.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

             try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "xmlReqs директория создана");
            } catch (IOException ioEx) {
                logger.log(Level.FINE, "xmlReqs директория уже существует", ioEx);
            }

          /*  String userHome = System.getProperty("user.home");
            File directoryXML = new File(userHome, "jsonReqs");
            if (!directoryXML.exists()) {
                directoryXML.mkdir();
                logger.log(Level.INFO, "jsonReqs директория создана");
            } else logger.log(Level.INFO, "jsonReqs уже существует");*/

            File writeFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");

            marshaller.marshal(allInfo, writeFile);

        } catch (JAXBException jaxbEx) {
            logger.log(Level.SEVERE, "XML ошибка записи", jaxbEx);
            return;
        }

        logger.log(Level.INFO, "XML запись успешно завершена");
    }
}
