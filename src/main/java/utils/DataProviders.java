package utils;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "addNewContactWithCsv")
    public Iterator<Object[]> addNewUserWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstName(split[0]).setLastName(split[1])
                    .setEmail(split[2]).setPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider(name = "addNewContact")
    public Iterator<Object[]> addNewUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Amir", "Amir", "amir@gm.com", "Hamburg"});
        list.add(new Object[]{"Amir", "Karam", "amir@gm.com", "Hamburg"});
        list.add(new Object[]{"Amir", "Amur", "amir@gm.com", "Hamburg"});
        return list.iterator();
    }
}
