/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 *  IGNORAR, SOLO EJECUTAR SI SE MODIFICA Lexer.flex
 */
public class CrearLexer {
    /*public static void main(String[] args) {
        String ruta = "C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/src/codigo/Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }*/
   public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/src/codigo/Lexer.flex";
        String ruta2 = "C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/src/codigo/Sintaxis.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/src/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/sym.java"), 
                Paths.get("C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/src/codigo/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/src/codigo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/Sintax.java"), 
                Paths.get("C:/Users/Usuario.ATHENEA/Desktop/AnalizadorLexico/src/codigo/Sintax.java")
        );
    }    
}
