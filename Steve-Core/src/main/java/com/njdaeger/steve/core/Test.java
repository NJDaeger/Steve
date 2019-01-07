package com.njdaeger.steve.core;

import com.njdaeger.steve.core.argument.Arguments;

import java.lang.reflect.Proxy;

public class Test {

    // /command []
    @Flag("-e") //THis would indicate a flag which is
    @Command(name = "command")
    public void someCommand(DefaultContext context, @Fallback("world") String world, @Optional String player, /*A flag in a parameter would indicate that, if present, the flag would try to parse for whatever type the annotation is attached to. This case is boolean*/@Flag("-a") boolean skip) {
    }

    public void command(Arguments args, ) {

    }

   /*

    @Completion("command")
    public void completion() {
        if (context.isPrevious(BooleanAdapter.class) && !context.isCurrent(DoubleAdapter.class)) context.incorrect(int index)
    }

    */

   public void completion() {

   }

   private static void tst(TestReference ref) {

   }


}
