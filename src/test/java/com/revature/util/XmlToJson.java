package com.revature.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.Scanner;

public class XmlToJson {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("target/surefire-reports/TEST-com.revature.repositories.UserRepoImplementationTest.xml");
            Scanner myReader = new Scanner(xmlFile);

            StringBuilder xmlString = new StringBuilder();
            while (myReader.hasNextLine()) {
                xmlString.append(myReader.nextLine());
                //xmlString.append('\n');
            }
            myReader.close();

            System.out.println(xmlString);

            XmlMapper xmlMapper = new XmlMapper();
            JsonNode node = xmlMapper.readTree(xmlString.toString().getBytes());
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writeValueAsString(node);

            System.out.println(json);

            BufferedWriter writer = new BufferedWriter(new FileWriter("target/surefire-reports/TEST-com.revature.repositories.UserRepoImplementationTest.json"));
            writer.write(json);

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
