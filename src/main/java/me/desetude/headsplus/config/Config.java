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

package me.desetude.headsplus.config;

import lombok.Getter;
import me.desetude.headsplus.HeadsPlus;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

@Getter
public class Config {

    private final FileConfiguration config;
    private final File file;

    Config(FileConfiguration config, File file) {
        this.config = config;
        this.file = file;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException ex) {
            LoggerFactory.getLogger(HeadsPlus.class).error("Could not save file " + file.getName() + "!", ex);
        }
    }

    public static ConfigBuilder builder(Plugin plugin) {
        return new ConfigBuilder(plugin);
    }

}
