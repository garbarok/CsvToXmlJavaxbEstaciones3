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

                    estacion.setCodigo(value.length > 0 && !value[0].trim().isEmpty() ? Integer.parseInt(value[0].trim()) : 0);
                    estacion.setDescripcion(value.length > 1 ? value[1].trim() : "");
                    estacion.setLatitud(value.length > 2 && !value[2].trim().isEmpty() ? Double.parseDouble(value[2].trim()) : 0.0);
                    estacion.setLongitud(value.length > 3 && !value[3].trim().isEmpty() ? Double.parseDouble(value[3].trim()) : 0.0);
                    estacion.setDireccion(value.length > 4 ? value[4].trim() : "");
                    estacion.setCp(value.length > 5 ? value[5].trim() : "");
                    estacion.setPoblacion(value.length > 6 ? value[6].trim() : "");
                    estacion.setProvincia(value.length > 7 ? value[7].trim() : "");
                    estacion.setPais(value.length > 8 ? value[8].trim() : "");
                    estacion.setCercanias(value.length > 9 ? value[9].trim() : "");
                    estacion.setFeve(value.length > 10 ? value[10].trim() : "");
                    estacion.setComun(value.length > 11 ? value[11].trim() : "");

                    list.add(estacion);
                } else {
                    System.out.println("Línea con formato incorrecto: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        estaciones.setListEstacion(list);

        System.out.println("Número de estaciones procesadas: " + list.size());

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