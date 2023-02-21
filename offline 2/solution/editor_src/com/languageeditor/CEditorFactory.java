package com.languageeditor;

import com.aesthetics.Aesthetics;
import com.aesthetics.Aesthetics1;
import com.parser.CParser;
import com.parser.Parser;


public class CEditorFactory extends LanguageEditorFactory
{
    private static CEditorFactory cEditorFactory;
    private CEditorFactory(){}

    public static CEditorFactory getInstance()
    {
        if(cEditorFactory == null){
            cEditorFactory = new CEditorFactory();
        }

        return cEditorFactory;
    }

    @Override
    public Parser createParser()
    {
        return new CParser();
    }

    @Override
    public Aesthetics createAesthetics()
    {
        return new Aesthetics1();
    }
}
