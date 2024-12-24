package com.aluracursos.conversor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class Conversor {

 void guardarJson(Moneda moneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String archivo = moneda.base_code() + "_to_" + moneda.target_code() + ".json";

        try (FileWriter escritor = new FileWriter(archivo)) {
            escritor.write(gson.toJson(moneda));
        }
    }
}
