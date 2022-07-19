package primas.esercizio1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class AnnotationGames {

    public static void main(String[] args) throws Exception {

        Automobile auto = new Automobile("Toyota", "Corolla", 2001, null, null, null);
        Assicurazione assicur = new Assicurazione(LocalDate.parse("2020-02-17"), LocalDate.parse("2023-07-09"));
        auto.setAssicurazione(assicur);
        //System.out.println("Auto da serializzare: " + auto);
        JSONSimpleSerializer my_serializer = new JSONSimpleSerializer();
        my_serializer.serialize(auto);
        Gson gson = new Gson();
        List<Object> list = getListObjectFromFileJson(gson);

        String jsonString = gson.toJson(list.get(5));
        Automobile auto3 = my_serializer.deserialize(jsonString, Automobile.class);
        System.out.println("Auto deserializzata: " + auto3);

    }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static List<Object> getListObjectFromFileJson(Gson gson) throws Exception {
        gson = new Gson();
        Path path = Paths.get(AnnotationGames.class.getResource("/primas/resources/json/auto.json").toURI());
        Type listType = new TypeToken<List<Object>>() {}.getType();
        return gson.fromJson(readFileAsString(path.toString()), listType);
    }
}

