package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Estaciones estaciones = new Estaciones();
        ArrayList<Estacion> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Estaciones.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] value = line.split(";");
                if (value.length >= 12) {
                    Estacion estacion = new Estacion();

                    estacion.setCodigo(!value[0].trim().isEmpty() ? Integer.parseInt(value[0].trim()) : 0);
                    estacion.setDescripcion(value[1].trim());
                    estacion.setLatitud(!value[2].trim().isEmpty() ? Double.parseDouble(value[2].trim()) : 0.0);
                    estacion.setLongitud(!value[3].trim().isEmpty() ? Double.parseDouble(value[3].trim()) : 0.0);
                    estacion.setDireccion(value[4].trim());
                    estacion.setCp(value[5].trim());
                    estacion.setPoblacion(value[6].trim());
                    estacion.setProvincia(value[7].trim());
                    estacion.setPais(value[8].trim());
                    estacion.setCercanias(value[9].trim());
                    estacion.setFeve(value[10].trim());
                    estacion.setComun(value[11].trim());

                    list.add(estacion);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        estaciones.setListEstacion(list);

        System.out.println("Estaciones procesadas: " + list.size());

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Estaciones.class);
            javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(estaciones, new File("src/main/resources/Estaciones.xml"));
            jaxbMarshaller.marshal(estaciones, System.out);
            System.out.println("Archivo XML generado exitosamente.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}