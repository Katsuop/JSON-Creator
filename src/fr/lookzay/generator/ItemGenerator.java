package fr.lookzay.generator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import fr.lookzay.value.Infos;
import fr.lookzay.Main;
import fr.lookzay.value.ValueItemBase;
import fr.lookzay.value.ValueItemTools;

import java.io.*;
public class ItemGenerator {

    private static String path = Infos.path;

    private static File fileDir = new File(path);
    private static File modelsDir = new File(path + "models\\");
    private static File itemDir = new File(path + "models\\item\\");
    private static File blockDir = new File(path + "models\\block\\");
    private static File blockstatesDir = new File(path + "blockstates\\");

    private double t;


    public static void main(String[] args) {
        writeItemJson("cocaine", "cocaine", false);
    }

    public static void folderGenerate(String path){;
        if(!fileDir.exists() || !modelsDir.exists() || !itemDir.exists() || !blockDir.exists() || !blockstatesDir.exists())
        {
            fileDir.mkdirs();
            modelsDir.mkdirs();
            itemDir.mkdirs();
            blockDir.mkdirs();
            blockstatesDir.mkdirs();
            Main.print("Dossiers vienne d'être générée");
        } else {
            Main.print("Dossiers déjà générée");
        }
    }

    public static void writeItemJson(String itemName, String textureName, boolean isTool){
        try
        {
            folderGenerate(path);

            Writer writer = new OutputStreamWriter(new FileOutputStream(path + "models\\item\\" + itemName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("parent").value("builtin/generated");
            jw.name("textures");
            jw.beginObject();
            jw.name("layer0").value("items/" + textureName);
            jw.endObject();
            jw.name("display").beginObject();
            jw.name("thirdperson").beginObject();
            if(isTool){
                jw.name("rotation").beginArray().value(ValueItemTools.ThirdPersonRotate1.getValue()).value(ValueItemTools.ThirdPersonRotate2.getValue()).value(ValueItemTools.ThirdPersonRotate3.getValue()).endArray();
                jw.name("translation").beginArray().value(ValueItemTools.ThirdPersonTranslation1.getValue()).value(ValueItemTools.ThirdPersonTranslation2.getValue()).value(ValueItemTools.ThirdPersonTranslation3.getValue()).endArray();
                jw.name("scale").beginArray().value(ValueItemTools.ThirdPersonScale.getValue()).value(ValueItemTools.ThirdPersonScale.getValue()).value(ValueItemTools.ThirdPersonScale.getValue()).endArray();
            } else{
                jw.name("rotation").beginArray().value(ValueItemBase.ThirdPersonRotate1.getValue()).value(ValueItemBase.ThirdPersonRotate2.getValue()).value(ValueItemBase.ThirdPersonRotate3.getValue()).endArray();
                jw.name("translation").beginArray().value(ValueItemBase.ThirdPersonTranslation1.getValue()).value(ValueItemBase.ThirdPersonTranslation2.getValue()).value(ValueItemBase.ThirdPersonTranslation3.getValue()).endArray();
                jw.name("scale").beginArray().value(ValueItemBase.ThirdPersonScale.getValue()).value(ValueItemBase.ThirdPersonScale.getValue()).value(ValueItemBase.ThirdPersonScale.getValue()).endArray();
            }
            jw.endObject();
            jw.name("firstperson").beginObject();
            jw.name("rotation").beginArray().value(ValueItemBase.FirstPersonRotate1.getValue()).value(ValueItemBase.FirstPersonRotate2.getValue()).value(ValueItemBase.FirstPersonRotate3.getValue()).endArray();
            jw.name("translation").beginArray().value(ValueItemBase.FirstPersonTranslation1.getValue()).value(ValueItemBase.FirstPersonTranslation2.getValue()).value(ValueItemBase.FirstPersonTranslation3.getValue()).endArray();
            jw.name("scale").beginArray().value(ValueItemBase.FirstPersonScale.getValue()).value(ValueItemBase.FirstPersonScale.getValue()).value(ValueItemBase.FirstPersonScale.getValue()).endArray();
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

    public static void writeCustomItemJson(String itemName, String textureName, double tr1, double tr2, double tr3, double tt1, double tt2, double tt3, double ts1, double ts2, double ts3, double fr1, double fr2, double fr3, double ft1, double ft2, double ft3, double fs1, double fs2, double fs3){
        try
        {
            folderGenerate(path);

            Writer writer = new OutputStreamWriter(new FileOutputStream(path + "models\\item\\" + itemName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("parent").value("builtin/generated");
            jw.name("textures");
            jw.beginObject();
            jw.name("layer0").value("items/" + textureName);
            jw.endObject();
            jw.name("display").beginObject();
            jw.name("thirdperson").beginObject();
            jw.name("rotation").beginArray().value(tr1).value(tr2).value(tr3).endArray();
            jw.name("translation").beginArray().value(tt1).value(tt2).value(tt3).endArray();
            jw.name("scale").beginArray().value(ts1).value(ts2).value(ts3).endArray();
            jw.endObject();
            jw.name("firstperson").beginObject();
            jw.name("rotation").beginArray().value(fr1).value(fr2).value(fr3).endArray();
            jw.name("translation").beginArray().value(ft1).value(ft2).value(ft3).endArray();
            jw.name("scale").beginArray().value(fs1).value(fs2).value(fs3).endArray();
            jw.endObject();
            jw.endObject();
            jw.endObject();
            writer.close();

            Main.print("Fichier " + itemName + "vient d'être générée dans /export/models/item/");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

