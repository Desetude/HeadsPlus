/*
 *     Copyright (c) 2015. Desetude (devdesetude@gmail.com)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.desetude.headsplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class HPCommandListener implements CommandExecutor {

    private HPCommandManager headsCommandManager;

    public HPCommandListener(HPCommandManager subCommandManager) {
        this.headsCommandManager = subCommandManager;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        String newCommand = args.length > 0 && headsCommandManager.containsCommand(args[0]) ? args[0] : "?";
        headsCommandManager.getHPCommand(newCommand).run(commandSender, Arrays.asList(args));
        return true;
    }

}
