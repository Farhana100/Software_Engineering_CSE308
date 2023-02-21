package com.languageeditor;

import com.aesthetics.Aesthetics;
import com.aesthetics.Aesthetics3;
import com.parser.Parser;
import com.parser.PythonParser;

public class PythonEditorFactory extends LanguageEditorFactory
{
    private static PythonEditorFactory pythonEditorFactory;
    private PythonEditorFactory(){}

    public static PythonEditorFactory getInstance()
    {
        if(pythonEditorFactory == null){
            pythonEditorFactory = new PythonEditorFactory();
        }

        return pythonEditorFactory;
    }

    @Override
    public Parser createParser()
    {
        return new PythonParser();
    }

    @Override
    public Aesthetics createAesthetics()
    {
        return new Aesthetics3();
    }
}
