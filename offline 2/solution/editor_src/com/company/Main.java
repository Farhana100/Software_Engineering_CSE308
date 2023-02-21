package com.company;

import com.aesthetics.Aesthetics;
import com.languageeditor.CEditorFactory;
import com.languageeditor.CppEditorFactory;
import com.languageeditor.LanguageEditorFactory;
import com.languageeditor.PythonEditorFactory;
import com.parser.Parser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String fileName;

        System.out.println("Enter file name (e.g myfile.cpp):");

        Scanner scanner = new Scanner(System.in);
        fileName = scanner.nextLine();

        LanguageEditorFactory factory;

        switch (fileName.toLowerCase().trim().split("\\.")[1])
        {
            case "c" -> factory = CEditorFactory.getInstance();
            case "cpp" -> factory = CppEditorFactory.getInstance();
            case "py" -> factory = PythonEditorFactory.getInstance();
            default -> throw new IllegalStateException("Unexpected value: " + fileName);
        }

        Parser parser = factory.createParser();
        Aesthetics aesthetics = factory.createAesthetics();

        parser.parse(fileName);
        aesthetics.use();
    }
}
