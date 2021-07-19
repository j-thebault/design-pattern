package org.afcepf.pattern.solution.behavior.command;

import org.afcepf.pattern.solution.behavior.command.commands.Command;

import java.util.ArrayList;
import java.util.List;

// Cette classe très simple accumule les commandes et les exécutes.
public class CookCommandsInvoker {

    private final List<Command> commands = new ArrayList<>();

    public CookCommandsInvoker addCommands (List<Command> commands) {
        this.commands.addAll(commands);
        return this;
    }

    public void executeCommands(){
        commands.forEach(Command::execute);
    }
}
