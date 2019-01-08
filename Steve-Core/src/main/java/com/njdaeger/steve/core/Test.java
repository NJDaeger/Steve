package com.njdaeger.steve.core;

import com.njdaeger.steve.core.annotation.Command;
import com.njdaeger.steve.core.annotation.Flag;
import com.njdaeger.steve.core.annotation.Optional;
import com.njdaeger.steve.core.argument.Arguments;

public class Test {

    // /command []
    @Flag("-e") //THis would indicate a flag which is
    @Command(name = "nickname",
            aliases = {"nick", "name"},
            min = 1,
            description = "Nickname someone",
            usage = "/nick [world] [player] <nickname>"
    )
    /*

    When this command is called, we get the arguments of this method in order.

    1. We create the Arguments object
    2. We create the CommandContext object (if specified)
    3. We begin looking for the other arguments which are not usually known
        - We assume that each argument only consumes 1 word from the arguments array.
        - When the argument is matched, we take it out of the arguments array and then move on to the next argument

     */
    public void nickname(Arguments args, CommandContext context, @Optional("world") String world, @Optional String player, String nickname) {

    }

    public void command(Arguments args, CommandContext<Test> context) {

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
