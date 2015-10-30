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

import java.util.HashMap;
import java.util.Map;

public class HPCommandManager {

    private Map<String, HPCommand> hpCommands;

    public HPCommandManager() {
        hpCommands = new HashMap<>();
    }

    public HPCommand getHPCommand(String name) {
        return hpCommands.get(name);
    }

    public void registerHPCommand(HPCommand subCommand, String... names) {
        for (String name : names) {
            hpCommands.put(name, subCommand);
        }
    }

    public boolean containsCommand(String name) {
        for (String string : hpCommands.keySet()) {
            if (name.equals(string.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}
