package fr.lookzay.generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import fr.lookzay.value.Infos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class BlockGenerator {

    private static String path = Infos.path;

    public static void main(String[] args){
        writeBlockJson("test", "test");
        writeBlockstates("test");
    }

    public static void writeBlockJson(String blockName, String textureName){
        try
        {
            ItemGenerator.folderGenerate(path);

            Writer writer = new OutputStreamWriter(new FileOutputStream(path + "models\\block\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("parent").value("block/cube_all");
            jw.name("textures");
            jw.beginObject();
            jw.name("all").value("blocks/" + textureName);
            jw.endObject();
            jw.endObject();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeBlockstates(String blockName){
        try
        {
            ItemGenerator.folderGenerate(path);

            Writer writer = new OutputStreamWriter(new FileOutputStream(path + "blockstates\\" + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("variants");
            jw.beginObject();
            jw.name("normal");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.endObject();
            jw.endObject();
            jw.endObject();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
