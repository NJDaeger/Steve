package com.njdaeger.steve.core.internal;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

public class ArgumentAdapterModifier<T> implements ArgumentType<T> {
    
    public ArgumentAdapterModifier() {
        
    }
    
    public <S> T parse(StringReader reader) throws CommandSyntaxException {
        return null;
    }
}
