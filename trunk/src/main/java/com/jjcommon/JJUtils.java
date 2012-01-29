package com.jjcommon;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JJUtils {

    /**
     * Serializes the object to a file (also known as marshaling).
     * @param obj - The object to be serialized.
     * @param pathname - File name including path to serialize to.
     * @throws JAXBException
     */
    public static void SerializeToXml(Object obj, String pathname) throws JAXBException {
        SerializeToXml(obj, new File(pathname));
    }

    /**
     * Serializes the object to a file (also known as marshaling).
     * @param obj - The object to be serialized.
     * @param file - File to serialize to.
     * @throws JAXBException
     */
    public static void SerializeToXml(Object obj, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(obj, file);
    }
}
