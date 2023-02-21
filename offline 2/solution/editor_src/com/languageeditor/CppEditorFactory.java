package com.languageeditor;

import com.aesthetics.Aesthetics;
import com.aesthetics.Aesthetics2;
import com.parser.CppParser;
import com.parser.Parser;

public class CppEditorFactory extends LanguageEditorFactory
{
    private static CppEditorFactory cppEditorFactory;
    private CppEditorFactory(){}

    public static CppEditorFactory getInstance()
    {
        if(cppEditorFactory == null){
            cppEditorFactory = new CppEditorFactory();
        }

        return cppEditorFactory;
    }

    @Override
    public Parser createParser()
    {
        return new CppParser();
    }

    @Override
    public Aesthetics createAesthetics()
    {
        return new Aesthetics2();
    }
}
