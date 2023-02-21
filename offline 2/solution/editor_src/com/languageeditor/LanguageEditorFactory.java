package com.languageeditor;

import com.aesthetics.Aesthetics;
import com.parser.Parser;

public abstract class LanguageEditorFactory
{
    public abstract Parser createParser();
    public abstract Aesthetics createAesthetics();
}
